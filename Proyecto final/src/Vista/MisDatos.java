package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class MisDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int verificadorPersona;

	public MisDatos(int verificadorPersona) {
		this.verificadorPersona = verificadorPersona;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(64, 11, 283, 202);
		contentPane.add(textPane);
		
		if(verificadorPersona == 1) {
			//devolver docente
			System.out.println("Docente");
		}
		else {
			//devolver estudiante
			System.out.println("Estudiante");	
		}
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 227, 89, 23);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(verificadorPersona == 1) {
					Docente Docente = new Docente();
					Docente.setVisible(true);
					dispose();
				}
				else {
					Estudiante Estudiante = new Estudiante();
					Estudiante.setVisible(true);
					dispose();
				}

			}
		});
		
		
	}
}
