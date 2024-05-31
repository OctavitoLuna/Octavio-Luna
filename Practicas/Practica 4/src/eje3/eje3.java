package eje3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class eje3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;
    private JTextField txtLanzamientos;
    private JEditorPane editorPaneResultados;
    private JTextPane txtPromedio;
    private JTextPane txtCaraMayor;
    private JTextArea txtCaraMenor;
    private JRadioButton radioBtn6Caras;
    private JRadioButton radioBtn8Caras;
    private ButtonGroup grupoBotones;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    eje3 frame = new eje3();
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
    public eje3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 489);
        panelContenido = new JPanel();
        panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(panelContenido);
        panelContenido.setLayout(null);

        JLabel lblTitulo = new JLabel("SIMULACION DADO");
        lblTitulo.setBounds(238, 27, 148, 14);
        panelContenido.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(68, 78, 46, 14);
        panelContenido.add(lblUsuario);

        radioBtn6Caras = new JRadioButton("6 caras");
        radioBtn6Caras.setBounds(148, 74, 109, 23);
        panelContenido.add(radioBtn6Caras);

        radioBtn8Caras = new JRadioButton("8 caras");
        radioBtn8Caras.setBounds(252, 74, 109, 23);
        panelContenido.add(radioBtn8Caras);

        grupoBotones = new ButtonGroup();
        grupoBotones.add(radioBtn6Caras);
        grupoBotones.add(radioBtn8Caras);

        txtLanzamientos = new JTextField();
        txtLanzamientos.setText("Lanzamientos");
        txtLanzamientos.setBounds(68, 132, 251, 20);
        panelContenido.add(txtLanzamientos);
        txtLanzamientos.setColumns(10);

        JButton btnSimulacion = new JButton("Simulacion");
        btnSimulacion.setBounds(377, 131, 89, 23);
        panelContenido.add(btnSimulacion);

        editorPaneResultados = new JEditorPane();
        editorPaneResultados.setText("Res");
        editorPaneResultados.setBounds(238, 176, 295, 243);
        panelContenido.add(editorPaneResultados);

        txtPromedio = new JTextPane();
        txtPromedio.setText("Promedio");
        txtPromedio.setBounds(29, 176, 148, 20);
        panelContenido.add(txtPromedio);

        txtCaraMayor = new JTextPane();
        txtCaraMayor.setText("Cara mayor");
        txtCaraMayor.setBounds(29, 209, 148, 20);
        panelContenido.add(txtCaraMayor);

        txtCaraMenor = new JTextArea();
        txtCaraMenor.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCaraMenor.setText("Cara menor");
        txtCaraMenor.setBounds(29, 240, 148, 22);
        panelContenido.add(txtCaraMenor);

        btnSimulacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simularLanzamiento();
            }
        });
    }

    private void simularLanzamiento() {
        int numeroLanzamientos = Integer.parseInt(txtLanzamientos.getText());
        int numeroCaras = radioBtn6Caras.isSelected() ? 6 : 8;
        int[] conteoCaras = new int[numeroCaras];
        Random aleatorio = new Random();


        for (int i = 0; i < numeroLanzamientos; i++) {
            int resultado = aleatorio.nextInt(numeroCaras) + 1;
            conteoCaras[resultado - 1]++;
        }


        int suma = 0;
        int maxLanzada = 0;
        int minLanzada = numeroLanzamientos + 1;
        int caraMayor = 0;
        int caraMenor = 0;

        StringBuilder resultadosStr = new StringBuilder("Resultados de los lanzamientos:\n");

        for (int i = 0; i < conteoCaras.length; i++) {
            resultadosStr.append("Cara ").append(i + 1).append(": ").append(conteoCaras[i]).append(" veces\n");
            suma += (i + 1) * conteoCaras[i];
            if (conteoCaras[i] > maxLanzada) {
                maxLanzada = conteoCaras[i];
                caraMayor = i + 1;
            }
            if (conteoCaras[i] < minLanzada) {
                minLanzada = conteoCaras[i];
                caraMenor = i + 1;
            }
        }

        double promedio = (double) suma / numeroLanzamientos;

        editorPaneResultados.setText(resultadosStr.toString());
        txtPromedio.setText("Promedio: " + promedio);
        txtCaraMayor.setText("Cara mayor: " + caraMayor);
        txtCaraMenor.setText("Cara menor: " + caraMenor);
    }
}
