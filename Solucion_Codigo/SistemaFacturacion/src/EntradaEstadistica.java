import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
//assdfsa
public class EntradaEstadistica {
    public List<Factura> Facturas;
    public ObjectInputStream flujoEntradaEsta;
    public FileInputStream pathArchivo;

    public EntradaEstadistica(FileInputStream pathArchivo) {
        this.pathArchivo = pathArchivo;
    }
    
    public List<Factura> lecturaEstadisticaArchivo() {
        try {
            flujoEntradaEsta = new ObjectInputStream(pathArchivo);
            while (true) {
                try {
                    Factura factura = (Factura) flujoEntradaEsta.readObject();
                    Facturas.add(factura);
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
        return Facturas;
    }
}