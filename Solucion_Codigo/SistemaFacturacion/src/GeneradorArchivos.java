import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class GeneradorArchivos {
    private List<Factura> listFacturas;
    private List<Producto> inventario;
    private String rutaFactura;
    private String rutaEstadistica;
    private String rutaInventario;

    GeneradorArchivos(List<Factura> listFacturas, List<Producto> inventario, String rutaFactura, String rutaEstadistica,
            String rutaInventario) {
        this.listFacturas = listFacturas;
        this.inventario = inventario;
        this.rutaFactura = rutaFactura;
        this.rutaEstadistica = rutaEstadistica;
        this.rutaInventario = rutaInventario;
    }

    public void generarArchivos() {
        generarFactura();
        generarInventario();
        generarEstadistica();
    }

    public void generarFactura() {
        DecimalFormat df = new DecimalFormat("#.00");
        File facturas = new File(rutaFactura);

        try (FileWriter fw = new FileWriter(facturas, true)) {
            if (!facturas.exists()) {
                facturas.createNewFile();
            }
            for (Factura factura : listFacturas) {
                fw.write(
                        "----------------------------------------------- SUPERMAXI -----------------------------------------------;\r\n");
                fw.write(
                        "                                           DIRECCION SUCURSAL:                                           ;\r\n");
                fw.write(
                        "                                           AV. 18 DE NOVIEMBRE                                           ;\r\n");
                fw.write(
                        "                                             LOJA - ECUADOR                                              ;\r\n");
                fw.write(
                        "                                            RUC:1790016919001                                            ;\r\n");
                fw.write(
                        "---------------------------------------------------------------------------------------------------------;\r\n");
                fw.write("COD;Descipcion;Cant;Descuento;PrecioU;Total\r\n");
                for (Producto producto : factura.carrito) {
                    String formatoTotal = String.format(df.format(producto.precio * producto.cantidad));

                    fw.write(producto.codigo + ";" + producto.nombre + ";" + producto.cantidad + ";"
                            + producto.descuento + ";" + producto.precio + ";"
                            + formatoTotal + "\r\n");
                }
                fw.write(
                        "---------------------------------------------------------------------------------------------------------;\r\n");
                fw.write("SUBTOTAL;" + df.format(factura.subTotal) + ";\r\n");
                fw.write("DESCUENTO;" + df.format(factura.sumaDescuentos) + ";\r\n");
                fw.write("AHORRO POR AFILIACION;" + df.format(factura.subDescuentoAfiliado) + ";\r\n");
                fw.write("IVA;" + factura.iva + "%" + ";\r\n");
                fw.write("SUBIVA;" + factura.subIva + ";\r\n");
                fw.write("TOTAL;" + factura.total + ";\r\n");
                fw.write("--------------------------------------------------------\r\n");
                fw.write("CLIENTE;" + factura.cliente + ";\r\n");
                fw.write("CEDULA;" + factura.cedula + ";\r\n");
                fw.write("DIRECCION;" + factura.direccion + ";\r\n");
                fw.write("FACTURA Nro;" + factura.numFactura + ";\r\n");
                fw.write("FEHCA EMISION (dd/mm/aaaa);" + factura.fecha + ";\r\n");
                fw.write("AUTORIZACION SRI;" + factura.autorizacionSRI + ";\r\n");
                fw.write("Forma de Pago;" + factura.formaPago + ";\r\n");
                fw.write("========== DEDUCIBLES ==========" + ";\r\n");
                fw.write("Vivienda;" + factura.hogarD + "% " + ";\r\n");
                fw.write("Educacion;" + factura.educacionD + "% " + ";\r\n");
                fw.write("Alimentacion;" + factura.alimentacionD + "% " + ";\r\n");
                fw.write("Vestimenta;" + factura.vestimentaD + "% " + ";\r\n");
                fw.write("Salud;" + factura.saludD + "% " + ";\r\n");
                fw.write("---------------------------------" + ";\r\n");
            }
        } catch (IOException e) {
            System.out.println("EROR AL CREAR ARCHIVO " + e);
        }
    }

    public void generarInventario() {
        try (FileWriter fw = new FileWriter(rutaInventario)) {
            for (Producto producto : inventario) {
                fw.write(producto.codigo + ";" + producto.nombre + ";" + producto.precio + ";"
                        + producto.cantidad + ";" + producto.categoria + ";" + producto.caducidad
                        + "\r\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void generarEstadistica() {
        for (Factura factura : listFacturas) {
            for (Producto producto : factura.carrito) {
                try (FileWriter fw = new FileWriter(rutaEstadistica, true)) {
                    File archivo = new File("Estadistica\\Estadisticas.csv");
                    if (archivoVacio(rutaEstadistica)) {
                        fw.write(factura.fecha + ";" + producto.codigo + ";" + producto.nombre + ";"
                                + producto.categoria + ";" + producto.cantidad + "\r\n");
                    } else {
                        archivo.createNewFile();
                        fw.write("Fecha;Codigo;Nombre;Categoria;Ventas \r\n");
                        fw.write(factura.fecha + ";" + producto.codigo + ";" + producto.nombre + ";"
                                + producto.categoria + ";" + producto.cantidad + "\r\n");
                    }
                } catch (IOException e) {
                    System.out.println("Error al encontrar archivo " + e);
                }
            }

        }

    }

    public static boolean archivoVacio(String archivo) {
        File file = new File(archivo);
        if (!file.exists()) {
            return false;
        }
        return file.length() > 0;
    }
}
