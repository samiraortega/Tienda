package Interfaz;

import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;

public class crearPanelClientes extends JPanel {
    private Tienda tienda;
    private InterfazTienda interfazTienda;


    public crearPanelClientes(Tienda tienda, InterfazTienda interfazTienda) {
        this.tienda = tienda;
        this.interfazTienda = interfazTienda;
        Color rosa = new Color(255, 172, 199);
        Color rosaBoton = new Color(224, 107, 128);



        setLayout( new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        setBackground(rosa);


        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField(20);

        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField(20);


        JButton btnAgregar = new JButton("Agregar Cliente");
        btnAgregar.setBackground(rosaBoton);

        gbc.gridx = 0; gbc.gridy = 0;
        add(lblNombre, gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblId, gbc);
        gbc.gridx = 1;
        add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblCorreo, gbc);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnAgregar, gbc);

        btnAgregar.addActionListener(e -> {
                String nombre = txtNombre.getText();
                String id = txtId.getText();
                String correo = txtCorreo.getText();
                int idInt = Integer.parseInt(id);


                tienda.crearCliente(nombre, idInt, correo);
                interfazTienda.agregarTexto("Cliente agregado: " + nombre + " (ID: " + id + ")");

                txtNombre.setText("");
                txtId.setText("");
                txtCorreo.setText("");

        });

    }
}