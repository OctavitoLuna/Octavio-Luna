package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Carnes;
import Controlador.Frutas;
import Controlador.Lacteos;
import Controlador.Productos;

import javax.swing.JLabel;
import javax.swing.JButton;
import Vista.Adicionar;
import Vista.Modificar;
import Vista.Eliminar;
import Vista.Reporte;
import Vista.Pantalla_1;
public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ArrayList<Productos> productos;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param productos 
	 */
	public Editar(ArrayList<Productos> productos) {
		this.productos = productos;
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Editar");
		lblNewLabel.setBounds(204, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Adicionen");
		btnNewButton.setBounds(37, 133, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar Adicionar = new Adicionar(productos);
				Adicionar.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modifiquen");
		btnNewButton_1.setBounds(193, 133, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar Modificar = new Modificar(productos);
				Modificar.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("Eliminen");
		btnNewButton_2.setBounds(358, 133, 89, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar Eliminar = new Eliminar(productos);
				Eliminar.setVisible(true);
				dispose();
			}
		});
		JButton btnNewButton_3 = new JButton("Reporte");
		btnNewButton_3.setBounds(193, 224, 89, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporte Reporte = new Reporte(productos);
				Reporte.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(372, 19, 89, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla_1 Pantalla_1 = new Pantalla_1(	productos);
				Pantalla_1.setVisible(true);
				dispose();
			}
		});
	}


}
