package Interfaz;

import javax.swing.*;
import java.awt.*;
import Tienda.Tienda;
import Producto.Producto;
import Producto.Videojuego;
import Producto.Accesorio;
import Producto.Consola;

public class crearPanelProductos extends JPanel {
    private Tienda tienda;
    private InterfazTienda interfazTienda;


    public crearPanelProductos(Tienda tienda, InterfazTienda interfazTienda) {
        this.tienda = tienda;
        this.interfazTienda = interfazTienda;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblTipo = new JLabel("Tipo:");
        String[] tipos = {"Videojuego", "Consola", "Accesorio"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(20);
        JLabel lblStock = new JLabel("Stock:");
        JTextField txtStock = new JTextField(20);

        JPanel panelExtra = new JPanel(new CardLayout());

        JPanel panelVideojuego = new JPanel(new GridLayout(2, 2, 5, 5));
        panelVideojuego.add(new JLabel("Género:"));
        JTextField txtGenero = new JTextField();
        panelVideojuego.add(txtGenero);
        panelVideojuego.add(new JLabel("Plataforma:"));
        JTextField txtPlataforma = new JTextField();
        panelVideojuego.add(txtPlataforma);

        JPanel panelConsola = new JPanel(new GridLayout(2, 2, 5, 5));
        panelConsola.add(new JLabel("Fabricante:"));
        JTextField txtFabricante = new JTextField();
        panelConsola.add(txtFabricante);
        panelConsola.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        panelConsola.add(txtModelo);

        JPanel panelAccesorio = new JPanel(new GridLayout(1, 2, 5, 5));
        panelAccesorio.add(new JLabel("Tipo:"));
        JTextField txtTipoAcc = new JTextField();
        panelAccesorio.add(txtTipoAcc);

        panelExtra.add(panelVideojuego, "Videojuego");
        panelExtra.add(panelConsola, "Consola");
        panelExtra.add(panelAccesorio, "Accesorio");

        JButton btnAgregar = new JButton("Agregar Producto");

        gbc.gridx = 0; gbc.gridy = 0;

        add(lblTipo, gbc);
        gbc.gridx = 1;

        add(cmbTipo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;

        add(lblNombre, gbc);
        gbc.gridx = 1;

        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;

        add(lblPrecio, gbc);
        gbc.gridx = 1;

        add(txtPrecio, gbc);

        gbc.gridx = 0; gbc.gridy = 3;

        add(lblStock, gbc);
        gbc.gridx = 1;

        add(txtStock, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;

        add(panelExtra, gbc);

        gbc.gridy = 5;

        add(btnAgregar, gbc);

        cmbTipo.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelExtra.getLayout();
            cl.show(panelExtra, (String) cmbTipo.getSelectedItem());
        });

        btnAgregar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String tipo = (String) cmbTipo.getSelectedItem();

                Producto p;
                if (tipo.equals("Videojuego")) {
                    p = new Videojuego(nombre, precio, stock, txtGenero.getText(), txtPlataforma.getText());
                } else if (tipo.equals("Consola")) {
                    p = new Consola(nombre, precio, stock, txtFabricante.getText(), txtModelo.getText());
                } else {
                    p = new Accesorio(nombre, precio, stock, txtTipoAcc.getText());
                }

                tienda.agregarProducto(p);
                interfazTienda.agregarTexto("Producto agregado: " + nombre);

                txtNombre.setText("");
                txtPrecio.setText("");
                txtStock.setText("");
                txtGenero.setText("");
                txtPlataforma.setText("");
                txtFabricante.setText("");
                txtModelo.setText("");
                txtTipoAcc.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Precio y Stock deben ser números");
            }
        });
    }
}