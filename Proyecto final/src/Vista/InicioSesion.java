package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VistaRegistro.Registro;


import javax.swing.JTextField;
import javax.swing.JButton;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtContrasena;


	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(160, 80, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setText("contrasena");
		txtContrasena.setBounds(160, 111, 86, 20);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JButton iniciar = new JButton("iniciar");
		iniciar.setBounds(160, 185, 89, 23);
		contentPane.add(iniciar);
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Momentaneamente
				Docente Docente = new Docente();
				Docente.setVisible(true);
				dispose();
				//Estudiante Estudiante = new Estudiante();
				//Estudiante.setVisible(true);
				//dispose();
			}
		});

		
		JButton registrar = new JButton("Registrar");
		registrar.setBounds(335, 11, 89, 23);
		contentPane.add(registrar);
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro Registro = new Registro();
				Registro.setVisible(true);
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
