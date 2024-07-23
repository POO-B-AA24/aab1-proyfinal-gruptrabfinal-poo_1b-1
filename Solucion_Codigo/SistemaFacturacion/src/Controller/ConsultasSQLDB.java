package Controller;
import java.sql.*;
public class ConsultasSQLDB {
    public static void main(String[] args) {
        Connection con = null;
        String user = "root";
        String password = "12345678";
        String url = "jdbc:mysql://localhost:3306/productosdb";
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Conneccion exitosa");
            insertar(con,"Doritos",0.5,10,"Comida","10/10/2020");
            leer(con);
            //eliminar(con,4);
            leer(con);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    static void insertar(Connection con, String nombre, double precio, int cantidad,String categoria, String caducidad) throws SQLException{
        String querry = "INSERT INTO productos (nombre, precio, cantidad, categoria, caducidad) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setString(4, categoria);
            ps.setString(5, caducidad);
            int rows = ps.executeUpdate();
            System.out.println(rows + " rows affected");
        }
    }
    static void leer(Connection con) throws SQLException{
        String querry = "select * from productos";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("precio"));
                System.out.println(rs.getString("cantidad"));
                System.out.println(rs.getString("categoria"));
                System.out.println(rs.getString("caducidad"));
                System.out.println(rs.getString("descuento"));
            }
        }
    }


    static void actualizar(Connection con, int codigo, String nombre, double precio, int cantidad,String categoria, String caducidad) throws SQLException{
        String querry = "update productos set nombre = ?, precio=?, cantidad=?,categoria=?,caducidad=?,descuento=? where codigo=?";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setString(4, categoria);
            ps.setString(5, caducidad);
            ps.setInt(6, 0);
            ps.setInt(7, codigo);
            int rows = ps.executeUpdate();
            System.out.println(rows + " rows affected");
        }
    }
    static void eliminar(Connection con, int codigo) throws SQLException{
        String querry = "delete from productos where codigo=?";
        try(PreparedStatement ps = con.prepareStatement(querry)){
            ps.setInt(1,codigo);
            int rows = ps.executeUpdate();
            System.out.println(rows + " rows affected");
        }
    }
}
