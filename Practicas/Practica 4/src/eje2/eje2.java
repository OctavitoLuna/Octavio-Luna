package eje2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class eje2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtContraseaAntigua;
    private JTextField txtContraseaNueva;
    private JTextField txtRepitaContrasea;
    private JComboBox<String> comboBoxUsuarios;
    private HashMap<String, String> usuarios;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    eje2 frame = new eje2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public eje2() {
        usuarios = new HashMap<>();
        usuarios.put("Octavio", "A1qwertyui!");
        usuarios.put("Juan", "A2qwertyui!");
        usuarios.put("Pedro", "A3qwertyui");
        usuarios.put("Einar", "A4qwertyui");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 593, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBoxUsuarios = new JComboBox<>();
        comboBoxUsuarios.setModel(new DefaultComboBoxModel<>(usuarios.keySet().toArray(new String[0])));
        comboBoxUsuarios.setBounds(122, 104, 302, 22);
        contentPane.add(comboBoxUsuarios);

        txtContraseaAntigua = new JTextField();
        txtContraseaAntigua.setText("Contraseña Antigua");
        txtContraseaAntigua.setBounds(122, 137, 302, 20);
        contentPane.add(txtContraseaAntigua);
        txtContraseaAntigua.setColumns(10);

        txtContraseaNueva = new JTextField();
        txtContraseaNueva.setText("Contraseña nueva");
        txtContraseaNueva.setBounds(122, 168, 302, 20);
        contentPane.add(txtContraseaNueva);
        txtContraseaNueva.setColumns(10);

        txtRepitaContrasea = new JTextField();
        txtRepitaContrasea.setText("Repita contraseña");
        txtRepitaContrasea.setBounds(122, 199, 302, 20);
        contentPane.add(txtRepitaContrasea);
        txtRepitaContrasea.setColumns(10);

        JLabel lblNewLabel = new JLabel("CAMBIOS DE CONTRASEÑA");
        lblNewLabel.setBounds(166, 37, 178, 14);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Cambiar");
        btnNewButton.setBounds(232, 269, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarContrasena();
            }
        });
        contentPane.add(btnNewButton);
    }

    private void cambiarContrasena() {
        String usuario = (String) comboBoxUsuarios.getSelectedItem();
        String contrasenaAntigua = txtContraseaAntigua.getText();
        String contrasenaNueva = txtContraseaNueva.getText();
        String repitaContrasena = txtRepitaContrasea.getText();

        if (!usuarios.containsKey(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            return;
        }

        if (!usuarios.get(usuario).equals(contrasenaAntigua)) {
            JOptionPane.showMessageDialog(this, "La contraseña antigua es incorrecta");
            return;
        }

        if (!contrasenaNueva.equals(repitaContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas nuevas no coinciden");
            return;
        }

        if (contrasenaNueva.equals(contrasenaAntigua)) {
            JOptionPane.showMessageDialog(this, "La nueva contraseña no puede ser igual a la antigua");
            return;
        }

        if (contrasenaNueva.length() < 8) {
            JOptionPane.showMessageDialog(this, "La nueva contraseña debe tener al menos 8 caracteres");
            return;
        }

        usuarios.put(usuario, contrasenaNueva);
        JOptionPane.showMessageDialog(this, "Contraseña cambiada con éxito");
    }
}
