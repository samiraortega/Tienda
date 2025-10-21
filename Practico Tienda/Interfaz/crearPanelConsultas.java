package Interfaz;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;
import Tienda.Tienda;
import Tienda.Venta;

import javax.swing.*;
import java.awt.*;

public class crearPanelConsultas extends JPanel {
    private Tienda tienda;
    private InterfazTienda interfazTienda;


    public crearPanelConsultas(Tienda tienda, InterfazTienda interfazTienda) {
        this.tienda = tienda;
        this.interfazTienda = interfazTienda;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnMostrarEmpleados = new JButton("Mostrar Empleados");
        JButton btnMostrarClientes = new JButton("Mostrar Clientes");
        JButton btnMostrarProductos = new JButton("Mostrar Productos");
        JButton btnMostrarVentas = new JButton("Mostrar Ventas");
        JButton btnLimpiar = new JButton("Limpiar Consola");

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(btnMostrarEmpleados, gbc);

        gbc.gridy = 1;
        add(btnMostrarClientes, gbc);

        gbc.gridy = 2;
        add(btnMostrarProductos, gbc);

        gbc.gridy = 3;
        add(btnMostrarVentas, gbc);

        gbc.gridy = 4;
        add(btnLimpiar, gbc);

        btnMostrarEmpleados.addActionListener(e -> {
            interfazTienda.agregarTexto("");
            interfazTienda.agregarTexto("---- EMPLEADOS -----");
            for (Empleado emp : tienda.empleados.values()) {
                interfazTienda.agregarTexto("ID: " + emp.getId() + " - " + emp.getNombre() + " - " + emp.getPuesto());
            }
        });

        btnMostrarClientes.addActionListener(e -> {
            interfazTienda.agregarTexto("");
            interfazTienda.agregarTexto("---- CLIENTES ----");
            for (Cliente cli : tienda.clientes.values()) {
                interfazTienda.agregarTexto("ID: " + cli.getId() + " - " + cli.getNombre() + " - " + cli.getCorreo());
            }
        });

        btnMostrarProductos.addActionListener(e -> {
            interfazTienda.agregarTexto("");
            interfazTienda.agregarTexto("---- PRODUCTOS ----");
            for (Producto p : tienda.inventario) {
                interfazTienda.agregarTexto("[" + p + "] " + p.getNombre() + " - $" + p.getPrecio() + " (Stock: " + p.getStock() + ")");
            }
        });

        btnMostrarVentas.addActionListener(e -> {
            interfazTienda.agregarTexto("");
            interfazTienda.agregarTexto("---- VENTAS ----");
            for (Venta v : tienda.ventas) {
                interfazTienda.agregarTexto("Empleado: " + v.getEmpleado().getNombre() + " | Cliente: " + v.getCliente().getNombre() + " | Total: $" + v.getTotal());
            }
        });

        btnLimpiar.addActionListener(e -> interfazTienda.agregarTexto(""));


    }

}