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

public class Adicionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoDelProducto;
	private JTextField txtNombre;
	private JTextField txtPrecioUnitario;
	private JTextField txtSotck;
	private JTextField txtDescuentonoLacteos;
	public ArrayList<Productos> productos;


	/**
	 * Create the frame.
	 */
	public Adicionar(ArrayList<Productos> productos) {
		this.productos = productos;
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		String[] tipos = {"Lacteos", "Carnes", "Frutas"};
		JComboBox comboBox = new JComboBox(tipos);
		comboBox.setBounds(103, 144, 335, 22);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.setBounds(244, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoDelProducto = new JTextField();
		txtCodigoDelProducto.setText("Codigo del producto");
		txtCodigoDelProducto.setBounds(103, 79, 335, 20);
		contentPane.add(txtCodigoDelProducto);
		txtCodigoDelProducto.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setBounds(103, 113, 335, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setText("Precio unitario");
		txtPrecioUnitario.setBounds(103, 173, 335, 20);
		contentPane.add(txtPrecioUnitario);
		txtPrecioUnitario.setColumns(10);
		
		txtSotck = new JTextField();
		txtSotck.setText("Stock");
		txtSotck.setBounds(103, 204, 335, 20);
		contentPane.add(txtSotck);
		txtSotck.setColumns(10);
		
		txtDescuentonoLacteos = new JTextField();
		txtDescuentonoLacteos.setText("Descuento(no lacteos)");
		txtDescuentonoLacteos.setBounds(103, 240, 335, 20);
		contentPane.add(txtDescuentonoLacteos);
		txtDescuentonoLacteos.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(234, 271, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = (int) Double.parseDouble(txtCodigoDelProducto.getText());
				String b = txtNombre.getText();
				double c = Double.parseDouble(txtPrecioUnitario.getText());
				int d = (int) Double.parseDouble(txtSotck.getText());
				double ea = Double.parseDouble(txtDescuentonoLacteos.getText());
				
				String tipo = (String) comboBox.getSelectedItem();
				if(tipo == "Lacteos") {
					productos.add(new Lacteos(a, b, c, d));
				}
				if(tipo == "Carnes") {
					productos.add(new Carnes(a, b, c, d, ea));
				}
				if(tipo == "Frutas") {
					productos.add(new Frutas(a, b, c, d, ea));
				}
				
		
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(465, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar Editar = new Editar(productos);
				Editar.setVisible(true);
				dispose();
			}
		});
	}
}
