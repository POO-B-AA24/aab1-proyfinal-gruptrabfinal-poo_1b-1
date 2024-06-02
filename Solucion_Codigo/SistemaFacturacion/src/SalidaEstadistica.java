import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class SalidaEstadistica {
    public ArrayList <Factura> FacturasEstadisticas;
    public ObjectOutputStream flujoSalidaEstadistica;
    public FileOutputStream pathArchivo;

    public SalidaEstadistica(ArrayList<Factura> facturas, FileOutputStream pathArchivo) {
        this.FacturasEstadisticas = facturas;
        this.pathArchivo = pathArchivo;
    }
    public void salidaEstadisticaArchivo(){
        try {
            this.flujoSalidaEstadistica = new ObjectOutputStream(pathArchivo);
            for (Factura factura : FacturasEstadisticas) {
                flujoSalidaEstadistica.writeObject(factura);
            }
            flujoSalidaEstadistica.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}