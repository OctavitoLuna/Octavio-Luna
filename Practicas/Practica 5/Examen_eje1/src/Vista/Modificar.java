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
import javax.swing.JScrollPane;



public class Modificar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtCodigoDelProducto;
	private JTextField txtNombre;
	private JTextField txtPrecioUnitario;
	private JTextField txtSotck;
	private JTextField txtDescuentonoLacteos;
	private JComboBox<String> comboBox;
	private JButton btnNewButton;
	private ArrayList<Productos> productos;
	/**
	 * Launch the application.
	 */
	public Modificar(ArrayList<Productos> productos) {
		this.productos = productos;
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificar");
		lblNewLabel.setBounds(227, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		comboBox = new JComboBox<String>();
		
		for (Productos producto : productos) {
			comboBox.addItem(producto.getNombre());
		}
		comboBox.setBounds(103, 63, 335, 22);
		contentPane.add(comboBox);
		
		
		txtCodigoDelProducto = new JTextField();
		txtCodigoDelProducto.setBounds(103, 111, 335, 20);
		txtCodigoDelProducto.setText("Codigo del producto");
		contentPane.add(txtCodigoDelProducto);
		txtCodigoDelProducto.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 142, 335, 20);
		txtNombre.setText("Nombre");
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(103, 173, 335, 20);
		txtPrecioUnitario.setText("Precio unitario");
		contentPane.add(txtPrecioUnitario);
		txtPrecioUnitario.setColumns(10);
		
		txtSotck = new JTextField();
		txtSotck.setBounds(103, 204, 335, 20);
		txtSotck.setText("Stock");
		contentPane.add(txtSotck);
		txtSotck.setColumns(10);
		
		txtDescuentonoLacteos = new JTextField();
		txtDescuentonoLacteos.setBounds(103, 240, 335, 20);
		txtDescuentonoLacteos.setText("Descuento(no lacteos)");
		contentPane.add(txtDescuentonoLacteos);
		txtDescuentonoLacteos.setColumns(10);
		

		
		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambiar(comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(227, 288, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(450, 7, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar Editar = new Editar(productos);
				Editar.setVisible(true);
				dispose();
			}
		});
		
		

	}
	
	private void Cambiar(String nombre) {
		int a = (int) Double.parseDouble(txtCodigoDelProducto.getText());
		String b = txtNombre.getText();
		double c = Double.parseDouble(txtPrecioUnitario.getText());
		int d = (int) Double.parseDouble(txtSotck.getText());
		double ea = Double.parseDouble(txtDescuentonoLacteos.getText());
		
		Productos producto = Encontrar(nombre);
		
		//UTIL
	    if (producto instanceof Frutas) {
	        ((Frutas) producto).setCodigo(a);
	        ((Frutas) producto).setNombre(b);
	        ((Frutas) producto).setPrecio_unitario(c);
	        ((Frutas) producto).setStock(d);
	        ((Frutas) producto).setDescuento(ea);
	    } else if (producto instanceof Carnes) {
	        ((Carnes) producto).setCodigo(a);
	        ((Carnes) producto).setNombre(b);
	        ((Carnes) producto).setPrecio_unitario(c);
	        ((Carnes) producto).setStock(d);
	        ((Carnes) producto).setDescuento(ea);
	    } else if (producto instanceof Lacteos) {
	        ((Lacteos) producto).setCodigo(a);
	        ((Lacteos) producto).setNombre(b);
	        ((Lacteos) producto).setPrecio_unitario(c);
	        ((Lacteos) producto).setStock(d);
	    }
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
