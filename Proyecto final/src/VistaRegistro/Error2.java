package VistaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Error2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Debes ingresar datos correctos por favor, ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 76, 416, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No es muy dificil!!!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 144, 317, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton volver = new JButton("volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEstudiante RegistroEstudiante = new RegistroEstudiante();
				RegistroEstudiante.setVisible(true);
				dispose();
			}
		});
		volver.setBounds(308, 201, 85, 21);
		contentPane.add(volver);
	}

}
