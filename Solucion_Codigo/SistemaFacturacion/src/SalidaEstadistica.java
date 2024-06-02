import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class SalidaEstadistica {
    public ArrayList <Estadistica> listEstadisticas;
    public ObjectOutputStream flujoSalidaEstadistica;
    public FileOutputStream pathArchivo;

    public SalidaEstadistica(ArrayList<Estadistica> listEstadisticas, FileOutputStream pathArchivo) {
        this.listEstadisticas = listEstadisticas;
        this.pathArchivo = pathArchivo;
    }
    public void salidaEstadisticaArchivo(){
        try {
            this.flujoSalidaEstadistica = new ObjectOutputStream(pathArchivo);
            for (Estadistica est : listEstadisticas) {
                flujoSalidaEstadistica.writeObject(est);
            }
            flujoSalidaEstadistica.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
     

    


    



}
