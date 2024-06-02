

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EntradaInventario {
    public ArrayList<Producto> listInventario;
    public ObjectInputStream flujoEntradaEmp;
    public FileInputStream pathArchivo;

    public EntradaInventario(FileInputStream pathArchivo) {
        this.pathArchivo = pathArchivo;
    }
    public ArrayList lecturaInventarioArchivo(){
        listInventario = new ArrayList<Producto>();
        try {
            flujoEntradaEmp = new ObjectInputStream(pathArchivo);
            while(true){
                try {
                    Producto invt = (Producto) flujoEntradaEmp.readObject();
                    listInventario.add(invt); 
                } catch (EOFException endOffileException) {
                    break;
                }         
            }
            flujoEntradaEmp.close();
        } catch(ClassNotFoundException classNotfoundException){
            System.out.println("Clase no encontrada: " + classNotfoundException.getMessage()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listInventario;
    }
}

