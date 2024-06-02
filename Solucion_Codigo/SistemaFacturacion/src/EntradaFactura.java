
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class EntradaFactura {
    public List<Factura> listFactura;
    public ObjectInputStream flujoEntradaFact;
    public FileInputStream pathArchivo;

    public EntradaFactura(FileInputStream pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public List<Factura> lecturaFacturaArchivo() {
        listFactura = new ArrayList<Factura>();
        try {
            flujoEntradaFact = new ObjectInputStream(pathArchivo);
            while (true) {
                try {
                    Factura fact = (Factura) flujoEntradaFact.readObject();
                    listFactura.add(fact);
                } catch (EOFException endOffileException) {
                    break;
                }
            }
            flujoEntradaFact.close();
        } catch (ClassNotFoundException classNotfoundException) {
            System.out.println("Clase no encontrada: " + classNotfoundException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFactura;
    }
}
