package VistaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class matDisponibles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int contador;
	

	
	public matDisponibles(int contador) {
		this.contador = contador;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Materias Disponible:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(87, 76, 214, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(81, 99, 220, 21);
		contentPane.add(comboBox);
		
		JButton tomar = new JButton("tomar y sigue");
		tomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					TipoCalificacion TipoCalificacion = new TipoCalificacion(contador);
					TipoCalificacion.setVisible(true);
					dispose();
				
				
			}
		});
		tomar.setBounds(145, 130, 110, 21);
		contentPane.add(tomar);
	}

}
