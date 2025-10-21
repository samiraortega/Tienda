package Interfaz;

import Persona.Cliente;
import Persona.Empleado;
import Tienda.Tienda;
import Tienda.Venta;
import Producto.Producto;

import javax.swing.*;
import java.awt.*;


public class crearPanelVentas extends JPanel {
    private Tienda tienda;
    private InterfazTienda interfazTienda;
    private Venta ventaActual;
    private JComboBox<String> cmbEmpleados;
    private JComboBox<String> cmbClientes;
    private JComboBox<String> cmbProductos;

    public crearPanelVentas(Tienda tienda, InterfazTienda interfazTienda) {
        this.tienda = tienda;
        this.interfazTienda = interfazTienda;
        this.ventaActual = null;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblEmpleado = new JLabel("Empleado:");
        cmbEmpleados = new JComboBox<>();
        cargarEmpleados();

        JLabel lblCliente = new JLabel("Cliente:");
        cmbClientes = new JComboBox<>();
        cargarClientes();

        JLabel lblProducto = new JLabel("Producto:");
        cmbProductos = new JComboBox<>();
        cargarProductos();

        JButton btnActualizar = new JButton("Actualizar Listas");
        JButton btnAgregarProducto = new JButton("Agregar Producto a Venta");
        JButton btnCrearVenta = new JButton("Crear Nueva Venta");
        JButton btnFinalizarVenta = new JButton("Finalizar Venta");

        gbc.gridx = 0; gbc.gridy = 0;
        add(lblEmpleado, gbc);
        gbc.gridx = 1;
        add(cmbEmpleados, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblCliente, gbc);
        gbc.gridx = 1;
        add(cmbClientes, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnActualizar, gbc);

        gbc.gridy = 3;
        add(btnCrearVenta, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(lblProducto, gbc);
        gbc.gridx = 1;
        add(cmbProductos, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(btnAgregarProducto, gbc);

        gbc.gridy = 6;
        add(btnFinalizarVenta, gbc);

        btnActualizar.addActionListener(e -> {
            cargarEmpleados();
            cargarClientes();
            cargarProductos();
            interfazTienda.agregarTexto("Listas actualizadas");
        });

        btnCrearVenta.addActionListener(e -> {
            String selectedEmp = (String) cmbEmpleados.getSelectedItem();
            String selectedCli = (String) cmbClientes.getSelectedItem();

            if (selectedEmp == null || selectedCli == null) {
                JOptionPane.showMessageDialog(this, "No hay empleados o clientes disponibles");
                return;
            }

            int idEmp = Integer.parseInt(selectedEmp.split(" - ")[0]);
            int idCli = Integer.parseInt(selectedCli.split(" - ")[0]);

            Empleado emp = tienda.empleados.get(idEmp);
            Cliente cli = tienda.clientes.get(idCli);

            ventaActual = new Venta(emp, cli);
            interfazTienda.agregarTexto("Nueva venta creada");
        });

        btnAgregarProducto.addActionListener(e -> {
            if (ventaActual == null) {
                JOptionPane.showMessageDialog(this, "Primero crea una venta");
                return;
            }

            String selectedProd = (String) cmbProductos.getSelectedItem();

            if (selectedProd == null) {
                JOptionPane.showMessageDialog(this, "No hay productos disponibles");
                return;
            }

            int numProd = Integer.parseInt(selectedProd.split(" - ")[0]);
            if (numProd >= 0 && numProd < tienda.inventario.size()) {
                Producto p = tienda.inventario.get(numProd);
                ventaActual.agregarProducto(p);
                interfazTienda.agregarTexto("Producto agregado: " + p.getNombre() + " - $" + p.getPrecio());
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }
        });

        btnFinalizarVenta.addActionListener(e -> {
            if (ventaActual != null) {
                tienda.registrarVenta(ventaActual);
                interfazTienda.agregarTexto("Venta finalizada. Total: $" + ventaActual.getTotal());
                ventaActual = null;
            }
        });
    }

    private void cargarEmpleados() {
        cmbEmpleados.removeAllItems();
        for (Empleado emp : tienda.empleados.values()) {
            cmbEmpleados.addItem(emp.getId() + " - " + emp.getNombre());
        }
    }

    private void cargarClientes() {
        cmbClientes.removeAllItems();
        for (Cliente cli : tienda.clientes.values()) {
            cmbClientes.addItem(cli.getId() + " - " + cli.getNombre());
        }
    }

    private void cargarProductos() {
        cmbProductos.removeAllItems();
        for (int i = 0; i < tienda.inventario.size(); i++) {
            Producto p = tienda.inventario.get(i);
            cmbProductos.addItem(i + " - " + p.getNombre() + " - $" + p.getPrecio());
        }
    }
}