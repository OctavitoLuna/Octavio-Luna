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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class P_extranjero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCarnet;
	private JTextField txtFecha;
	private JTextField txtCarrera;
	private JTextField txtNacionalidad;
	private JTextField txtIdioma;
	private JTextField txtPasaporte;
	private JTextField txtUbicacion;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

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
    
    
    private boolean comprobarFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = dateFormat.parse(fecha);
            Date fechaActual = new Date();
            long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
            long edad = diferencia / (1000L * 60 * 60 * 24 * 365);
            return edad >= 21;
        } catch (ParseException e) {
            return false; 
        }
    }

	
	/**
	 * Create the frame.
	 */
	public P_extranjero() {
		String archivo = "registros.obj";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añador estudiantes extranjeros");
		lblNewLabel.setBounds(134, 10, 170, 13);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(119, 33, 185, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCarnet = new JTextField();
		txtCarnet.setText("carnet");
		txtCarnet.setBounds(119, 62, 185, 19);
		contentPane.add(txtCarnet);
		txtCarnet.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setText("fecha");
		txtFecha.setBounds(119, 91, 185, 19);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCarrera = new JTextField();
		txtCarrera.setText("carrera");
		txtCarrera.setBounds(119, 120, 185, 19);
		contentPane.add(txtCarrera);
		txtCarrera.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setText("nacionalidad");
		txtNacionalidad.setBounds(119, 149, 185, 19);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		txtIdioma = new JTextField();
		txtIdioma.setText("idioma");
		txtIdioma.setBounds(119, 178, 185, 19);
		contentPane.add(txtIdioma);
		txtIdioma.setColumns(10);
		
		txtPasaporte = new JTextField();
		txtPasaporte.setText("pasaporte");
		txtPasaporte.setBounds(119, 206, 185, 19);
		contentPane.add(txtPasaporte);
		txtPasaporte.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setText("ubicacion");
		txtUbicacion.setBounds(119, 235, 185, 19);
		contentPane.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		btnNewButton = new JButton("Agresar");
		btnNewButton.setBounds(219, 264, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = txtNombre.getText();
				String b = txtCarnet.getText();
				String c = txtFecha.getText();
				String d = txtCarrera.getText();
				String ea = txtNacionalidad.getText();
				String f = txtIdioma.getText();
				String g = txtPasaporte.getText();
				String h = txtPasaporte.getText();
				
				
				if(comprobarFecha(c) == false) {
					JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida o el estudiante no tiene 21 años.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Estudiantes estudiante = new Extranjeros(a, b, c, d, ea, f, g, h);
				escribirObjeto(estudiante, archivo);
				leerObjetos(archivo);
			}
		});
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(341, 6, 85, 21);
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
