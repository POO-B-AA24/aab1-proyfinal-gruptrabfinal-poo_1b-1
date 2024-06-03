package Controller;


import java.util.List;
import java.util.Random;

import Model.EntradaFactura;
import Model.EntradaInventarioSerializacion;
import Model.SalidaFactura;
import Model.SalidaInventario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class SistemaFacturacion {
    // fecha
    public LocalDate fechaLocal = LocalDate.now();
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String fecha = fechaLocal.format(formatter);
    //
    // RUTAS
    public String rutaFacturas = "LeerArchivos\\Facturas.csv";
    public String rutaEstadistica = "LeerArchivos\\Estadisticas.csv";
    public String rutaInventario = "LeerArchivos\\Inventario.csv";
    //
    // PATHS
    public String pathFacturas = "Serializables\\Facturas.dat";
    public String pathInventario = "Serializables\\Inventario.dat";
    //
    private String cliente;//
    private int cedula;//
    private String direccion;//
    private List<Producto> inventario;
    private List<Factura> facturasDeserializadas = new ArrayList<>();
    private List<Producto> productosDeserializados = new ArrayList<>();

    public SistemaFacturacion(String cliente, int cedula, String direccion, List<Producto> inventario) {
        this.cliente = cliente;
        this.cedula = cedula;
        this.direccion = direccion;
        this.inventario = inventario;
    }

    public void iniciarSistema(){
        List<Factura> listFacturas = listaDeFacturas(10, fecha);
        GeneradorArchivos generadorArchivos = new GeneradorArchivos(listFacturas, inventario, rutaFacturas, rutaEstadistica, rutaInventario);
        generadorArchivos.generarArchivos();
        serializarObjetos(listFacturas, inventario);
        deserializarObjetos(listFacturas, inventario);
    }



    //SERIALIZACION DE OBJETOS
    public void serializarObjetos(List<Factura> listFacturas,List<Producto> inventario){
        serializarFactura(listFacturas);
        serializarInventario(inventario);
    }

    public void serializarFactura(List<Factura> listFacturas){
        FileOutputStream facturasFSOS;
        try {
            facturasFSOS = new FileOutputStream(pathFacturas);
            SalidaFactura serializarFactura = new SalidaFactura(listFacturas,facturasFSOS);
            serializarFactura.salidaFacturaArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("serializacion factura "+e);
        }
    }

    public void serializarInventario(List<Producto> inventario){
        FileOutputStream inventarioFSOS;
        try {
            inventarioFSOS = new FileOutputStream(pathInventario);
            SalidaInventario serializarInventario = new SalidaInventario(inventario,inventarioFSOS);
            serializarInventario.salidaInventarioArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("serializacion inventario "+e);
            
        }
    }
    //
    //Obtener lista de objetos deserializados
    public List<Factura> getFacturasDeserializadas(){
        return facturasDeserializadas;
    }
    public List<Producto> getProductoDeserializado(){
        return productosDeserializados;
    }
    //
    //////////
    //DESERIALIZACION DE OBJETOS
    public void deserializarObjetos(List<Factura> listFacturas,List<Producto>inventario){
        deserializarFactura(listFacturas);
        deserializarInventario(inventario);
    }

    public void deserializarFactura(List<Factura> listFacturas){
        try {
        FileInputStream facturasFIS = new FileInputStream(pathFacturas);
            EntradaFactura entradaFactura = new EntradaFactura(facturasFIS);
            facturasDeserializadas = entradaFactura.lecturaFacturaArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("deserializacion factura "+e);

        }
    }
    public void deserializarInventario(List<Producto> inventario){
        FileInputStream inventarioFIS;
        try {
            inventarioFIS = new FileInputStream(pathInventario);
            EntradaInventarioSerializacion entradaInventario = new EntradaInventarioSerializacion(inventarioFIS);
            productosDeserializados = entradaInventario.lecturaInventarioArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("deserializacion inventario "+e);
        }
    }
    //

    public List<Producto> generadorCarrito() {
        Random ran = new Random();
        List<Producto> carrito = new ArrayList<Producto>();
        int limProductos = ran.nextInt(5) + 1;
        for (int i = 0; i < limProductos; i++) {
            int codigo = ran.nextInt(100) + 1;
            int cantidad = ran.nextInt(10) + 1;
            for (Producto producto : inventario) {
                if (producto.codigo == codigo) {
                    Producto prodfac = producto.productoParaFactura(cantidad);
                    if (prodfac != null) {
                        carrito.add(prodfac);
                    }
                }
            }
        }
        return carrito;
    }

    public List<Factura> listaDeFacturas(int limFacturas, String fecha) {
        List<Producto> carrito = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();
        for (int i = 0; i < limFacturas; i++) {
            carrito = generadorCarrito();
            Factura fact = new Factura(carrito, cliente, cedula, direccion, fecha);
            fact.procesoFactura();
            facturas.add(fact);
        }
        return facturas;
    }

}