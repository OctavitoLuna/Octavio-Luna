package labo_26_03.salarios;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SalarioAplicacion {

    public static void main(String[] args) {
        String nombre;
        int ci;
        int salario;
        int tipo;
        Scanner cin = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = cin.next();
        System.out.print("CI: ");
        ci = cin.nextInt();
        System.out.print("Salario: ");
        salario = cin.nextInt();   
        System.out.print("Tipo de salario\n1)Asalariado\n2)Por hora\n3)Por comision\nRespuesta: ");
        tipo = cin.nextInt();
        Hora hora = new Hora(nombre, ci, salario, tipo);
        Asalariado asalariado = new Asalariado(nombre, ci, salario, tipo);
        Comision comision = new Comision(nombre, ci, salario, tipo);
        if(tipo == 1){

        }
        if(tipo == 2){
            
        }
        if(tipo == 3){

        }
        


        JOptionPane.showMessageDialog(null, noseQueAnimal.Sonido());
        
    }
    
}
