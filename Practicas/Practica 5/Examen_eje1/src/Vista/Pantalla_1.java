package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Vista.Comprar;
import Vista.Editar;
import Controlador.Carnes;
import Controlador.Frutas;
import Controlador.Lacteos;
import Controlador.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class Pantalla_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ArrayList<Productos> productos;



	/**
	 * Create the frame.
	 * @param productos2 
	 */
	public Pantalla_1(ArrayList<Productos> productos) {
		this.productos = productos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("EJE 1");
		lblNewLabel.setBounds(296, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar Editar = new Editar(productos);
				Editar.setVisible(true);
				dispose();
			}
		});
		
		
		btnNewButton.setBounds(91, 134, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setBounds(426, 134, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprar Comprar = new Comprar(productos);
				Comprar.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(266, 258, 89, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
