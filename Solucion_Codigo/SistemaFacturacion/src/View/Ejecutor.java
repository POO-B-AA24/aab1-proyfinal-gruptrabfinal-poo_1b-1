package View;

import java.util.List;
import Controller.*;

public class Ejecutor {
    public static void main(String[] args) {
        String cliente = "Luis Aguilar";
        int cedula = 1104994542;
        String direccion = "Luis Aguilar";
        String rutaInventario = "LeerArchivos\\Inventario.csv";
        LeerInventario leerInventario = new LeerInventario();
        List<Producto> inventario = leerInventario.leerInventario(rutaInventario);
        SistemaFacturacion sistema1 = new SistemaFacturacion(cliente, cedula, direccion, inventario);
        sistema1.iniciarSistema();
    }
}
