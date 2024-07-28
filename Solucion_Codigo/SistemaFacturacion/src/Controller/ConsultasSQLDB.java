package Controller;

import java.sql.*;

public class ConsultasSQLDB {

    public void insertarRegistroTablaProductos(Connection con, String nombre, double precio, int cantidad,
            int categoria, String caducidad) throws SQLException {
        String querry = "INSERT INTO productos (nombre, precio, cantidad, categoria, caducidad) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            switch (categoria){
                case 1:
                    ps.setString(4, "Alimentación");
                    break;
                case 2:
                    ps.setString(4, "Educación");
                    break;
                case 3:
                    ps.setString(4, "Hogar");
                    break;
                case 4:
                    ps.setString(4, "Vestimenta");
                    break;
                case 5:
                    ps.setString(4, "Salud");
                    break;
            }
            ps.setString(5, caducidad);
            ps.executeUpdate();
        }
    }

    public ResultSet leerRegistroTabla(Connection con, String table) throws SQLException {
        String querry = "SELECT * FROM " + table;
        try {
            PreparedStatement ps = con.prepareStatement(querry);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void actualizarRegistroTablaProductos(Connection con, int codigo, String nombre, double precio, int cantidad,
            int categoria, String caducidad) throws SQLException {
        String querry = "update productos set nombre = ?, precio=?, cantidad=?,categoria=?,caducidad=?,descuento=? where codigo=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            switch (categoria){
                case 1:
                    ps.setString(4, "Alimentación");
                    break;
                case 2:
                    ps.setString(4, "Educación");
                    break;
                case 3:
                    ps.setString(4, "Hogar");
                    break;
                case 4:
                    ps.setString(4, "Vestimenta");
                    break;
                case 5:
                    ps.setString(4, "Salud");
                    break;
            }
            ps.setString(5, caducidad);
            ps.setInt(6, 0);
            ps.setInt(7, codigo);
            ps.executeUpdate();
        }
    }

    public void eliminarRegistroTablaProducto(Connection con, int codigo) throws SQLException {
        String querry = "DELETE FROM productos WHERE codigo=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }

    public void eliminarRegistroTablaCliente(Connection con, int id) throws SQLException {
        String querry = "DELETE FROM cliente WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void insertarRegistroTablaClientes(Connection con, int cedula, String nombre, String direccion, int telefono)
        throws SQLException {
        String querry = "INSERT INTO cliente (cedula, nombre, direccion, telefono) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            ps.executeUpdate();
        }
    }

    public void actualizarRegistroTablaClientes(Connection con, int id,int cedula, String nombre, String direccion,
            int telefono) throws SQLException {
        String querry = "update cliente set nombre = ?, cedula=?,direccion=?, telefono=? where id=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setString(1, nombre);
            ps.setInt(2, cedula);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

    public ResultSet buscarProducto(Connection con, int codigo) throws SQLException {
        String querry = "SELECT * FROM productos WHERE codigo=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, codigo);
            return ps.executeQuery();
        }
    }

    public ResultSet buscarCliente(Connection con, int id) throws SQLException {
        String querry = "SELECT * FROM cliente WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(querry)) {
            ps.setInt(1, id);
            return ps.executeQuery();
        }
    }
}
