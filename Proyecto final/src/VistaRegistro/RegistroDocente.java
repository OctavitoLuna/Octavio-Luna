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

public class RegistroDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellidoP;
	private JTextField apellidoM;
	private JTextField contrasena;
	private JTextField direccion;
	private JTextField nacion;
	private JTextField carnet;
	private JTextField sexo;
	private JTextField estadoCivil;
	private JTextField correoElectronico;
	private JTextField fechaNacimiento;
	private JTextField nRegistro;
	private JTextField telefonoMovil;
	private JTextField tituloAcademico;
	private JTextField fechaContrato;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxFacultad;
	private JLabel lblNewLabel_2;
	public int verificador = 0;
	public int contador = 0;


	public RegistroDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Docente");
		lblNewLabel.setBounds(187, 10, 63, 13);
		contentPane.add(lblNewLabel);
		
			nombre = new JTextField();
			nombre.setText("nombre");
			nombre.setBounds(161, 36, 96, 19);
			contentPane.add(nombre);
			nombre.setColumns(10);
			
			apellidoP = new JTextField();
			apellidoP.setText("apellidoP");
			apellidoP.setColumns(10);
			apellidoP.setBounds(161, 62, 96, 19);
			contentPane.add(apellidoP);
			
			apellidoM = new JTextField();
			apellidoM.setText("apellidoM");
			apellidoM.setColumns(10);
			apellidoM.setBounds(161, 92, 96, 19);
			contentPane.add(apellidoM);
			
			contrasena = new JTextField();
			contrasena.setText("contrasena");
			contrasena.setColumns(10);
			contrasena.setBounds(161, 124, 96, 19);
			contentPane.add(contrasena);
			
			direccion = new JTextField();
			direccion.setText("direccion");
			direccion.setColumns(10);
			direccion.setBounds(161, 152, 96, 19);
			contentPane.add(direccion);
			
			nacion = new JTextField();
			nacion.setText("nacion");
			nacion.setColumns(10);
			nacion.setBounds(161, 182, 96, 19);
			contentPane.add(nacion);
			
			carnet = new JTextField();
			carnet.setText("carnet");
			carnet.setColumns(10);
			carnet.setBounds(161, 211, 96, 19);
			contentPane.add(carnet);
			
			sexo = new JTextField();
			sexo.setText("sexo");
			sexo.setColumns(10);
			sexo.setBounds(161, 240, 96, 19);
			contentPane.add(sexo);
			
			estadoCivil = new JTextField();
			estadoCivil.setText("estadoCivil");
			estadoCivil.setColumns(10);
			estadoCivil.setBounds(161, 269, 96, 19);
			contentPane.add(estadoCivil);
			
			correoElectronico = new JTextField();
			correoElectronico.setText("correoElectronico");
			correoElectronico.setColumns(10);
			correoElectronico.setBounds(161, 298, 96, 19);
			contentPane.add(correoElectronico);
			
			fechaNacimiento = new JTextField();
			fechaNacimiento.setText("fechaNacimiento");
			fechaNacimiento.setColumns(10);
			fechaNacimiento.setBounds(161, 326, 96, 19);
			contentPane.add(fechaNacimiento);
			
			nRegistro = new JTextField();
			nRegistro.setText("nRegistro");
			nRegistro.setColumns(10);
			nRegistro.setBounds(161, 354, 96, 19);
			contentPane.add(nRegistro);
			
			telefonoMovil = new JTextField();
			telefonoMovil.setText("telefonoMovil");
			telefonoMovil.setColumns(10);
			telefonoMovil.setBounds(161, 383, 96, 19);
			contentPane.add(telefonoMovil);
			
			tituloAcademico = new JTextField();
			tituloAcademico.setText("tituloAcademico");
			tituloAcademico.setColumns(10);
			tituloAcademico.setBounds(161, 412, 96, 19);
			contentPane.add(tituloAcademico);
			
			fechaContrato = new JTextField();
			fechaContrato.setText("fechaContrato");
			fechaContrato.setColumns(10);
			fechaContrato.setBounds(161, 441, 96, 19);
			contentPane.add(fechaContrato);
		
		
		
		
		JButton registro = new JButton("registro");
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				registrar();
				if(verificador == 0) {
					int generar = comboBox.getSelectedIndex();
					contador = generar;
							matDisponibles matDisponibles = new matDisponibles(contador);
							matDisponibles.setVisible(true);
							dispose();
						
				}
				
			}
		});
		registro.setBounds(59, 529, 85, 21);
		contentPane.add(registro);
		
		JButton volver = new JButton("volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro Registro = new Registro();
				Registro.setVisible(true);
				dispose();
			}
		});
		volver.setBounds(255, 529, 85, 21);
		contentPane.add(volver);
		
		String[] lista = {"1 materia", "medio tiempo", "tiempo completo"};
		comboBox = new JComboBox(lista);
		comboBox.setBounds(298, 61, 113, 21);
		contentPane.add(comboBox);
		
		lblNewLabel_1 = new JLabel("tipo de contrato: ");
		lblNewLabel_1.setBounds(298, 39, 116, 13);
		contentPane.add(lblNewLabel_1);
		
		String[] listaFacultad = {"ingenieria", "Ciencias economicas y financieras", "Ciencias Sociales","Derecho y Politicas", "Arquitectura","Diseño grafico","salud"};
		comboBoxFacultad = new JComboBox(listaFacultad);
		comboBoxFacultad.setBounds(298, 123, 113, 20);
		contentPane.add(comboBoxFacultad);
		
		lblNewLabel_2 = new JLabel("escoga su facultad: ");
		lblNewLabel_2.setBounds(295, 98, 116, 13);
		contentPane.add(lblNewLabel_2);
	}
	public void registrar() {
		
		try {
			String noombreA = nombre.getText();
			String apellidop = apellidoP.getText();
			String apellidom = apellidoM.getText();
			String contraseñaA = contrasena.getText();
			String direccionA = direccion.getText();
			String nacionA = nacion.getText();
			String carnetA = carnet.getText();
			String sexoA = sexo.getText();
			String estadoCivilA = estadoCivil.getText();
			String correoElectronicoA = correoElectronico.getText();
			String fechaNacimientoA = fechaNacimiento.getText();
			int nRegistroA =Integer.parseInt(nRegistro.getText());
			int telefonoMovila =Integer.parseInt(telefonoMovil.getText());
			String tituloAcademicoA = tituloAcademico.getText();
			int facultadA = comboBoxFacultad.getSelectedIndex();
			String fechaContratoA = fechaContrato.getText();
			String tipoContratoA = (String)comboBox.getSelectedItem();
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
