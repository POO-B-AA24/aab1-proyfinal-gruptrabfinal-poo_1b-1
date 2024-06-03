import java.io.Serializable;

public class Producto implements Serializable{
    public int codigo;
    public String nombre;
    public double precio;
    public int cantidad;
    public String categoria;
    public String caducidad;
    public double descuento;

    public Producto(int codigo, String nombre, double precio, int cantidad, String categoria, String caducidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.caducidad = caducidad;
    }

    public void restarCantidad(int ran_Cant) {
        this.cantidad -= ran_Cant;
    }

    public Producto productoParaFactura(int cantidadFac) {
        switch (verificarCantidad(cantidadFac)) {
            case 'a':
                Producto prodFac = new Producto(this.codigo, this.nombre, this.precio, cantidadFac, this.categoria,
                        this.caducidad);
                restarCantidad(cantidadFac);
                return prodFac;
            case 'b':
                Producto prodFac1 = new Producto(this.codigo, this.nombre, this.precio, this.cantidad, this.categoria,
                        this.caducidad);
                this.cantidad = 0;
                return prodFac1;
            case 'c':
                return null;
            default:
                return null;
        }

    }

    public char verificarCantidad(int cantidadFac) {
        if (this.cantidad > cantidadFac) {
            return 'a';
        } else if (this.cantidad > 0) {
            return 'b';
        }
        return 'c';
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
                + ", categoria=" + categoria + ", caducidad=" + caducidad + ", descuento=" + descuento + '}';
    }

}
