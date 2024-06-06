package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class R_carrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public ArrayList<Estudiantes> estudiantes;

	
	
	
	
	
	
	public R_carrera() {
		String archivo = "registros.obj";
		estudiantes = new ArrayList<Estudiantes>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Carrera");
		lblNewLabel.setBounds(212, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 39, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar JScrollPane
        scrollPane.setBounds(54, 108, 390, 311); // Establecer el tamaño y la posición del JScrollPane
        contentPane.add(scrollPane); // Agregar JScrollPane al panel
		
		
		StringBuilder reporteCarrera = new StringBuilder();
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(355, 38, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				StringBuilder reporteCarrera = new StringBuilder();
				String b = textField.getText();
				Encontrar(b, archivo, estudiantes);
				for(Estudiantes estudiante : estudiantes) {

					reporteCarrera.append("Nombre: ").append(estudiante.getNombre()).append("\n");
					reporteCarrera.append("Carnet: ").append(estudiante.getCarnet()).append("\n");
					reporteCarrera.append("Fecha de nacimiento: ").append(estudiante.getFecha_de_nacimiento()).append("\n");
					reporteCarrera.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
					if(estudiante instanceof Regulares) {
						reporteCarrera.append("Nacionalidad: ").append(((Regulares) estudiante).getNacionalidad()).append("\n");
						reporteCarrera.append("Departamento: ").append(((Regulares) estudiante).getDepartamento()).append("\n");
						reporteCarrera.append("Ubicacion: ").append(((Regulares) estudiante).getUbicacion()).append("\n");
					}
					else if(estudiante instanceof Extranjeros) {
						reporteCarrera.append("Nacionalidad: ").append(((Extranjeros) estudiante).getNacionalidad()).append("\n");
						reporteCarrera.append("Idioma: ").append(((Extranjeros) estudiante).getIdioma()).append("\n");
						reporteCarrera.append("Pasaporte: ").append(((Extranjeros) estudiante).getPasaporte()).append("\n");
						reporteCarrera.append("Ubicacion: ").append(((Extranjeros) estudiante).getUbicacion()).append("\n");
					}
					reporteCarrera.append("\n");
					textArea.setText(reporteCarrera.toString());
				}
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(0, 7, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla_1 Pantalla_1 = new Pantalla_1();
				Pantalla_1.setVisible(true);
				dispose();
			}
		});
		

	}
	
	private void Encontrar(String carrera, String archivo, ArrayList<Estudiantes> estudiantes) {
		estudiantes.clear();
        try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
               while (true) {
                   try {
                   		Estudiantes estudiante = (Estudiantes) ois.readObject();
                   		if(estudiante.getCarrera().equals(carrera)) {
                   			estudiantes.add(estudiante);
                   		}
                   } catch (EOFException e) {
                       break;
                   }
               }
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
		
	}
}
