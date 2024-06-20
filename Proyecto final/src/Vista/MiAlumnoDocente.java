package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 46, 249, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("modificar");
		btnNewButton.setBounds(182, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 11, 89, 23);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisAlumnosDocente MisAlumnosDocente = new MisAlumnosDocente(personaId, numParalelo);
				MisAlumnosDocente.setVisible(true);
                dispose();
			}
		});
	}
}
