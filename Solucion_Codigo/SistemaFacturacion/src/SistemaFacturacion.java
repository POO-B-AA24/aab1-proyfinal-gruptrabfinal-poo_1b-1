
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SistemaFacturacion {
    private String cliente;//
    private int cedula;//
    private String direccion;//
    private List<Producto> inventario;

    public SistemaFacturacion(String cliente, int cedula, String direccion, List<Producto> inventario) {
        this.cliente = cliente;
        this.cedula = cedula;
        this.direccion = direccion;
        this.inventario = inventario;
    }

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

    public List<Factura> listFacturas(int limFacturas, String fecha) {
        List<Producto> carrito = new ArrayList<>();
        List<Factura> facturas = new ArrayList<Factura>();
        for (int i = 0; i < limFacturas; i++) {
            carrito = generadorCarrito();
            Factura factura = new Factura(carrito, cliente, cedula, direccion, fecha);
            factura.procesoFactura();
            facturas.add(factura);
        }
        return facturas;
    }

}