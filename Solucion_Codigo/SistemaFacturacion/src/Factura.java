import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Factura {
    // fecha

    // Atributos
    private List<Producto> carrito = new ArrayList<>();
    private double subTotal;//
    private double sumaDescuentos;//
    private double subDescuentoAfiliado;//
    private double iva = 0.15;//
    private double subIva;//
    private double total;
    private String cliente;//
    private int cedula;//
    private String direccion;//
    private int numFactura;//
    private String fecha;
    private int autorizacionSRI;//
    private String formaPago;
    private int alimentacionD;//
    private int educacionD;//
    private int hogarD;//
    private int vestimentaD;//
    private int saludD;//
    private double descuentoAfiliado = 0.05;

    // Constructor
    // a carrito ya se debe enviar con la cantidad restada al inventario
    public Factura(List<Producto> carrito, String cliente, int cedula,
            String direccion, String fecha) {
        this.carrito = carrito;
        this.cliente = cliente;
        this.cedula = cedula;
        this.direccion = direccion;
        this.fecha = fecha;
    }

    public void procesoFactura() {
        randomizarVariables();
        asignarDescuentoProducto();
        calcularSubtotal();
        calcularDeduciblesImpuestos();
        calcularTotal();
    }

    public void randomizarVariables() {
        Random numran = new Random();
        autorizacionSRI = numran.nextInt(1000000) + 1;
        numFactura = numran.nextInt(1000) + 1;
        int n = numran.nextInt(3) + 1;
        switch (n) {
            case 1:
                this.formaPago = "Efectivo";
            case 2:
                this.formaPago = "tarjeta de credito";
            default:
                this.formaPago = "tarjeta de debito";
        }
    }

    public void asignarDescuentoProducto() {
        int stock = 100;
        for (Producto producto : carrito) {
            if (producto.cantidad > stock && producto.caducidad.contains("2024")) {
                producto.descuento = 0.3;
            } else if (producto.cantidad > stock) {
                producto.descuento = 0.1;
            } else if (producto.caducidad.contains("2024")) {
                producto.descuento = 0.2;
            }
        }
    }

    public void calcularSubtotal() {
        for (Producto producto : carrito) {
            subTotal += (producto.precio * producto.cantidad
                    - ((producto.precio * producto.cantidad) * producto.descuento));
        }
    }

    public void calcularDescuentos() {
        for (Producto producto : carrito) {
            sumaDescuentos += producto.descuento;
        }
    }

    public void calcularDeduciblesImpuestos() {
        for (Producto producto : carrito) {
            Random ran = new Random();
            switch (producto.categoria) {
                case "Alimentacion":
                    this.alimentacionD += ran.nextInt(10) + 1;
                    break;
                case "Educacion":
                    this.educacionD += ran.nextInt(10) + 1;
                    break;
                case "Hogar":
                    this.hogarD += ran.nextInt(10) + 1;
                    break;
                case "Vestimenta":
                    this.vestimentaD += ran.nextInt(10) + 1;
                    break;
                case "Salud":
                    this.saludD += ran.nextInt(10) + 1;
                    break;
                default:
                    break;
            }
        }
    }

    public boolean verificarAfiliado() {
        Random ran = new Random();
        int i = ran.nextInt(2) + 1;
        return i == 1;
    }

    public void calcularTotal() {
        if (verificarAfiliado()) {
            total = subTotal - sumaDescuentos;
            subDescuentoAfiliado = total * descuentoAfiliado;
            total -= subDescuentoAfiliado;
            subIva = total * iva;
            total += subIva;
        } else {
            total = subTotal - sumaDescuentos;
            subIva = total * iva;
            total += subIva;
        }
    }

    public void calcularSubIVa() {
        subIva = subTotal * iva;
    }

    @Override
    public String toString() {
        return "Factura{" + "carrito=" + carrito + ", subTotal=" + subTotal + ", sumaDescuentos=" + sumaDescuentos + ", subDescuentoAfiliado=" + subDescuentoAfiliado + ", iva=" + iva + ", subIva=" + subIva + ", total=" + total + ", cliente=" + cliente + ", cedula=" + cedula + ", direccion=" + direccion + ", numFactura=" + numFactura + ", fecha=" + fecha + ", autorizacionSRI=" + autorizacionSRI + ", formaPago=" + formaPago + ", alimentacionD=" + alimentacionD + ", educacionD=" + educacionD + ", hogarD=" + hogarD + ", vestimentaD=" + vestimentaD + ", saludD=" + saludD + '}';
    }
}