package labo_16_04.eje;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ElectrodomesticoApp {
    public static void main(String[] args) {
        float total =0;
		int n = 0;
        while(true){
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
            }
        }
		List <Lavadora> listaElec = new ArrayList <Lavadora>();
		for (int i=0; i<n; i++){
            try {
                Lavadora p1= null;
                String b =(JOptionPane.showInputDialog("color: "));
                String c1 = (JOptionPane.showInputDialog("consumo: "));
                char c=c1.charAt(0);
                float d= Float.parseFloat(JOptionPane.showInputDialog("peso: "));
                float e= Float.parseFloat(JOptionPane.showInputDialog("carga: "));
                p1= new Lavadora(100, b, c, d, e);
                System.out.println(p1.precioFinal());
                listaElec.add(p1);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                i=i-1;
            }
                
        }
        for (Lavadora tmp: listaElec){
            total+=tmp.precioFinal();
		}
        
		JOptionPane.showMessageDialog(null,+ total);
    }
}
