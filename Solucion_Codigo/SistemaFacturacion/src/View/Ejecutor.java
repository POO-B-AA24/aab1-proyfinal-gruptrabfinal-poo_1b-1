package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.*;

import java.util.List;
import java.util.Scanner;

public class Ejecutor {
    static public Connection con = null;

    public static void main(String[] args) {
        String rutaInventario = "LeerArchivos\\Inventario.csv";
        Scanner sc = new Scanner(System.in);
        ConsultasSQLDB querry = new ConsultasSQLDB();
        System.out.println("INGRESE EL USUARIO DE LA BASE DE DATOS");
        String usuarioDB = sc.next();
        System.out.println("INGRESE LA CONTRASEÑA DE LA BASE DE DATOS");
        String contraDB = sc.next();
        try {
            ConneccionBaseDeDatos cDB = new ConneccionBaseDeDatos();
            con = cDB.conneccionBaseDeDatos(usuarioDB, contraDB);
            System.out.println("EXITO AL CONECTAR A LA BASE DE DATOS");
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
        LeerInventarioDB leerInventario = new LeerInventarioDB();
        List<Producto> inventario = leerInventario.leerInventario(con);
        System.out.println("1. SELECCIONAR CLIENTE DE BASE DE DATOS  |  2. INGRESAR CLIENTE MANUALMENTE");
        String clienteIN;
        int cedulaIN;
        String direccionIN;
        switch(sc.nextInt()) {
            case 1:
                try {
                    ResultSet rs = querry.leerRegistroTabla(con,"cliente");
                    System.out.println("======= TABLA CLIENTES =======");
                    while(rs.next()) {
                        System.out.println("ID: " + rs.getString("id"));
                        System.out.println("NOMBRE: "+rs.getString("nombre"));
                        System.out.println("CEDULA: "+rs.getString("cedula"));
                        System.out.println("DIRECCION: "+rs.getString("direccion"));
                        System.out.println("TELEFONO: "+rs.getString("telefono"));
                        System.out.println("=======================================");
                    }
                    rs.close();
                    System.out.println("INGRESE EL ID DEl CLIENTE");
                    int id = sc.nextInt();
                    rs = querry.buscarCliente(con,id);
                    cedulaIN = rs.getInt("cedula");
                    clienteIN = rs.getString("nombre");
                    direccionIN = rs.getString("direccion");
                    SistemaFacturacion sistema1 = new SistemaFacturacion(clienteIN, cedulaIN, direccionIN, inventario);
                    sistema1.iniciarSistema();
                }catch (SQLException e){
                    System.out.println();
                }
                break;
                case 2:
                    System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
                    clienteIN = sc.next();
                    System.out.println("INGRESE LA CEDULA DEL CLIENTE");
                    cedulaIN = sc.nextInt();
                    System.out.println("INGRESE LA DIRECCION DEL CLIENTE");
                    direccionIN = sc.next();
                    SistemaFacturacion sistema1 = new SistemaFacturacion(clienteIN, cedulaIN, direccionIN, inventario);
                    sistema1.iniciarSistema();
                    break;
        }
        System.out.println("LAS FACTURAS HAN SIDO GENERADAS");
        System.out.println("OPERACIONES CRUD");
        System.out.println("DESEA ACCEDER A LA BASE DATOS? | Si/s | No/n ");
        if (sc.next().equalsIgnoreCase("s")) {
            int op = 0;
            do {
                System.out.println("ELIJA LA TABLA A MODIFICAR  |   1. Cliente  |   2.Producto  |   3.SALIR");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println(
                                "QUE DESEA MODIFICAR |   1.INSERTAR  |   2.LEER  |   3.ACTUALIZAR    |   4.ELIMINAR  ");
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
                                    querry.insertarRegistroTablaClientes(con, ced, nombreCli, direc, tel);
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                            case 2:
                                System.out.println("TABLA CLIENTES");
                                try {
                                    ResultSet rs = querry.leerRegistroTabla(con, "cliente");
                                    while (rs.next()) {
                                        System.out.println("ID: " + rs.getString("id"));
                                        System.out.println("NOMBRE CLIENTE: " + rs.getString("nombre"));
                                        System.out.println("CEDULA CLIENTE: " + rs.getString("cedula"));
                                        System.out.println("DIRECCION CLIENTE: " + rs.getString("direccion"));
                                        System.out.println("TELEFONO CLIENTE: " + rs.getString("telefono"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                            case 3:
                                System.out.println("====== ACTUALIZAR CLIENTE ======");
                                System.out.println("====== TABLA CLIENTES ======");
                                try {
                                    ResultSet rs = querry.leerRegistroTabla(con, "cliente");
                                    while (rs.next()) {
                                        System.out.println("ID: " + rs.getString("id"));
                                        System.out.println("NOMBRE CLIENTE: " + rs.getString("nombre"));
                                        System.out.println("CEDULA CLIENTE: " + rs.getString("cedula"));
                                        System.out.println("DIRECCION CLIENTE: " + rs.getString("direccion"));
                                        System.out.println("TELEFONO CLIENTE: " + rs.getString("telefono"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                System.out.println("=========================================");
                                System.out.println("INGRESE EL ID DEL CLIENTE A MODIFICAR");
                                int id = sc.nextInt();
                                System.out.println("INGRESE LA CEDULA DEL CLIENTE");
                                ced = sc.nextInt();
                                System.out.println("INGRESE EL NUEVO NOMBRE DEL CLIENTE");
                                nombreCli = sc.next();
                                System.out.println("INGRESE LA DIRECCION DEL CLIENTE");
                                direc = sc.next();
                                System.out.println("INGRESE EL TELEFONO DEL CLIENTE");
                                tel = sc.nextInt();
                                try {
                                    querry.actualizarRegistroTablaClientes(con, id,ced, nombreCli, direc, tel);
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("====== ELIMINAR CLIENTE ======");
                                System.out.println("====== TABLA CLIENTES ======");
                                try {
                                    ResultSet rs = querry.leerRegistroTabla(con, "cliente");
                                    while (rs.next()) {
                                        System.out.println("ID: " + rs.getString("id"));
                                        System.out.println("NOMBRE CLIENTE: " + rs.getString("nombre"));
                                        System.out.println("CEDULA CLIENTE: " + rs.getString("cedula"));
                                        System.out.println("DIRECCION CLIENTE: " + rs.getString("direccion"));
                                        System.out.println("TELEFONO CLIENTE: " + rs.getString("telefono"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                System.out.println("=========================================");
                                System.out.println("INGRESE LA ID DEL CLIENTE");
                                id = sc.nextInt();
                                try {
                                    querry.eliminarRegistroTablaCliente(con, id);
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(
                                "QUE DESEA MODIFICAR |   1.INSERTAR  |   2.LEER  |   3.ACTUALIZAR    |   4.ELIMINAR  ");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("====== INSERTAR PRODUCTO ======");
                                System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                                String nombreProd = sc.next();
                                System.out.println("INGRESE EL PRECIO DEL PRODUCTO");
                                double precio = sc.nextDouble();
                                System.out.println("INGRESE LA CANTIDAD DEL PRODUCTO");
                                int cant = sc.nextInt();
                                System.out.println("INGRESE EL CATEGORIA DEL PRODUCTO   |   1.ALIMENTACION  |   2.EDUCACION |   3.HOGAR |   4.VESTIMENTA    |   5.SALUD");
                                int cat = sc.nextInt();
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
                                    while (rs.next()) {
                                        System.out.println("CODIGO PRODUCTO: " + rs.getInt("codigo"));
                                        System.out.println("NOMBRE PRODUCTO: " + rs.getString("nombre"));
                                        System.out.println("PRECIO PRODUCTO: " + rs.getDouble("precio"));
                                        System.out.println("CANTIDAD PRODUCTO: " + rs.getInt("cantidad"));
                                        System.out.println("CATEGORIA PRODUCTO: " + rs.getString("categoria"));
                                        System.out.println("CADUCIDAD PRODUCTO: " + rs.getString("caducidad"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                            case 3:
                                System.out.println("====== ACTUALIZAR CLIENTE ======");
                                System.out.println("====== TABLA PRODUCTOS ======");
                                try {
                                    ResultSet rs = querry.leerRegistroTabla(con, "productos");
                                    while (rs.next()) {
                                        System.out.println("CODIGO PRODUCTO: " + rs.getInt("codigo"));
                                        System.out.println("NOMBRE PRODUCTO: " + rs.getString("nombre"));
                                        System.out.println("PRECIO PRODUCTO: " + rs.getDouble("precio"));
                                        System.out.println("CANTIDAD PRODUCTO: " + rs.getInt("cantidad"));
                                        System.out.println("CATEGORIA PRODUCTO: " + rs.getString("categoria"));
                                        System.out.println("CADUCIDAD PRODUCTO: " + rs.getString("caducidad"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
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
                                System.out.println("INGRESE EL CATEGORIA DEL PRODUCTO   |   1.ALIMENTACION  |   2.EDUCACION |   3.HOGAR |   4.VESTIMENTA    |   5.SALUD");
                                cat = sc.nextInt();
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
                                    while (rs.next()) {
                                        System.out.println("CODIGO PRODUCTO: " + rs.getInt("codigo"));
                                        System.out.println("NOMBRE PRODUCTO: " + rs.getString("nombre"));
                                        System.out.println("PRECIO PRODUCTO: " + rs.getDouble("precio"));
                                        System.out.println("CANTIDAD PRODUCTO: " + rs.getInt("cantidad"));
                                        System.out.println("CATEGORIA PRODUCTO: " + rs.getString("categoria"));
                                        System.out.println("CADUCIDAD PRODUCTO: " + rs.getString("caducidad"));
                                        System.out.println("=============================================================");
                                    }
                                    rs.close();
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                System.out.println("=========================================");
                                System.out.println("INGRESE EL CODIGO DEL PRODUCTO");
                                cod = sc.nextInt();
                                try {
                                    querry.eliminarRegistroTablaProducto(con, cod);
                                } catch (SQLException e) {
                                    System.out.println("Error al insertar registro tabla Cliente" + e.getMessage());
                                }
                                break;
                        }
                }
            } while (op != 3);

        }
        System.out.println("MUCHAS GRACIAS");
    }
}