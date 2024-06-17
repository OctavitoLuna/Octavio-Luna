package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import Vista.P_extranjero;
import Vista.P_regular;
import Vista.R_carrera;
import Vista.R_estudiante;
import Vista.P_intercambio;

public class Pantalla_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_1 frame = new Pantalla_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eje2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(259, 24, 72, 40);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Estudiante regular");
		btnNewButton.setBounds(72, 157, 120, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_regular P_regular = new P_regular();
				P_regular.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Estudiante extranjero");
		btnNewButton_1.setBounds(357, 157, 179, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_extranjero P_extranjero = new P_extranjero();
				P_extranjero.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Reporte Carrera");
		btnNewButton_2.setBounds(72, 227, 120, 21);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R_carrera R_carrera = new R_carrera();
				R_carrera.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Reporte Estudiante");
		btnNewButton_3.setBounds(357, 227, 120, 21);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R_estudiante R_estudiante = new R_estudiante();
				R_estudiante.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Estudiante intercambio");
		btnNewButton_4.setBounds(202, 156, 145, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_intercambio P_intercambio = new P_intercambio();
				P_intercambio.setVisible(true);
				dispose();
			}
		});
		
		JButton salir = new JButton("Salir");
		salir.setBounds(447, 35, 89, 23);
		contentPane.add(salir);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
