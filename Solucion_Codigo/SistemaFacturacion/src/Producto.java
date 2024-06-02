public class Producto {
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

    public Producto productoParaFactura(int cantidadFac){
        Producto prodFac = new Producto(this.codigo, this.nombre, this.precio, cantidadFac, this.categoria, this.caducidad);
        restarCantidad(cantidadFac);
        return prodFac;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
                + ", categoria=" + categoria + ", caducidad=" + caducidad + ", descuento=" + descuento + '}';
    }

}
