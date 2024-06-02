
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SalidaInventario {
    public ArrayList<Producto> listInventario;
    public ObjectOutputStream flujoSalidaEstadistica;
    public FileOutputStream pathArchivo;

    public SalidaInventario(ArrayList<Producto> listEstadisticas, FileOutputStream pathArchivo) {
        this.listInventario = listEstadisticas;
        this.pathArchivo = pathArchivo;
    }

    public void salidaEstadisticaArchivo() {
        try {
            this.flujoSalidaEstadistica = new ObjectOutputStream(pathArchivo);
            for (Producto invt : listInventario) {
                flujoSalidaEstadistica.writeObject(invt);
            }
        } catch (Exception e) {
        }
    }
}
