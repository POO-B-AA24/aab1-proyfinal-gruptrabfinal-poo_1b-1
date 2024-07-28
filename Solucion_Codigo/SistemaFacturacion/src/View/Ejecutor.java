package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import Controller.*;
import com.mysql.cj.protocol.Resultset;

import java.util.Scanner;

public class Ejecutor {
    static public Connection con = null;

    public static void main(String[] args) {
        String rutaInventario = "LeerArchivos\\Inventario.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
        String cliente = sc.next();
        System.out.println("INGRESE LA CEDULA DEL CLIENTE");
        int cedula = sc.nextInt();
        System.out.println("INGRESE EL DIRECCION DEL CLIENTE");
        String direccion = sc.next();
        LeerInventario leerInventario = new LeerInventario();
        List<Producto> inventario = leerInventario.leerInventario(rutaInventario);
        SistemaFacturacion sistema1 = new SistemaFacturacion(cliente, cedula, direccion, inventario);
        sistema1.iniciarSistema();
        System.out.println("LAS FACTURAS HAN SIDO GENERADAS");
        System.out.println("OPERACIONES CRUD");
        System.out.println("DESEA ACCEDER A LA BASE DATOS? | Si/s | No/n ");
        if (sc.next().equalsIgnoreCase("Si") || sc.next().equalsIgnoreCase("s")) {
            System.out.println("INGRESE EL USUARIO");
            String usuario = sc.next();
            System.out.println("INGRESE LA CONTRASEÑA");
            String contra = sc.next();
            try {
                ConneccionBaseDeDatos cDB = new ConneccionBaseDeDatos();
                con = cDB.conneccionBaseDeDatos(usuario, contra);
                System.out.println("EXITO AL CONECTAR A LA BASE DE DATOS");
            } catch (Exception e) {
                System.out.println("Error al conectar con la base de datos" + e.getMessage());
            }
            System.out.println("ELIJA LA TABLA A MODIFICAR  |   1. Cliente  |   2.Producto ");
            ConsultasSQLDB querry = new ConsultasSQLDB();
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("QUE DESEA MODIFICAR |   1.INSERTAR  |   2.LEER  |   3.ACTUALIZAR    |   4.ELIMINAR  ");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("====== INSERTAR CLIENTE ======");
                            System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
                            String nombreCli = sc.next();
                            System.out.println("INGRESE LA CEDULA DEL CLIENTE");
                            int ced = sc.nextInt();
                            System.out.println("INGRESE LA DIRECCION DEL CLIENTE");
                            String direc = sc.next();
                            System.out.println("INGRESE EL TELEFONO DEL CLIENTE");
                            int tel = sc.nextInt();
                            try {
                                querry.insertarRegistroTablaClientes(con, cedula, nombreCli, direccion);
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("TABLA CLIENTES");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "cliente");
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("cedula"));
                                System.out.println(rs.getString("direccion"));
                                System.out.println(rs.getString("telefono"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("====== ACTUALIZAR CLIENTE ======");
                            System.out.println("====== TABLA CLIENTES ======");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "cliente");
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("cedula"));
                                System.out.println(rs.getString("direccion"));
                                System.out.println(rs.getString("telefono"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            System.out.println("=========================================");
                            System.out.println("INGRESE LA CEDULA DEL CLIENTE A MODIFICAR");
                            ced = sc.nextInt();
                            System.out.println("INGRESE EL NUEVO NOMBRE DEL CLIENTE");
                            nombreCli = sc.next();
                            System.out.println("INGRESE LA DIRECCION DEL CLIENTE");
                            direc = sc.next();
                            System.out.println("INGRESE EL TELEFONO DEL CLIENTE");
                            tel = sc.nextInt();
                            try {
                                querry.actualizarRegistroTablaClientes(con, cedula, nombreCli, direccion, tel);
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 4:
                            System.out.println("====== ELIMINAR CLIENTE ======");
                            System.out.println("====== TABLA CLIENTES ======");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "Cliente");
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("cedula"));
                                System.out.println(rs.getString("direccion"));
                                System.out.println(rs.getString("telefono"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            System.out.println("=========================================");
                            System.out.println("INGRESE LA CEDULA DEL CLIENTE");
                            ced = sc.nextInt();
                            try {
                                querry.eliminarRegistroTabla(con, ced, "clientes");
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                    }

                    break;
                case 2:
                    System.out.println("QUE DESEA MODIFICAR |   1.INSERTAR  |   2.LEER  |   3.ACTUALIZAR    |   4.ELIMINAR  ");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("====== INSERTAR PRODUCTO ======");
                            System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                            String nombreProd = sc.next();
                            System.out.println("INGRESE LA PRECIO DEL PRODUCTO");
                            double precio = sc.nextDouble();
                            System.out.println("INGRESE LA CANTIDAD DEL PRODUCTO");
                            int cant = sc.nextInt();
                            System.out.println("INGRESE EL CATEGORIA DEL PRODUCTO");
                            String cat = sc.next();
                            System.out.println("INGRESE EL CADUCIDAD DEL PRODUCTO");
                            String cad = sc.next();
                            try {
                                querry.insertarRegistroTablaProductos(con, nombreProd, precio, cant, cat, cad);
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("TABLA PRODUCTOS");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "productos");
                                System.out.println(rs.getInt("codigo"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getDouble("precio"));
                                System.out.println(rs.getInt("cantidad"));
                                System.out.println(rs.getString("categoria"));
                                System.out.println(rs.getString("caducidad"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("====== ACTUALIZAR CLIENTE ======");
                            System.out.println("====== TABLA PRODUCTOS ======");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "productos");
                                System.out.println(rs.getInt("codigo"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getDouble("precio"));
                                System.out.println(rs.getInt("cantidad"));
                                System.out.println(rs.getString("categoria"));
                                System.out.println(rs.getString("caducidad"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            System.out.println("=========================================");
                            System.out.println("INGRESE LA CODIGO DEL PRODUCTO A MODIFICAR");
                            int cod = sc.nextInt();
                            System.out.println("INGRESE EL NUEVO NOMBRE DEL PRODUCTO");
                            nombreProd = sc.next();
                            System.out.println("INGRESE LA PRECIO DEL PRODUCTO");
                            precio = sc.nextDouble();
                            System.out.println("INGRESE EL CANTIDAD DEL PRODUCTO");
                            cant = sc.nextInt();
                            System.out.println("INGRESE EL CATEGORIA DEL PRODUCTO");
                            cat = sc.next();
                            System.out.println("INGRESE EL CADUCIDAD DEL PRODUCTO");
                            cad = sc.next();
                            try {
                                querry.actualizarRegistroTablaProductos(con, cod, nombreProd, precio, cant, cat, cad);
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                        case 4:
                            System.out.println("====== ELIMINAR CLIENTE ======");
                            System.out.println("====== TABLA PRODUCTOS ======");
                            try {
                                ResultSet rs = querry.leerRegistroTabla(con, "productos");
                                System.out.println(rs.getInt("codigo"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getDouble("precio"));
                                System.out.println(rs.getInt("cantidad"));
                                System.out.println(rs.getString("categoria"));
                                System.out.println(rs.getString("caducidad"));
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            System.out.println("=========================================");
                            System.out.println("INGRESE EL CODIGO DEL PRODUCTO");
                            cod = sc.nextInt();
                            try {
                                querry.eliminarRegistroTabla(con, cod, "productos");
                            } catch (SQLException e) {
                                System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                            }
                            break;
                    }
            }
        }
    }
}