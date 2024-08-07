package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
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
        generarArchivoEstadistica();
    }

    private void generarFactura() {
        DecimalFormat formato = new DecimalFormat("#.##");

        File facturas = new File(rutaFactura);

        try (FileWriter fw = new FileWriter(rutaFactura, true)) {
            if (!facturas.exists()) {
                facturas.createNewFile();
            }
            for (Factura factura : listFacturas) {
                String cadena_subTotal = formato.format(factura.subTotal);
                String cadena_subIva = formato.format(factura.subIva);
                String cadena_sumaDescuentos = formato.format(factura.sumaDescuentos);
                String cadena_subDescuentoAfiliado = formato.format(factura.subDescuentoAfiliado);
                String cadena_total = formato.format(factura.total);

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
                    String formatoTotal = String.format(formato.format(producto.precio * producto.cantidad));

                    fw.write(producto.codigo + ";" + producto.nombre + ";" + producto.cantidad + ";"
                            + producto.descuento + ";" + producto.precio + ";"
                            + formatoTotal + "\r\n");
                }
                fw.write(
                        "---------------------------------------------------------------------------------------------------------;\r\n");
                fw.write("SUBTOTAL;" + cadena_subTotal + ";\r\n");
                fw.write("DESCUENTO;" + cadena_sumaDescuentos + ";\r\n");
                fw.write("AHORRO POR AFILIACION;" + cadena_subDescuentoAfiliado + ";\r\n");
                fw.write("IVA;" + factura.iva + "%" + ";\r\n");
                fw.write("SUBIVA;" + cadena_subIva + ";\r\n");
                fw.write("TOTAL;" + cadena_total + ";\r\n");
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
            System.out.println("EROR AL CREAR ARCHIVO en generador Archivos" + e);
        }
    }

    private void generarInventario() {
        try (FileWriter fw = new FileWriter(rutaInventario)) {
            for (Producto producto : inventario) {
                fw.write(producto.codigo + ";" + producto.nombre + ";" + producto.precio + ";"
                        + producto.cantidad + ";" + producto.categoria + ";" + producto.caducidad
                        + "\r\n");
            }
        } catch (Exception e) {
            System.out.println("ERROR EN GENERAR INVENTARIO " + e);
        }
    }

    private void generarArchivoEstadistica() {
        for (Factura factura : listFacturas) {
            for (Producto producto : factura.carrito) {
                try (FileWriter fw = new FileWriter(rutaEstadistica, true)) {
                    File archivo = new File(rutaEstadistica);
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
                    System.out.println("Error al encontrar archivo en generar estadistica" + e);
                }
            }

        }

    }

    private boolean archivoVacio(String archivo) {
        File file = new File(archivo);
        if (!file.exists()) {
            return false;
        }
        return file.length() > 0;
    }
}
