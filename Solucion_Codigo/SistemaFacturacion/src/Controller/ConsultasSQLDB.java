package Controller;
import java.sql.*;
public class ConsultasSQLDB {

     public void insertarRegistroTablaProductos(Connection con, String nombre, double precio, int cantidad, String categoria, String caducidad) throws SQLException{
        String querry = "INSERT INTO productos (nombre, precio, cantidad, categoria, caducidad) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setString(4, categoria);
            ps.setString(5, caducidad);
            ps.executeUpdate();
        }
    }

    public ResultSet leerRegistroTabla(Connection con, String tabla) throws SQLException{
         String querry = "SELECT * FROM ?";
         try(PreparedStatement ps = con.prepareStatement(querry)){
             ps.setString(1, tabla);
            return ps.executeQuery();
         }
    }

    public void actualizarRegistroTablaProductos(Connection con, int codigo, String nombre, double precio, int cantidad,String categoria, String caducidad) throws SQLException{
        String querry = "update productos set nombre = ?, precio=?, cantidad=?,categoria=?,caducidad=?,descuento=? where codigo=?";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setString(4, categoria);
            ps.setString(5, caducidad);
            ps.setInt(6, 0);
            ps.setInt(7, codigo);
            ps.executeUpdate();
        }
    }

    public void eliminarRegistroTabla(Connection con, int codigo, String table) throws SQLException{
         String querry = "DELETE FROM ? WHERE codigo=?";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1,table);
            ps.setInt(2,codigo);
            ps.executeUpdate();
        }
    }

    public void  insertarRegistroTablaClientes (Connection con, int cedula, String nombre, String direccion) throws SQLException{
         String querry = "Insert into clientes values (?,?,?)";
         try(PreparedStatement ps = con.prepareStatement(querry)){
             ps.setInt(1, cedula);
             ps.setString(2, nombre);
             ps.setString(3, direccion);
             ps.executeUpdate();
         }
    }

    public void actualizarRegistroTablaClientes (Connection con, int cedula, String nombre, String direccion, int telefono) throws SQLException{
        String querry = "update clientes set nombre = ?, direccion=?, telefono=? where cedula=?";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setInt(4, cedula);
            ps.executeUpdate();
        }
    }

    public void insertarRegistroTablaEstadistica (Connection con, String fecha, int codigo, String nombre, String categoria, int ventas) throws SQLException{
         String querry = "Insert into estadistica values (?,?,?,?,?)";
         try(PreparedStatement ps = con.prepareStatement(querry)){
             ps.setString(1, fecha);
             ps.setInt(2, codigo);
             ps.setString(3, nombre);
             ps.setString(4, categoria);
             ps.setInt(5, ventas);
             ps.executeUpdate();
         }
    }

}
