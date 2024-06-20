package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.DatabaseConnection;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MisDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int verificadorPersona;
	private int personaId;
	
	public MisDatos(int verificadorPersona, int personaId) {
		this.personaId = personaId;
		this.verificadorPersona = verificadorPersona;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(64, 11, 283, 202);
		contentPane.add(textPane);
		
		if(verificadorPersona == 1) {
			//devolver docente
			System.out.println("Docente");
		}
		else {
			//devolver estudiante
			System.out.println("Estudiante");	
		}
		
		cargarDatos(textPane);
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 227, 89, 23);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(verificadorPersona == 1) {
					Docente Docente = new Docente(personaId);
					Docente.setVisible(true);
					dispose();
				}
				else {
					Estudiante Estudiante = new Estudiante(personaId);
					Estudiante.setVisible(true);
					dispose();
				}

			}
		});
		
	}
	
    // cargar datos de la base de datos al textpane
    private void cargarDatos(JTextPane textPane) {
        String sql = "SELECT * FROM persona WHERE id_persona = ?";
        
        //conectar
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, personaId);
            ResultSet ejecutar = stmt.executeQuery();

            if (ejecutar.next()) {
                // para tener los datos
            	String datos = "Nombre: " + ejecutar.getString("nombre") + "\nApellido Paterno: " + ejecutar.getString("apellidoP") + "\nApellido Materno: " + ejecutar.getString("apellidoM") + "\nDirección: " + ejecutar.getString("direccion") + "\nCorreo electrónico: " + ejecutar.getString("correoElectronico") + "\nContraseña: " + "\nNación: " + ejecutar.getString("nacion") + "\nFecha de Nacimiento: " + ejecutar.getDate("fechaNacimiento") + "\nCarnet: " + ejecutar.getString("carnet") + "\nSexo: " + ejecutar.getString("sexo") + "\nEstado civil: " + ejecutar.getString("estadoCivil") + "\nTeléfono móvil: " + ejecutar.getInt("telefonoMovil");


                textPane.setText(datos);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron datos para esta persona", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    //para inicar el archivo sin necesitad del archivo anteior
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MisDatos frame = new MisDatos(1, 1); 
            frame.setVisible(true);
        });
    }
}
