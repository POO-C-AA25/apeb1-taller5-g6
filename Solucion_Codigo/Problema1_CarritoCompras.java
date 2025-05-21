import java.util.ArrayList;
import java.util.Scanner;

public class Problema1_CarritoCompras {
    public static void main(String[] args) {
        ArrayList<Producto> tienda = new ArrayList<>();
        tienda.add(new Producto("Camisa", 250, 10));
        tienda.add(new Producto("Pantalón", 400, 5));
        tienda.add(new Producto("Zapatos", 600, 3));

        CarritoDeCompras carrito = new CarritoDeCompras(tienda, 0.15);

        Scanner sc = new Scanner(System.in);
        String opcion;

        System.out.println("---TIENDA---");
        do {
            System.out.print("Ingrese el nombre del producto a comprar: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());
            carrito.agregarProducto(nombre, cantidad);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            opcion = sc.nextLine();
            System.out.println("--------------------------------------------");
        } while (opcion.equalsIgnoreCase("s"));

        carrito.mostrarDetalleCompra();
        double total = carrito.calcularTotal();
        System.out.println("TOTAL A PAGAR: $" + total);

        System.out.print("\nIngrese el monto a pagar: ");
        double monto = Double.parseDouble(sc.nextLine());
        carrito.realizarPago(monto);
        System.out.println("");

        sc.close();
    }
}

class CarritoDeCompras {
    private ArrayList<Producto> tienda;
    private ArrayList<Producto> carrito;
    private double descuento;

    public CarritoDeCompras(ArrayList<Producto> tienda, double descuento) {
        this.tienda = tienda;
        this.carrito = new ArrayList<>();
        this.descuento = descuento;
    }

    public boolean agregarProducto(String nombre, int cantidad) {
        for (Producto p : tienda) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                if (p.getCantidad() >= cantidad) {
                    carrito.add(new Producto(nombre, p.getPrecio(), cantidad));
                    return true;
                } else {
                    System.out.println("ERROR. No hay suficiente cantidad disponible.");
                    return false;
                }
            }
        }
        System.out.println("ERROR. Producto no encontrado en la tienda.");
        return false;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrecio() * p.getCantidad();
        }
        return total;
    }

    public void realizarPago(double montoPagado) {
        double total = calcularTotal();
        double descuentoAplicado = 0;
        if (montoPagado >= total) {
            if (total > 1000) {
                descuentoAplicado = total * descuento;
                total -= descuentoAplicado;
                System.out.println("\n¡Descuento del 15% aplicado! Se le restaron $" + descuentoAplicado);
            }
            System.out.println("¡Gracias por su compra!");
            for (Producto comprado : carrito) {
                for (Producto p : tienda) {
                    if (p.getNombre().equalsIgnoreCase(comprado.getNombre())) {
                        p.setCantidad(p.getCantidad() - comprado.getCantidad());
                    }
                }
            }
            System.out.println("Su cambio es: $" + (montoPagado - total));
        } else {
            System.out.println("Falta por pagar: $" + (total - montoPagado));
        }
    }

    public void mostrarDetalleCompra() {
        System.out.println("---FACTURA---");
        for (Producto p : carrito) {
            System.out.println(p.getNombre() + " x" + p.getCantidad() + " - $" + p.getPrecio());
            System.out.println("----------------------------");
        }
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}