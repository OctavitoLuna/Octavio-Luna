package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import Vista.P_extranjero;
import Vista.P_regular;
import Vista.R_carrera;
import Vista.R_estudiante;

import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class P_regular extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCarnet;
	private JTextField txtFecha;
	private JTextField txtCarrera;
	private JTextField txtNacionalidad;
	private JTextField txtUbicacion;
	private JTextField txtDepartamento;

    public static void escribirObjeto(Estudiantes estudiante, String archivo) {
        try (FileOutputStream fos = new FileOutputStream(archivo, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos) {
                 @Override
                 protected void writeStreamHeader() throws IOException {
                     reset();
                 }
             }) {
            oos.writeObject(estudiante);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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

	/**
	 * Create the frame.
	 */
	public P_regular() {
		String archivo = "registros.obj";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscripcion estudiante regular");
		lblNewLabel.setBounds(227, 35, 182, 13);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(152, 102, 298, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCarnet = new JTextField();
		txtCarnet.setText("carnet");
		txtCarnet.setBounds(152, 140, 298, 19);
		contentPane.add(txtCarnet);
		txtCarnet.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setText("fecha");
		txtFecha.setBounds(152, 178, 298, 19);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCarrera = new JTextField();
		txtCarrera.setText("carrera");
		txtCarrera.setBounds(152, 217, 298, 19);
		contentPane.add(txtCarrera);
		txtCarrera.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setText("nacionalidad");
		txtNacionalidad.setBounds(152, 246, 298, 19);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setText("departamento");
		txtDepartamento.setBounds(152, 304, 298, 19);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setText("ubicacion");
		txtUbicacion.setBounds(152, 275, 298, 19);
		contentPane.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(276, 348, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = txtNombre.getText();
				String b = txtCarnet.getText();
				String c = txtFecha.getText();
				String d = txtCarrera.getText();
				String ea = txtNacionalidad.getText();
				String f = txtDepartamento.getText();
				String g = txtUbicacion.getText();
				
				Estudiantes estudiante = new Regulares(a, b, c, d, ea, f, g);
				
				escribirObjeto(estudiante, archivo);
				leerObjetos(archivo);
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(511, 31, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla_1 Pantalla_1 = new Pantalla_1();
				Pantalla_1.setVisible(true);
				dispose();
			}
		});
	}

}
