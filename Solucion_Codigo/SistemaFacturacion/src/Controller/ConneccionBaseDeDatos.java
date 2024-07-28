package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConneccionBaseDeDatos {
    public Connection conneccionBaseDeDatos(String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/productosdb";
        con = DriverManager.getConnection(url,usuario,contrasenia);
        return con;
    }
}
