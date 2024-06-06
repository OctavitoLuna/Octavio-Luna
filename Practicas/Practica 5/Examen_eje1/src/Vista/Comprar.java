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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Comprar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	public ArrayList<Productos> productos;
	private JTextField txtCantidad;
	private JTextArea txtrRes;
	private double caja;  // Variable de instancia para la caja

	public Comprar(ArrayList<Productos> productos) {
		this.productos = productos;
		this.caja = 0;  // Inicializar la caja
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<String>();
		for (Productos producto : productos) {
			comboBox.addItem(producto.getNombre());
		}
		comboBox.setBounds(195, 90, 335, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Comprar");
		lblNewLabel.setBounds(342, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("Cantidad");
		txtCantidad.setBounds(325, 155, 135, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtrRes = new JTextArea();
		txtrRes.setText("Res: " + caja);
		txtrRes.setBounds(265, 253, 206, 22);
		contentPane.add(txtrRes);

		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(571, 24, 89, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla_1 Pantalla_1 = new Pantalla_1(productos);
				Pantalla_1.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(441, 186, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(txtCantidad.getText());
				Agregar(comboBox.getSelectedItem().toString(), cantidad);
				txtrRes.setText("Res: " + caja);
			}
		});
	}
	
	private void Agregar(String nombre, int cantidad) {
		Productos producto = Encontrar(nombre);
		if (producto != null) {
			Double precioUnitario = producto.getPrecio_unitario();
			int stockDisponible = producto.getStock();
			double subtotal = 0;
			
			if (stockDisponible >= cantidad) {
				subtotal = precioUnitario * cantidad;

				if (producto instanceof Frutas) {
					Double descuento = ((Frutas) producto).getDescuento();
					subtotal = subtotal - (subtotal * descuento / 100); 
				} else if (producto instanceof Carnes) {
					Double descuento = ((Carnes) producto).getDescuento();
					if((subtotal * descuento / 100) > 100) {
						subtotal = subtotal - 100; //
					} else {
						subtotal = subtotal - (subtotal * descuento / 100); // Aplicar descuento
					}
				} else if (producto instanceof Lacteos) {
					if(cantidad >= 10) {
						int a = cantidad / 10;
						subtotal = subtotal - (a*5);
					}
				}
				
				caja += subtotal;
				producto.setStock(stockDisponible - cantidad);
			} else {
				JOptionPane.showMessageDialog(this, "No se puede realizar la compra por falta de stock. Prueba con otra cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private Productos Encontrar(String nombre) {
		for (Productos producto : productos) {
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}
}
