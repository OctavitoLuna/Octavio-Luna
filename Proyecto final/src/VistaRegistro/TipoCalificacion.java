package VistaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipoCalificacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel fieldsPanel;
	public int contador;
	public int a;
	
	public TipoCalificacion(int contador) {
		this.contador = contador;
		a= contador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Como calificas??");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 22, 110, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblCuantosModosDe = new JLabel("Cuantos modos de calificar tienes:");
		lblCuantosModosDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuantosModosDe.setBounds(46, 56, 229, 24);
		contentPane.add(lblCuantosModosDe);
		
		textField = new JTextField();
		textField.setBounds(285, 56, 47, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton generar = new JButton("generar");
		generar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateTextFields();
			}
		});
		generar.setBounds(341, 60, 85, 21);
		contentPane.add(generar);
		fieldsPanel = new JPanel();
        fieldsPanel.setBounds(20, 100, 406, 217);
        fieldsPanel.setLayout(null); // Usar layout absoluto
        contentPane.add(fieldsPanel);
        
        JButton cerrar = new JButton("cerrar");
        cerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(a != 0) {
					a = a - 1;
					matDisponibles matDisponibles = new matDisponibles(a);
					matDisponibles.setVisible(true);
					dispose();
        		}else {
        			FinRegistro FinRegistro = new FinRegistro();
        			FinRegistro.setVisible(true);
    				dispose();
        		}
				
        	}
        });
        cerrar.setBounds(341, 29, 85, 21);
        contentPane.add(cerrar);
        
       
	}
	private void generateTextFields() {
        // Limpiar los JTextField existentes
        fieldsPanel.removeAll();
        
        int numFields;
        try {
            numFields = Integer.parseInt(textField.getText());
            if (numFields > 10) {
                JOptionPane.showMessageDialog(this, "El número máximo de campos es 10.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Etiquetas para los campos
        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombre.setBounds(10, 10, 100, 24);
        fieldsPanel.add(lblNombre);

        JLabel lblPonderacion = new JLabel("PONDERACION");
        lblPonderacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPonderacion.setBounds(180, 10, 100, 24);
        fieldsPanel.add(lblPonderacion);
        
        // Generar los nuevos JTextField
        for (int i = 0; i < numFields; i++) {
            JTextField nameField = new JTextField();
            JTextField weightField = new JTextField();
            
            int y = (i % 5) * 30 + 40;  // Alinear verticalmente en grupos de 5, +40 para dejar espacio para las etiquetas
            
            nameField.setBounds(10, y, 150, 24); // Ajustar la posición y tamaño
            weightField.setBounds(180, y, 100, 24); // Ajustar la posición y tamaño
            
            fieldsPanel.add(nameField);
            fieldsPanel.add(weightField);
        }
        
        // Refrescar el panel
        fieldsPanel.revalidate();
        fieldsPanel.repaint();
    }
}
