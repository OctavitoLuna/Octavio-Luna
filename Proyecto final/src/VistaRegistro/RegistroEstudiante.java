package VistaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegistroEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellidoP;
	private JTextField apellidoM;
	private JTextField direccion;
	private JTextField nacion;
	private JTextField carnet;
	private JTextField estadoCivil;
	private JTextField correoElectronico;
	private JTextField fechaNacimiento;
	private JTextField nRegistro;
	private JTextField telefonoMovil;
	private JTextField fechaIngreso;
	private JTextField semestre;
	public JComboBox comboBox ;
	public int verificador = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEstudiante frame = new RegistroEstudiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estudiante");
		lblNewLabel.setBounds(180, 0, 74, 23);
		contentPane.add(lblNewLabel);
		
			nombre = new JTextField();
			nombre.setText("nombre");
			nombre.setBounds(158, 33, 96, 19);
			contentPane.add(nombre);
			nombre.setColumns(10);
			
			apellidoP = new JTextField();
			apellidoP.setText("apellidoP");
			apellidoP.setColumns(10);
			apellidoP.setBounds(158, 61, 96, 19);
			contentPane.add(apellidoP);
			
			apellidoM = new JTextField();
			apellidoM.setText("apellidoM");
			apellidoM.setColumns(10);
			apellidoM.setBounds(158, 90, 96, 19);
			contentPane.add(apellidoM);
			
			direccion = new JTextField();
			direccion.setText("direccion");
			direccion.setColumns(10);
			direccion.setBounds(158, 119, 96, 19);
			contentPane.add(direccion);
			
			nacion = new JTextField();
			nacion.setText("nacion");
			nacion.setColumns(10);
			nacion.setBounds(158, 150, 96, 19);
			contentPane.add(nacion);
			
			carnet = new JTextField();
			carnet.setText("carnet");
			carnet.setColumns(10);
			carnet.setBounds(158, 179, 96, 19);
			contentPane.add(carnet);
			
			estadoCivil = new JTextField();
			estadoCivil.setText("estadoCivil");
			estadoCivil.setColumns(10);
			estadoCivil.setBounds(158, 205, 96, 19);
			contentPane.add(estadoCivil);
			
			correoElectronico = new JTextField();
			correoElectronico.setText("correoElectronico");
			correoElectronico.setColumns(10);
			correoElectronico.setBounds(158, 234, 96, 19);
			contentPane.add(correoElectronico);
			
			fechaNacimiento = new JTextField();
			fechaNacimiento.setText("fechaNacimiento");
			fechaNacimiento.setColumns(10);
			fechaNacimiento.setBounds(158, 264, 96, 19);
			contentPane.add(fechaNacimiento);
			
			nRegistro = new JTextField();
			nRegistro.setText("nRegistro");
			nRegistro.setColumns(10);
			nRegistro.setBounds(158, 293, 96, 19);
			contentPane.add(nRegistro);
			
			telefonoMovil = new JTextField();
			telefonoMovil.setText("telefonoMovil");
			telefonoMovil.setColumns(10);
			telefonoMovil.setBounds(158, 320, 96, 19);
			contentPane.add(telefonoMovil);
			
			fechaIngreso = new JTextField();
			fechaIngreso.setText("fechaIngreso");
			fechaIngreso.setColumns(10);
			fechaIngreso.setBounds(158, 349, 96, 19);
			contentPane.add(fechaIngreso);
			
			semestre = new JTextField();
			semestre.setText("semestre");
			semestre.setColumns(10);
			semestre.setBounds(158, 378, 96, 19);
			contentPane.add(semestre);
		
		
		
		JButton Registro = new JButton("Resgistro");
		Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
				if(verificador == 0) {
					FinRegistro FinRegistro = new FinRegistro();
					FinRegistro.setVisible(true);
					dispose();
				}

			}
		});
		Registro.setBounds(68, 441, 85, 21);
		contentPane.add(Registro);
		
		JButton volver = new JButton("volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro Registro = new Registro();
				Registro.setVisible(true);
				dispose();
			}
		});
		volver.setBounds(259, 441, 85, 21);
		contentPane.add(volver);
		String[] lista = {"Administración de Empresas (ADM)","Administración Turística (ADT)","Contaduría Pública (CPA)"};
		comboBox = new JComboBox(lista);
		comboBox.setBounds(295, 60, 108, 21);
		contentPane.add(comboBox);
	}
	public void comprobar() {
		try {
			String noombreA = nombre.getText();
			String apellidop = apellidoP.getText();
			String apellidom = apellidoM.getText();
			String direccionA = direccion.getText();
			String nacionA = nacion.getText();
			String carnetA = carnet.getText();
			String estadoCivilA = estadoCivil.getText();
			String correoElectronicoA = correoElectronico.getText();
			String fechaNacimientoA = fechaNacimiento.getText();
			String nRegistroA = nRegistro.getText();
			int telefonoMovila =Integer.parseInt(telefonoMovil.getText() );
			String carreraA = (String)comboBox.getSelectedItem();
			String fechaIngresoA = fechaIngreso.getText();
			String semestreA = semestre.getText();
			verificador =0;
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error de formato numérico. Por favor, verifica los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
			verificador =1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ocurrió un error. Por favor, verifica los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
			verificador =1;
		}
		
		
		
	}
}
