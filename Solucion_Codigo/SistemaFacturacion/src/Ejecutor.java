import java.util.List;

public class Ejecutor {
    public static void main(String[] args) {
        String cliente = "Luis Aguilar";
        int cedula = 1104994542;
        String direccion = "Luis Aguilar";
        String rutaInventario = "C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\PRIMER BIMESTRE\\PROYECTO\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\prueba\\LeerArchivos\\Inventario.csv";
        LeerInventario leerInventario = new LeerInventario();
        List<Producto> inventario = leerInventario.leerInventario(rutaInventario);
        SistemaFacturacion sistema1 = new SistemaFacturacion(cliente, cedula, direccion, inventario);
        sistema1.iniciarSistema();
    }
}
