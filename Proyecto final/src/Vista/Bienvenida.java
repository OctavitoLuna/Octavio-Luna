package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton para entrar
		JButton entrar = new JButton("Entrar");
		entrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		entrar.setBounds(250, 409, 89, 23);
		contentPane.add(entrar);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion InicioSesion = new InicioSesion();
				InicioSesion.setVisible(true);
				dispose();
			}
		});
		
		//Boton para salir
		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		salir.setBounds(470, 460, 89, 23);
		contentPane.add(salir);
		
		JLabel lblNewLabel = new JLabel("Universidad Catolica");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lblNewLabel.setBounds(152, 90, 523, 102);
		contentPane.add(lblNewLabel);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
