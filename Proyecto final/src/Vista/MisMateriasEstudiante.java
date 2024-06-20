package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MisMateriasEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int personaId;

	public MisMateriasEstudiante(int personaId) {
		this.personaId = personaId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(111, 94, 252, 22);
		contentPane.add(comboBox);
		
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
		ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisNotasEstudiante MisNotasEstudiante = new MisNotasEstudiante();
				MisNotasEstudiante.setVisible(true);
				dispose();
			}
		});
	}
}
