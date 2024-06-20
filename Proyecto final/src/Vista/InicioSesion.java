package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import Modelo.DatabaseConnection;
import VistaRegistro.Registro;

import java.awt.Color;

public class InicioSesion extends JFrame {
    private JTextField nombreField;
    private JPasswordField contrasenaField;
    private JButton iniciarButton;
    private JButton registrarButton;
    private int personaId; 

    public InicioSesion() {
    	getContentPane().setBackground(new Color(255, 255, 0));
        setTitle("Inicio de Sesión");
        setSize(321, 249);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(50, 30, 80, 25);
        getContentPane().add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(150, 30, 100, 25);
        getContentPane().add(nombreField);

        JLabel contrasenaLabel = new JLabel("Contraseña");
        contrasenaLabel.setBounds(50, 70, 80, 25);
        getContentPane().add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(150, 70, 100, 25);
        getContentPane().add(contrasenaField);

        iniciarButton = new JButton("Iniciar");
        iniciarButton.setBounds(50, 110, 200, 25);
        getContentPane().add(iniciarButton);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(50, 140, 200, 25);
        getContentPane().add(registrarButton);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Registro Registro = new Registro();
				Registro.setVisible(true);
                dispose();
            }
        });
    }

    private void iniciarSesion() {
        String nombre = nombreField.getText();
        String contrasena = new String(contrasenaField.getPassword());
        String sql = "SELECT p.id_persona, e.id_estudiante, d.id_docente FROM persona p LEFT JOIN estudiantes e ON p.id_persona = e.persona_id_persona LEFT JOIN docente d ON p.id_persona = d.persona_id_persona WHERE p.nombre = ? AND p.contrasena = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                personaId = rs.getInt("id_persona");
                int idEstudiante = rs.getInt("id_estudiante");
                int idDocente = rs.getInt("id_docente");

                if (idEstudiante != 0) {

                    JOptionPane.showMessageDialog(this, "Bienvenido estudiante");
    				Estudiante Estudiante = new Estudiante(personaId);
    				Estudiante.setVisible(true);
                    dispose();
                } else if (idDocente != 0) {

                    JOptionPane.showMessageDialog(this, "Bienvenido docente");
                    Docente Docente = new Docente(personaId);
    				Docente.setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nombre o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }
}
