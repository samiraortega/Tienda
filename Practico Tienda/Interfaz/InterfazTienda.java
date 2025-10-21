package Interfaz;


import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;

public class InterfazTienda extends JFrame {
    private Tienda tienda;
    private JTextArea areaTexto;

    public InterfazTienda() {
        tienda = new Tienda("Mi Tienda de Videojuegos");

        setTitle("Sistema de Tienda - " + tienda.getNombre());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea(10, 60);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTabbedPane pestanas = new JTabbedPane();

        pestanas.addTab("Empleados", new crearPanelEmpleados(tienda, this));
        pestanas.addTab("Clientes", new crearPanelClientes(tienda, this));
        pestanas.addTab("Productos", new crearPanelProductos(tienda, this));
        pestanas.addTab("Ventas", new crearPanelVentas(tienda, this));
        pestanas.addTab("Consultas", new crearPanelConsultas(tienda, this));


        panelPrincipal.add(pestanas, BorderLayout.CENTER);
        panelPrincipal.add(scrollPane, BorderLayout.EAST);

        add(panelPrincipal);

        setVisible(true);
    }


    public void agregarTexto(String texto) {
        areaTexto.append(texto + "\n");
    }


}