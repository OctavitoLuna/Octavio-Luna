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
import Controlador.Intercambio;
import Controlador.Regulares;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class P_intercambio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomrbre;
	private JTextField txtCarnet;
	private JTextField txtFecha;
	private JTextField txtCarrera;
	private JTextField txtAnteriorUniversidad;
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
    
    
    private boolean comprobarFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = dateFormat.parse(fecha);
            Date fechaActual = new Date();
            long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
            long edad = diferencia / (1000L * 60 * 60 * 24 * 365);
            return edad >= 21 && edad <= 25;
        } catch (ParseException e) {
            return false; 
        }
    }
	public P_intercambio() {
		String archivo = "registros.obj";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Intercambio");
		lblNewLabel.setBounds(196, 11, 73, 14);
		contentPane.add(lblNewLabel);
		
		txtNomrbre = new JTextField();
		txtNomrbre.setText("nomrbre");
		txtNomrbre.setBounds(43, 43, 226, 20);
		contentPane.add(txtNomrbre);
		txtNomrbre.setColumns(10);
		
		txtCarnet = new JTextField();
		txtCarnet.setText("carnet");
		txtCarnet.setBounds(42, 74, 227, 20);
		contentPane.add(txtCarnet);
		txtCarnet.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setText("fecha");
		txtFecha.setBounds(43, 105, 226, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCarrera = new JTextField();
		txtCarrera.setText("carrera");
		txtCarrera.setBounds(43, 134, 226, 20);
		contentPane.add(txtCarrera);
		txtCarrera.setColumns(10);
		
		txtAnteriorUniversidad = new JTextField();
		txtAnteriorUniversidad.setText("Anterior universidad");
		txtAnteriorUniversidad.setBounds(43, 165, 227, 20);
		contentPane.add(txtAnteriorUniversidad);
		txtAnteriorUniversidad.setColumns(10);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(300, 164, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = txtNomrbre.getText();
				String b = txtCarnet.getText();
				String c = txtFecha.getText();
				String d = txtCarrera.getText();
				String ea = txtAnteriorUniversidad.getText();
				
				
				
				if(comprobarFecha(c) == false) {
					JOptionPane.showMessageDialog(null, "Fecha equivocada.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Estudiantes estudiante = new Intercambio(a, b, c, d, ea);
				escribirObjeto(estudiante, archivo);
			}
		});
		
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(300, 11, 89, 23);
		contentPane.add(btnNewButton_1);
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
