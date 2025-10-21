package Tienda;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {
    private String nombre;
    public HashMap <Integer,Empleado> empleados;
    public HashMap<Integer, Cliente> clientes;
    public ArrayList<Producto> inventario;
    public ArrayList<Venta> ventas;

    public Tienda(String nombre) {
        this.nombre=nombre;
        this.empleados=new HashMap<>();
        this.inventario = new ArrayList<>();
        this.clientes = new HashMap<>();
        this.ventas = new ArrayList<>();
    }

    public void agregarEmpleados (Empleado emp){
        empleados.put(emp.getId(), emp);
        System.out.println("\n");
        System.out.println("----Empleado agregado----");
        emp.mostrarInfo();
    }
    public void agregarCliente (Cliente c){
        clientes.put(c.getId(), c);
        System.out.println("\n");
        System.out.println("---Cliente agregado---");
        c.mostrarInfo();
    }


    public void agregarProducto(Producto p) {
        inventario.add(p);
        System.out.println("\n");
        System.out.println("Se agrego el producto");
        p.mostrarInfo();
    }

    public void mostrarClientes() {
        for (Cliente e : clientes.values()) {
            System.out.println("\n");
            System.out.println("Lista de estudiantes: ");
            e.mostrarInfo();
        }
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados.values()){
            System.out.println("\n");
            System.out.println("Lista de Empleados: ");
            e.mostrarInfo();
            }
    }

    public void mostrarProductos() {
        for (Producto p : inventario) {
            p.mostrarInfo();
        }
    }

    public void mostrarVentas() {
        for (Venta v : ventas) {
            v.mostrarDetalle();
        }
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
        System.out.println("\n");
        System.out.println("Venta registrada");
    }

    public Empleado crearEmpleado(String nombre, int id, String puesto) {
        Empleado emp = new Empleado(nombre, id, puesto);
        agregarEmpleados(emp);
        return emp;

    }

    public Cliente crearCliente(String nombre, int id, String correo) {
        Cliente c = new Cliente(nombre, id, correo);
        agregarCliente(c);
        return c;
    }


    public String getNombre() {
        return nombre;
    }
}