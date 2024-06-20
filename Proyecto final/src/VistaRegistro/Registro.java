package VistaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.InicioSesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eres: ");
		lblNewLabel.setBounds(195, 20, 45, 13);
		contentPane.add(lblNewLabel);
		
		JRadioButton estudiante = new JRadioButton("estudiante");
		estudiante.setBounds(60, 79, 118, 34);
		contentPane.add(estudiante);
		
		JRadioButton docente = new JRadioButton("docente");
		docente.setBounds(231, 79, 107, 34);
		contentPane.add(docente);
		
		JButton registrar = new JButton("registrar");
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean reg = estudiante.isSelected();
				boolean regD = docente.isSelected();
				if (reg == true && regD == false) {
					RegistroEstudiante RegistroEstudiante = new RegistroEstudiante();
					RegistroEstudiante.setVisible(true);
					dispose();
				} else if (reg == false && regD == true){
					RegistroDocente RegistroDocente = new RegistroDocente();
					RegistroDocente.setVisible(true);
					dispose();
				}
				else if(regD== true && reg ==true) {
					JOptionPane.showMessageDialog(registrar, "ERROR NO PUEDES SELECCIONAR LOS DOS");
				}
				else if(regD== false && reg ==false) {
					JOptionPane.showMessageDialog(registrar, "ERROR DEBES SELECCIONAR MINIMO UNA");
				}
			}
		});
		registrar.setBounds(150, 158, 85, 21);
		contentPane.add(registrar);
		
		JButton volver = new JButton("volver");
		volver.setBounds(314, 214, 85, 21);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion InicioSesion = new InicioSesion();
				InicioSesion.setVisible(true);
				dispose();
			}
		});
	}
}
