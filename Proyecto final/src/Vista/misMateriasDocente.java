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

public class misMateriasDocente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public int personaId;
    private JComboBox<String> comboBoxParalelos;

    public misMateriasDocente(int personaId) {
        this.personaId = personaId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBoxParalelos = new JComboBox<>();
        comboBoxParalelos.setBounds(89, 58, 271, 22);
        contentPane.add(comboBoxParalelos);
        
        // Llamada para cargar los paralelos en el comboBox
        cargarParalelos();

        JButton volver = new JButton("Volver");
        volver.setBounds(335, 11, 89, 23);
        contentPane.add(volver);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Docente Docente = new Docente(personaId);
                Docente.setVisible(true);
                dispose();
            }
        });

        JButton ver = new JButton("Ver");
        ver.setBounds(264, 189, 89, 23);
        contentPane.add(ver);
        ver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedParalelo = (String) comboBoxParalelos.getSelectedItem();
                if (selectedParalelo != null) {
                    String[] parts = selectedParalelo.split(" ");
                    int numParalelo = Integer.parseInt(parts[parts.length - 1]);
                    MisAlumnosDocente misAlumnosDocente = new MisAlumnosDocente(personaId, numParalelo);
                    misAlumnosDocente.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Seleccione un paralelo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para cargar los paralelos en el JComboBox
    private void cargarParalelos() {
        String sql = "SELECT p.id_paralelo, m.nombre_materia, p.num_paralelo FROM paralelo p " +
                     "JOIN materia m ON p.Materia_id_materia = m.id_materia " +
                     "WHERE p.docente_id_docente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, personaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombreMateria = rs.getString("nombre_materia");
                int numParalelo = rs.getInt("num_paralelo");
                comboBoxParalelos.addItem(nombreMateria + " " + numParalelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            misMateriasDocente frame = new misMateriasDocente(5); // Ejemplo de uso, se debe ajustar según el contexto real
            frame.setVisible(true);
        });
    }
}
