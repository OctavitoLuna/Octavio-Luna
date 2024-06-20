package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Vista.MisMateriasEstudiante;
import java.awt.Color;
import javax.swing.JLabel;

public class Estudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int verificadorPersona;
	public int personaId;
	


	public Estudiante(int personaId) {
		this.personaId = personaId;
		//Esto es para decir que somos estudiantes
		verificadorPersona = 2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton misDatos = new JButton("misDatos");
		misDatos.setBounds(44, 106, 89, 23);
		contentPane.add(misDatos);
		misDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisDatos MisDatos = new MisDatos(verificadorPersona, personaId);
				MisDatos.setVisible(true);
				dispose();
			}
		});
		
		JButton misMaterias = new JButton("misMaterias");
		misMaterias.setBounds(257, 106, 89, 23);
		contentPane.add(misMaterias);
		misMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisMateriasEstudiante MisMateriasEstudiante = new MisMateriasEstudiante(personaId);
				MisMateriasEstudiante.setVisible(true);
				dispose();
			}
		});

		
		JButton inscripcion = new JButton("inscripcion");
		inscripcion.setBounds(257, 157, 89, 23);
		contentPane.add(inscripcion);
		inscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscribirmeEstudiante InscribirmeEstudiante = new InscribirmeEstudiante(personaId);
				InscribirmeEstudiante.setVisible(true);
				dispose();
			}
		});
		
		
		
		JButton salir = new JButton("Salir");
		salir.setBounds(334, 11, 89, 23);
		contentPane.add(salir);
		
		JLabel lblNewLabel = new JLabel("Bienvenido estudiante");
		lblNewLabel.setBounds(187, 47, 137, 14);
		contentPane.add(lblNewLabel);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
