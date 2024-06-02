public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private String caducidad;
    private double descuento;

    public Producto(int codigo, String nombre, double precio, int cantidad, String categoria, String caducidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.caducidad = caducidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void setDescuento(int descuento){
        this.descuento = descuento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void restarCantidad(int ran_Cant) {
            this.cantidad -= ran_Cant;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", categoria=" + categoria + ", caducidad=" + caducidad + ", descuento=" + descuento + '}';
    }
    
}
