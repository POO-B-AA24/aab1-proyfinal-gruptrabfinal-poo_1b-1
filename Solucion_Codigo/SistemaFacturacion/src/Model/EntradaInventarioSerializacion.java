package Model;

import Controller.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;



public class EntradaInventarioSerializacion {
    public List<Producto> listInventario;
    public ObjectInputStream flujoEntradaEmp;
    public FileInputStream pathArchivo;

    public EntradaInventarioSerializacion(FileInputStream pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public List<Producto> lecturaInventarioArchivo() {
        listInventario = new ArrayList<Producto>();
        try {
            flujoEntradaEmp = new ObjectInputStream(pathArchivo);
            while (true) {
                try {
                    Producto invt = (Producto) flujoEntradaEmp.readObject();
                    listInventario.add(invt);
                } catch (EOFException endOffileException) {
                    break;
                }
            }
            flujoEntradaEmp.close();
        } catch (ClassNotFoundException classNotfoundException) {
            System.out.println("Clase no encontrada: " + classNotfoundException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERORO EN LA Entrada de inventario " + e);
        }
        return listInventario;
    }
}
