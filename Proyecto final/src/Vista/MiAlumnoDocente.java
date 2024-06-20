package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

public class MiAlumnoDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int personaId;
	public int numParalelo;

	public MiAlumnoDocente(int personaId, int numParalelo) {
		this.personaId = personaId;
		this.numParalelo = numParalelo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("modificar");
		btnNewButton.setBounds(182, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 11, 89, 23);
		contentPane.add(volver);
		
		JLabel lblNewLabel = new JLabel("Alumno");
		lblNewLabel.setBounds(182, 41, 46, 14);
		contentPane.add(lblNewLabel);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisAlumnosDocente MisAlumnosDocente = new MisAlumnosDocente(personaId, numParalelo);
				MisAlumnosDocente.setVisible(true);
                dispose();
			}
		});
	}
}
