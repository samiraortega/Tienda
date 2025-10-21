package Interfaz;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    Color rosa = new Color(255, 172, 199);
    Color rosaBoton = new Color(224, 107, 128);

    public Login() {
        setTitle("Iniciar");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.pink);

        crearFormulario();

    }


    private void crearFormulario() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelPrincipal.setBackground(Color.pink);

        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.white);
        ImageIcon imagenLogo = new ImageIcon("Practico Tienda/resources/logoLogin.png");
        JLabel logo = new JLabel(imagenLogo);
        panelLogo.add(logo);

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 30, 30));
        panelForm.setBackground(Color.pink);

        panelForm.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        panelForm.add(txtUsuario);

        panelForm.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panelForm.add(txtPassword);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(rosaBoton);
        panelForm.add(btnIngresar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(rosaBoton);
        panelForm.add(btnCancelar);

        btnIngresar.addActionListener(e -> validarLogin());
        btnCancelar.addActionListener(e -> System.exit(0));
        txtPassword.addActionListener(e -> validarLogin());


        panelPrincipal.add(panelLogo, BorderLayout.NORTH);
        panelPrincipal.add(panelForm, BorderLayout.SOUTH);

        add(panelPrincipal);

    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());
        if (usuario.equals("admin") && password.equals("1234")) {
            this.dispose();
            InterfazTienda ventana = new InterfazTienda();
            ventana.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            txtPassword.setText("");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }

}