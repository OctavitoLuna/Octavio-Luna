package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class misMateriasDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public misMateriasDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(89, 58, 271, 22);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 166, 245, 57);
		contentPane.add(textArea);
		
		
		JButton volver = new JButton("volver");
		volver.setBounds(335, 11, 89, 23);
		contentPane.add(volver);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Docente Docente = new Docente();
				Docente.setVisible(true);
				dispose();
			}
		});
		
		JButton ver = new JButton("ver");
		ver.setBounds(264, 189, 89, 23);
		contentPane.add(ver);
		ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Falta
			}
		});
	}

}
