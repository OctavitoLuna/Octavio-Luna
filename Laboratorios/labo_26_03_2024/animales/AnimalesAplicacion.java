package labo_26_03.animales;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AnimalesAplicacion {

    public static void main(String[] args) {
        String nombre;
        Scanner cin = new Scanner(System.in);
        
        Leon leon = new Leon("Nosty", "Por hambre");
        Bovino vaca = new Bovino("Lola", 0);
        Animal noseQueAnimal = new Bovino("Lola", 2);

        JOptionPane.showMessageDialog(null, noseQueAnimal.Sonido());
        
    }
    
}
