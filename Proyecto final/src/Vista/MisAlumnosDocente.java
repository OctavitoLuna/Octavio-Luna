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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Modelo.DatabaseConnection;

public class MisAlumnosDocente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public int personaId;
    private int numParalelo;

    public MisAlumnosDocente(int personaId, int numParalelo) {
        this.personaId = personaId;
        this.numParalelo = numParalelo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(55, 56, 289, 159);
        contentPane.add(textArea);
        
        // Llamada para cargar los alumnos en el JTextArea
        cargarAlumnos(textArea);
        
        JButton volver = new JButton("Volver");
        volver.setBounds(335, 11, 89, 23);
        contentPane.add(volver);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                misMateriasDocente misMateriasDocente = new misMateriasDocente(personaId);
                misMateriasDocente.setVisible(true);
                dispose();
            }
        });
        
        JButton modificar = new JButton("Modificar");
        modificar.setBounds(335, 226, 89, 23);
        contentPane.add(modificar);
        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MiAlumnoDocente miAlumnoDocente = new MiAlumnoDocente(personaId, numParalelo);
                miAlumnoDocente.setVisible(true);
                dispose();
            }
        });
    }


    private void cargarAlumnos(JTextArea textArea) {
        String sql = "SELECT p.nombre, p.apellidoP FROM persona p " +
                     "JOIN estudiantes e ON p.id_persona = e.persona_id_persona " +
                     "JOIN parestudiantes pe ON e.id_estudiante = pe.estudiantes_id_estudiante " +
                     "WHERE pe.paralelo_id_paralelo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numParalelo);
            ResultSet rs = stmt.executeQuery();

            StringBuilder alumnos = new StringBuilder();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                alumnos.append("Nombre: ").append(nombre).append(", Apellido Paterno: ").append(apellidoP).append("\n");
            }
            textArea.setText(alumnos.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MisAlumnosDocente frame = new MisAlumnosDocente(5, 1); 
            frame.setVisible(true);
        });
    }
}
