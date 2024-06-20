package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.DatabaseConnection;
import java.awt.Color;
import javax.swing.JLabel;

public class InscribirmeEstudiante extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public int personaId;
    private JComboBox<String> comboBoxParalelos;

    public InscribirmeEstudiante(int personaId) {
        this.personaId = personaId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBoxParalelos = new JComboBox<>();
        comboBoxParalelos.setBounds(94, 106, 252, 22);
        contentPane.add(comboBoxParalelos);

        // funcion para cargar los paralelos al combox
        cargarParalelos();

        JButton volver = new JButton("Volver");
        volver.setBounds(335, 11, 89, 23);
        contentPane.add(volver);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Estudiante estudiante = new Estudiante(personaId);
                estudiante.setVisible(true);
                dispose();
            }
        });

        JButton inscribirse = new JButton("Inscribirse");
        inscribirse.setBounds(188, 208, 89, 23);
        contentPane.add(inscribirse);
        
        JLabel lblNewLabel = new JLabel("Inscribirme a un paralelo");
        lblNewLabel.setBounds(177, 42, 140, 14);
        contentPane.add(lblNewLabel);
        inscribirse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inscribirEstudiante();
            }
        });
    }

    // cargar paralelos
    private void cargarParalelos() {
        String sql = "SELECT p.id_paralelo, m.nombre_materia, p.num_paralelo FROM paralelo p " +
                     "JOIN materia m ON p.Materia_id_materia = m.id_materia " +
                     "WHERE p.id_paralelo NOT IN (SELECT paralelo_id_paralelo FROM parestudiantes WHERE estudiantes_id_estudiante = ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, personaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idParalelo = rs.getInt("id_paralelo");
                String nombreMateria = rs.getString("nombre_materia");
                String numParalelo = rs.getString("num_paralelo");
                comboBoxParalelos.addItem(idParalelo + " - " + nombreMateria + " " + numParalelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // esto es para inscribirse
    private void inscribirEstudiante() {
        String selectedItem = (String) comboBoxParalelos.getSelectedItem();
        if (selectedItem != null) {
            String[] parts = selectedItem.split(" - ");
            int idParalelo = Integer.parseInt(parts[0]);

            String sql = "INSERT INTO parestudiantes (paralelo_id_paralelo, estudiantes_id_estudiante) VALUES (?, ?)";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idParalelo);
                stmt.setInt(2, personaId);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Inscripción exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al inscribir en el paralelo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un paralelo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InscribirmeEstudiante frame = new InscribirmeEstudiante(1); 
            frame.setVisible(true);
        });
    }
}
