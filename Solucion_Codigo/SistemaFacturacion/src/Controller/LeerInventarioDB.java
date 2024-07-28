package Controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeerInventarioDB {

    public List<Producto> leerInventario(Connection con) {
        List<Producto> inventario = new ArrayList<>();
        ConsultasSQLDB query = new ConsultasSQLDB();
        try {
            ResultSet rs = query.leerRegistroTabla(con, "productos");
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre =  rs.getString("codigo");
                double precio =  rs.getDouble("precio");
                int cantidad =  rs.getInt("cantidad");
                String categoria =  rs.getString("categoria");
                String caducidad =  rs.getString("caducidad");
                Producto producto = new Producto(codigo, nombre, precio, cantidad, categoria, caducidad);
                inventario.add(producto);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return inventario;
    }
}