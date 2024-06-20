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

public class MisMateriasEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int personaId;
	private JComboBox<String> comboBox; 

	public MisMateriasEstudiante(int personaId) {
		this.personaId = personaId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		comboBox = new JComboBox<>();
		comboBox.setBounds(111, 94, 252, 22);
		contentPane.add(comboBox);

		cargarMaterias();

		JButton volver = new JButton("volver");
		volver.setBounds(335, 11, 89, 23);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante Estudiante = new Estudiante(personaId);
				Estudiante.setVisible(true);
				dispose();
			}
		});
		
		JButton ver = new JButton("ver");
		ver.setBounds(188, 208, 89, 23);
		contentPane.add(ver);
		
		JLabel lblNewLabel = new JLabel("Mis materias");
		lblNewLabel.setBounds(181, 32, 106, 14);
		contentPane.add(lblNewLabel);
		ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisNotasEstudiante MisNotasEstudiante = new MisNotasEstudiante(personaId);
				MisNotasEstudiante.setVisible(true);
				dispose();
			}
		});
	}

	
	private void cargarMaterias() {
		String sql = "SELECT m.nombre_materia FROM materia m " +
		             "JOIN paralelo p ON m.id_materia = p.Materia_id_materia " +
		             "JOIN parestudiantes pe ON p.id_paralelo = pe.paralelo_id_paralelo " +
		             "WHERE pe.estudiantes_id_estudiante = ?";

		try (Connection conn = DatabaseConnection.getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, personaId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String materia = rs.getString("nombre_materia");
				comboBox.addItem(materia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MisMateriasEstudiante frame = new MisMateriasEstudiante(1); 
			frame.setVisible(true);
		});
	}
}
