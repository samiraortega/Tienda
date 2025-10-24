package RegistrarDatos;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;
import Tienda.Venta;

import java.io.*;

public class RegistrarDatos {

    public static final String Venta_File = "Venta.txt";
    public static final String Cliente_File = "Cliente.txt";
    public static final String Empleado_File = "Empleado.txt";
    public static final String Productos_File = "Producto.txt";



    public static void main(String[] args) {
    }

    public static void guardarVenta (Venta venta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Venta_File,true))){
            StringBuilder Productotxt = new StringBuilder();
            Productotxt.append(venta.getEmpleado().getNombre()).append(";").append(venta.getCliente().getNombre());
            for (Producto p : venta.getItems() ){
                Productotxt.append(p.getNombre());
            }
            bw.write((Productotxt)+";"+venta.getTotal());
            bw.newLine();        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void guardarCliente (Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Cliente_File,true))){
            StringBuilder Clientetxt = new StringBuilder();
            Clientetxt.append(cliente.mostrarInfo());
            bw.newLine();
            }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void guardarEmpleado (Empleado empleado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Empleado_File,true))){
            StringBuilder Empleadotxt = new StringBuilder();
            Empleadotxt.append(empleado.mostrarInfo());
            bw.newLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void guardarProducto (Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Productos_File,true))){
            StringBuilder Productotxt = new StringBuilder();
            Productotxt.append(producto.getNombre()).append(producto.getPrecio());
            bw.newLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}

