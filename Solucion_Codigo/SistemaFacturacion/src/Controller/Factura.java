package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class Factura implements Serializable{

    // Atributos
    public List<Producto> carrito = new ArrayList<>();
    public double subTotal;
    public double sumaDescuentos;
    public double subDescuentoAfiliado;
    public double iva = 0.15;
    public double subIva;
    public double total;
    public String cliente;
    public int cedula;
    public String direccion;
    public int numFactura;
    public String fecha;
    public int autorizacionSRI;
    public String formaPago;
    public int alimentacionD;
    public int educacionD;
    public int hogarD;
    public int vestimentaD;
    public int saludD;
    public double descuentoAfiliado = 0.05;

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
        calcularDescuentos();
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
            this.sumaDescuentos += producto.descuento;
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
            this.total = subTotal - (subTotal*sumaDescuentos);
            this.subDescuentoAfiliado = total * descuentoAfiliado;
            this.total = total - subDescuentoAfiliado;
            this.subIva = total * iva;
            this.total = total + subIva;
        } else {
            this.total = subTotal - (subTotal*sumaDescuentos);
            this.subDescuentoAfiliado = 0;
            this.subIva = total * iva;
            this.total = total + subIva;
        }
    }
    
    @Override
    public String toString() {
        return "Factura{" + "carrito=" + carrito + ", subTotal=" + subTotal + ", sumaDescuentos=" + sumaDescuentos
                + ", subDescuentoAfiliado=" + subDescuentoAfiliado + ", iva=" + iva + ", subIva=" + subIva + ", total="
                + total + ", cliente=" + cliente + ", cedula=" + cedula + ", direccion=" + direccion + ", numFactura="
                + numFactura + ", fecha=" + fecha + ", autorizacionSRI=" + autorizacionSRI + ", formaPago=" + formaPago
                + ", alimentacionD=" + alimentacionD + ", educacionD=" + educacionD + ", hogarD=" + hogarD
                + ", vestimentaD=" + vestimentaD + ", saludD=" + saludD + '}';
    }
}