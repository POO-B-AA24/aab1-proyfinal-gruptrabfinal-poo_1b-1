
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class LeerInventario {
    public List<Producto> leerInventario(String archivo) {
        List<Producto> inventario = new ArrayList<>();
        try (Scanner tecladoanner = new Scanner(new File(archivo))) {
            while (tecladoanner.hasNextLine()) {
                String linea = tecladoanner.nextLine();
                String[] partes = linea.split(";");
                int codigo = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                double precio = Double.parseDouble(partes[2].trim());
                int cantidad = Integer.parseInt(partes[3].trim());
                String categoria = partes[4].trim();
                String caducidad = partes[5].trim();
                Producto producto = new Producto(codigo, nombre, precio, cantidad, categoria, caducidad);
                inventario.add(producto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar archivo " + e);
        }
        return inventario;
    }
}