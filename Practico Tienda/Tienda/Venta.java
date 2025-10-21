package Tienda;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;

import java.util.ArrayList;

public class Venta {
    private Empleado empleado;
    private Cliente cliente;
    private int empleadoId;
    private ArrayList<Producto> items;
    public double total;

    public Venta(Empleado empleado, Cliente cliente) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.items = new ArrayList<>();
        this.total = 0;
        this.empleadoId = empleado.getId();
    }

    public void agregarProducto(Producto producto) {
        items.add(producto);
        total += producto.getPrecio();
    }

    public double getTotal() {
        return total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public ArrayList<Producto> getItems() {
        return items;
    }

    public void mostrarDetalle() {
        System.out.println("\n");
        System.out.println("--- Venta ---");
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Id del Empleado: " + getEmpleadoId());
        System.out.println("Cliente: " + cliente.getNombre());
        items.forEach(Producto::mostrarInfo);
        System.out.println("Total compra: " + getTotal());
    }

}
