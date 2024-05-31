package eje1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField numA;
    private JTextField numB;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Calculadora frame = new Calculadora();
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
    public Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.CYAN);
        contentPane.setForeground(Color.CYAN);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        numA = new JTextField();
        numA.setBounds(99, 59, 114, 20);
        contentPane.add(numA);
        numA.setColumns(10);

        numB = new JTextField();
        numB.setColumns(10);
        numB.setBounds(99, 99, 114, 20);
        contentPane.add(numB);

        JTextArea res = new JTextArea();
        res.setEditable(false);
        res.setBounds(273, 68, 151, 125);
        contentPane.add(res);

        JLabel lblNewLabel = new JLabel("numero 1");
        lblNewLabel.setBounds(10, 62, 64, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNumero = new JLabel("numero 2");
        lblNumero.setBounds(10, 102, 64, 14);
        contentPane.add(lblNumero);

        String[] operaciones = {"sumar", "restar", "multiplicar", "dividir"};
        JComboBox<String> comboBox = new JComboBox<>(operaciones);
        comboBox.setBounds(99, 130, 114, 22);
        contentPane.add(comboBox);

        JButton btnCalcular = new JButton("calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(numA.getText());
                    double b = Double.parseDouble(numB.getText());
                    String operacion = (String) comboBox.getSelectedItem();
                    double result = 0;
                    switch (operacion) {
                        case "sumar":
                            result = a + b;
                            break;
                        case "restar":
                            result = a - b;
                            break;
                        case "multiplicar":
                            result = a * b;
                            break;
                        case "dividir":
                            if (b != 0) {
                                result = a / b;
                            } else {
                                res.setText("No se puede dividir por cero");
                                return;
                            }
                            break;
                    }
                    res.setText("Resultado: " + result);
                } catch (NumberFormatException ex) {
                    res.setText("Ingrese numeros validos");
                }
            }
        });
        btnCalcular.setBounds(99, 187, 114, 23);
        contentPane.add(btnCalcular);
        
        JLabel lblNewLabel_1 = new JLabel("CALCULADORA");
        lblNewLabel_1.setFont(new Font("Swis721 BdOul BT", Font.PLAIN, 52));
        lblNewLabel_1.setBackground(Color.RED);
        lblNewLabel_1.setBounds(10, 0, 414, 54);
        contentPane.add(lblNewLabel_1);
    }
}