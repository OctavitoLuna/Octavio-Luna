package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

public class MisNotasEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int personaId;

	public MisNotasEstudiante(int personaId) {
		this.personaId = personaId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 66, 326, 151);
		contentPane.add(textArea);
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 0, 89, 23);
		contentPane.add(volver);
		
		JLabel lblNewLabel = new JLabel("Mis notas");
		lblNewLabel.setBounds(171, 11, 46, 14);
		contentPane.add(lblNewLabel);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisMateriasEstudiante MisMateriasEstudiante = new MisMateriasEstudiante(personaId);
				MisMateriasEstudiante.setVisible(true);
				dispose();
			}
		});
	}

}
