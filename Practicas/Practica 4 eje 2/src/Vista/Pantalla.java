package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import Modelo.Usuario;


public class Pantalla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtContraseaAntigua;
	private JTextField txtContraseaNueva;
	private JTextField txtRepitaContrasea;
	//Esto es una lista con los usuarios
	private ArrayList<Usuario> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
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
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Inicializamos las variables
		usuarios = new ArrayList<Usuario>();
		//Agregamos datos a nuesta lista
		usuarios.add(new Usuario("Octavio", "Q&qwerty1234"));
		usuarios.add(new Usuario("Marco", "Q&qwerty1234"));
		usuarios.add(new Usuario("Juan", "Q&qwerty1234"));
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		
		//Agregamos los datos de los usuarios a la lista que se muestra en la pantalla
		
		for(Usuario usuario : usuarios) {
			//Agregamos los nombres a la lista
			comboBox.addItem(usuario.getNombre());
		}
		comboBox.setBounds(176, 114, 285, 22);
		contentPane.add(comboBox);
		
		
		
		
		JLabel lblNewLabel = new JLabel("CAMBIOS CONTRASEÑA");
		lblNewLabel.setBounds(271, 44, 159, 14);
		contentPane.add(lblNewLabel);
		
		
		txtContraseaAntigua = new JTextField();
		txtContraseaAntigua.setText("Contraseña antigua");
		txtContraseaAntigua.setBounds(202, 172, 259, 20);
		contentPane.add(txtContraseaAntigua);
		txtContraseaAntigua.setColumns(10);
		
		
		txtContraseaNueva = new JTextField();
		txtContraseaNueva.setText("Contraseña nueva");
		txtContraseaNueva.setBounds(202, 211, 259, 20);
		contentPane.add(txtContraseaNueva);
		txtContraseaNueva.setColumns(10);
		
		
		txtRepitaContrasea = new JTextField();
		txtRepitaContrasea.setText("Repita contraseña");
		txtRepitaContrasea.setBounds(202, 242, 259, 20);
		contentPane.add(txtRepitaContrasea);
		txtRepitaContrasea.setColumns(10);
		
		
		//Este es el boton
		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setBounds(372, 293, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comboBox.getSelectedItem().toString() de vuelve el dato que esta seleccionado en la lista de selecciones
				CambiarContraseña(comboBox.getSelectedItem().toString());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(33, 373, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	private void CambiarContraseña(String nombre) {
		//Estamos trayendo el texto que pedidos antes, tenemos 3 cuadrados donde pedimos estos textos
		String contraseñaAntigua = txtContraseaAntigua.getText();
		String contraseñaNueva = txtContraseaNueva.getText();
		String repitaContraseña = txtRepitaContrasea.getText();
		
		//INTEREZANTE
		//Leer que hace encontrarUsuario, 
		//Esto nos ayuda a tener el objeto del usuario que esta en la lista de la pantalla
		Usuario usuario = EncontrarUsuario(nombre);
		
		
		//Esto da si el usuario no fue encontrado
		if (usuario == null) {
			JOptionPane.showMessageDialog(this, "Usuario no encontrado");
			return;
		}
		
		//Esto compara la contraseña del objeto usuario con la del recuadro contraseñaAntigua
		//el ! es para decir que si no son iguales
		if(!usuario.getContraseña().equals(contraseñaAntigua)) {
			JOptionPane.showMessageDialog(this, "La contraseña antigua es incorrecta");
			return;
		}
		
		//Esto compara la Contraseña nueva con la contraseña repetida que pedimos en lso recuadros
		if (!contraseñaNueva.equals(repitaContraseña)) {
			JOptionPane.showMessageDialog(this, "Las contraseñas nuevas no coinciden");
			return;
		}
		
		//Esto verigica si la contraseñanueva comple con las condiciones		
		if (contraseñaNueva.length() < 8 || !contraseñaNueva.matches(".*[!@#$%^&*].*") || !contraseñaNueva.matches(".*\\d.*")) {
			JOptionPane.showMessageDialog(this, "La nueva contraseña debe tener al menos 8 caracteres, un carácter especial y un número");
			return;
		}
		
		//Compara la contraseña nueva y la contraseña antigua para que no sean iguales
		if (contraseñaNueva.equals(contraseñaAntigua)) {
			JOptionPane.showMessageDialog(this, "La nueva contraseña no puede ser igual a la antigua");
			return;
		}
		
		//Despues de que pase las anteriores restricciones llega aca, actializa la contraseña nueva
		usuario.setContraseña(contraseñaNueva);
		JOptionPane.showMessageDialog(this, "Contraseña cambiada con éxito");
		
		
	}
	
	
	private Usuario EncontrarUsuario(String nombre) {
		//Esto sirve para encontrar la posicion del usuario, que cuando tenemos seleccionado un usuario, agarremos su posicion
		for(Usuario usuario: usuarios) {
			//equals es para comparar
			if(usuario.getNombre().equals(nombre)) {
				return usuario;
			}
		}
		return null;
	}
}
