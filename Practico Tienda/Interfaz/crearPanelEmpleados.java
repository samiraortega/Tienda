package Interfaz;

import javax.swing.*;
import java.awt.*;
import Tienda.Tienda;

public class crearPanelEmpleados extends JPanel{
    private Tienda tienda;
    private InterfazTienda interfazTienda;

    public crearPanelEmpleados(Tienda tienda, InterfazTienda interfazTienda) {
        this.tienda = tienda;
        this.interfazTienda = interfazTienda;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField(20);
        JLabel lblPuesto = new JLabel("Puesto:");
        JTextField txtPuesto = new JTextField(20);
        JButton btnAgregar = new JButton("Agregar Empleado");

        gbc.gridx = 0; gbc.gridy = 0;
       add(lblNombre, gbc);
        gbc.gridx = 1;
       add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
       add(lblId, gbc);
        gbc.gridx = 1;
       add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
       add(lblPuesto, gbc);
        gbc.gridx = 1;
       add(txtPuesto, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
       add(btnAgregar, gbc);

        btnAgregar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                int id = Integer.parseInt(txtId.getText());
                String puesto = txtPuesto.getText();

                tienda.crearEmpleado(nombre, id, puesto);
                interfazTienda.agregarTexto("Empleado agregado: " + nombre + " (ID: " + id + ")");

                txtNombre.setText("");
                txtId.setText("");
                txtPuesto.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un número");
            }
        });
    }
}