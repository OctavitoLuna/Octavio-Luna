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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class R_estudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


    public static void leerObjetos(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                	Estudiantes estudiante = (Estudiantes) ois.readObject();
                	
                    System.out.println(estudiante);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	
	public R_estudiante() {
		String archivo = "registros.obj";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar estudiantes");
		lblNewLabel.setBounds(298, 37, 155, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
        try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
               while (true) {
                   try {
                   	Estudiantes estudiante = (Estudiantes) ois.readObject();
                   	comboBox.addItem(estudiante.getNombre());
                    //System.out.println(estudiante);
                   } catch (EOFException e) {
                       break;
                   }
               }
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
        
		comboBox.setBounds(162, 93, 359, 22);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(162, 163, 359, 259);
		contentPane.add(textArea);
		
		
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(432, 433, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				StringBuilder reporteEstudiante = new StringBuilder();
				Estudiantes estudiante = Encontrar(comboBox.getSelectedItem().toString(), archivo);
				reporteEstudiante.append("Nombre: ").append(estudiante.getNombre()).append("\n");
				reporteEstudiante.append("Carnet: ").append(estudiante.getCarnet()).append("\n");
				reporteEstudiante.append("Fecha de nacimiento: ").append(estudiante.getFecha_de_nacimiento()).append("\n");
				reporteEstudiante.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
				if(estudiante instanceof Regulares) {
					reporteEstudiante.append("Nacionalidad: ").append(((Regulares) estudiante).getNacionalidad()).append("\n");
					reporteEstudiante.append("Departamento: ").append(((Regulares) estudiante).getDepartamento()).append("\n");
					reporteEstudiante.append("Ubicacion: ").append(((Regulares) estudiante).getUbicacion()).append("\n");
				}
				else if(estudiante instanceof Extranjeros) {
					reporteEstudiante.append("Nacionalidad: ").append(((Extranjeros) estudiante).getNacionalidad()).append("\n");
					reporteEstudiante.append("Idioma: ").append(((Extranjeros) estudiante).getIdioma()).append("\n");
					reporteEstudiante.append("Pasaporte: ").append(((Extranjeros) estudiante).getPasaporte()).append("\n");
					reporteEstudiante.append("Ubicacion: ").append(((Extranjeros) estudiante).getUbicacion()).append("\n");
				}
				reporteEstudiante.append("\n");
				textArea.setText(reporteEstudiante.toString());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(595, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla_1 Pantalla_1 = new Pantalla_1();
				Pantalla_1.setVisible(true);
				dispose();
			}
		});
	}
	
	private Estudiantes Encontrar(String nombre, String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
               while (true) {
                   try {
                   		Estudiantes estudiante = (Estudiantes) ois.readObject();
                   		if(estudiante.getNombre().equals(nombre)) {
                   			return estudiante;
                   		}
                   } catch (EOFException e) {
                       break;
                   }
               }
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
		
		return null;
	}
}
