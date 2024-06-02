
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EntradaEstadistica {
    public ArrayList<Estadistica> listEstadistica;
    public ObjectInputStream flujoEntradaEsta;
    public FileInputStream pathArchivo;

    public EntradaEstadistica(FileInputStream pathArchivo) {
        this.pathArchivo = pathArchivo;
    }
    
    public ArrayList<Estadistica> lecturaEstadisticaArchivo() {
        listEstadistica = new ArrayList<Estadistica>();
        try {
            flujoEntradaEsta = new ObjectInputStream(pathArchivo);
            while (true) {
                try {
                    Estadistica est = (Estadistica) flujoEntradaEsta.readObject();
                    listEstadistica.add(est);
                } catch (EOFException   endOffileException) {
                    break;
                }
            }
            flujoEntradaEsta.close(); 
        } catch (ClassNotFoundException classNotfoundException) {
            System.out.println("Clase no encontrada: " + classNotfoundException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEstadistica;
    }
}
