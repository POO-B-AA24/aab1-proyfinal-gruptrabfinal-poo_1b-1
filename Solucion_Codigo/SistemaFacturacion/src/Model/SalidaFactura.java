package Model;

import Controller.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;



public class SalidaFactura {
    public List<Factura> listFactura;
    public ObjectOutputStream flujoSalidaFactura;
    public FileOutputStream pathArchivo;

    public SalidaFactura(List<Factura> listFactura, FileOutputStream pathArchivo) {
        this.listFactura = listFactura;
        this.pathArchivo = pathArchivo;
    }

    public void salidaFacturaArchivo() {
        try {
            this.flujoSalidaFactura = new ObjectOutputStream(pathArchivo);
            for (Factura fact : listFactura) {
                flujoSalidaFactura.writeObject(fact);
            }
        } catch (Exception e) {
            System.out.println("serializacion factura "+e);

        }
    }
}
