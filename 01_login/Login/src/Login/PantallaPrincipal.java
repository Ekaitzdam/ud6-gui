package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private JTextField textoUsuario;
    private JButton loginButton;
    private JPanel PantallaPrincipal;
    private JPasswordField contraseniaUsuario;


    public PantallaPrincipal() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Usuario
                String usuario =textoUsuario.getText();
                //Contraseña
                String contrasenia = new String (contraseniaUsuario.getPassword());

                if(usuario.equalsIgnoreCase("pepe") && contrasenia.equalsIgnoreCase("12345")){
                    JOptionPane.showMessageDialog(PantallaPrincipal, "OK");
                } else{
                    JOptionPane.showMessageDialog(PantallaPrincipal, "ERROR");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PantallaPrincipal");
        frame.setContentPane(new PantallaPrincipal().PantallaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
