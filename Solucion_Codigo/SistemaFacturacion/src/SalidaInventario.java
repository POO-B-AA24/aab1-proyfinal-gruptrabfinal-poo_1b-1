
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SalidaInventario {
    public List<Producto> listInventario;
    public ObjectOutputStream flujoSalidainventario;
    public FileOutputStream pathArchivo;

    public SalidaInventario(List<Producto> listinventario, FileOutputStream pathArchivo) {
        this.listInventario = listinventario;
        this.pathArchivo = pathArchivo;
    }

    public void salidaInventarioArchivo() {
        try {
            this.flujoSalidainventario = new ObjectOutputStream(pathArchivo);
            for (Producto producto : listInventario) {
                flujoSalidainventario.writeObject(producto);
            }
        } catch (Exception e) {
        }
    }
}
