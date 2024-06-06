package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controlador.Carnes;
import Controlador.Frutas;
import Controlador.Lacteos;
import Controlador.Productos;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import Vista.Editar;
import javax.swing.JComboBox;


public class Eliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	public ArrayList<Productos> productos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Eliminar(ArrayList<Productos> productos) {
		this.productos = productos;
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar");
		lblNewLabel.setBounds(290, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		comboBox = new JComboBox<String>();
		
		for (Productos producto : productos) {
			comboBox.addItem(producto.getNombre());
		}
		comboBox.setBounds(146, 160, 335, 22);
		contentPane.add(comboBox);
		
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(493, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar Editar = new Editar(productos);
				Editar.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(271, 290, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productos.remove(Encontrar(comboBox.getSelectedItem().toString()));
			}
		});
	}
	
	private Productos Encontrar(String nombre) {
		for (Productos producto : productos) {
			if(producto.getNombre().equals(nombre)) {
				return producto;
			};
		}
		
		return null;
	}

}
