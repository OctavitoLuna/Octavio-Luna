package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controlador.Carnes;
import Controlador.Frutas;
import Controlador.Lacteos;
import Controlador.Productos;
import Vista.Editar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;


public class Reporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ArrayList<Productos> productos;

	/**
	 * Create the frame.
	 */
	public Reporte(ArrayList<Productos> productos) {
		this.productos = productos;
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE");
		lblNewLabel.setBounds(287, 41, 85, 25);
		contentPane.add(lblNewLabel);
		
		
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(67, 90, 537, 397);
        contentPane.add(scrollPane);
        
        
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	
		//String mas complejo
        StringBuilder reporteTexto = new StringBuilder();
        for (Productos producto : productos) {
            reporteTexto.append("Código: ").append(producto.getCodigo()).append("\n");
            reporteTexto.append("Nombre: ").append(producto.getNombre()).append("\n");
            reporteTexto.append("Precio Unitario: ").append(producto.getPrecio_unitario()).append("\n");
            reporteTexto.append("Stock: ").append(producto.getStock()).append("\n");
            if (producto instanceof Frutas) {
            	reporteTexto.append("Descuento: ").append(((Frutas) producto).getDescuento()).append("\n");
            }
            else if (producto instanceof Carnes) {
            	reporteTexto.append("Descuento: ").append(((Carnes) producto).getDescuento()).append("\n");
            }
            reporteTexto.append("\n");
        }
        textArea.setText(reporteTexto.toString());
		
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(550, 11, 89, 23);
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
