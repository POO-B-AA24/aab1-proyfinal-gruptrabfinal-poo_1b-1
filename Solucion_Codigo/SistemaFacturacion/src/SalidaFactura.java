
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SalidaFactura {
    public ArrayList<Factura> listFactura;
    public ObjectOutputStream flujoSalidaEstadistica;
    public FileOutputStream pathArchivo;

    public SalidaFactura(ArrayList<Factura> listFactura, FileOutputStream pathArchivo) {
        this.listFactura = listFactura;
        this.pathArchivo = pathArchivo;
    }

    public void salidaFacturaArchivo() {
        try {
            this.flujoSalidaEstadistica = new ObjectOutputStream(pathArchivo);
            for (Factura fact : listFactura) {
                flujoSalidaEstadistica.writeObject(fact);
            }
        } catch (Exception e) {
        }
    }
}
