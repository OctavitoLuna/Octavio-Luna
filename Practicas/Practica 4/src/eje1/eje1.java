package eje1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class eje1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextArea areaTexto;
	private ArrayList<String> listaCorreos;
	private int contadorGmail;
	private int contadorHotmail;
	private int contadorLive;

    /**
     * Launch the application.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eje1 frame = new eje1();
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
	public eje1() {
		listaCorreos = new ArrayList<>();
		contadorGmail = 0;
		contadorHotmail = 0;
		contadorLive = 0;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREADOR DE CORREOS");
		lblNewLabel.setBounds(186, 21, 184, 14);
		contentPane.add(lblNewLabel);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(88, 70, 254, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo = txtCorreo.getText();
				if (!correoExiste(correo)) {
					listaCorreos.add(correo);
					if (correo.endsWith("@gmail.com")) {
						contadorGmail++;
					} else if (correo.endsWith("@hotmail.com")) {
						contadorHotmail++;
					} else if (correo.endsWith("@live.com")) {
						contadorLive++;
					}
					actualizarTexto();
				} else {
					areaTexto.setText("El correo ya existe.");
				}
			}
		});
		btnCrear.setBounds(412, 69, 89, 23);
		contentPane.add(btnCrear);
		
		areaTexto = new JTextArea();
		areaTexto.setBounds(126, 141, 254, 108);
		contentPane.add(areaTexto);
	}

	private void actualizarTexto() {
		areaTexto.setText("Gmail: " + contadorGmail + "\n" +
		                  "Hotmail: " + contadorHotmail + "\n" +
		                  "Live: " + contadorLive);
	}

	private boolean correoExiste(String correo) {
		for (String c : listaCorreos) {
			if (c.equals(correo)) {
				return true;
			}
		}
		return false;
	}
}
