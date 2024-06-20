package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Docente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int verificadorPersona;

	public Docente() {
		//esto es para decir que somos docentes
		verificadorPersona = 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton misDatos = new JButton("misDatos");
		misDatos.setBounds(44, 106, 89, 23);
		contentPane.add(misDatos);
		misDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisDatos MisDatos = new MisDatos(verificadorPersona);
				MisDatos.setVisible(true);
				dispose();
			}
		});
		
		JButton misMaterias = new JButton("misMaterias");
		misMaterias.setBounds(257, 106, 89, 23);
		contentPane.add(misMaterias);
		misMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				misMateriasDocente MisMateriasDocente = new misMateriasDocente();
				MisMateriasDocente.setVisible(true);
				dispose();
			}
		});
		
		JButton salir = new JButton("Salir");
		salir.setBounds(447, 35, 89, 23);
		contentPane.add(salir);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
