package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Estudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int verificadorPersona;


	public Estudiante() {
		//Esto es para decir que somos estudiantes
		verificadorPersona = 2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton misDatos = new JButton("misDatos");
		misDatos.setBounds(44, 106, 89, 23);
		contentPane.add(misDatos);
		misDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisDatos MisDatos = new MisDatos(verificadorPersona);
				MisDatos.setVisible(true);
				dispose();
			}
		});
		
		JButton misMaterias = new JButton("misMaterias");
		misMaterias.setBounds(257, 106, 89, 23);
		contentPane.add(misMaterias);
		misMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton horario = new JButton("horario");
		horario.setBounds(108, 46, 89, 23);
		contentPane.add(horario);
		
		JButton inscripcion = new JButton("inscripcion");
		inscripcion.setBounds(257, 157, 89, 23);
		contentPane.add(inscripcion);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(334, 11, 89, 23);
		contentPane.add(salir);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
