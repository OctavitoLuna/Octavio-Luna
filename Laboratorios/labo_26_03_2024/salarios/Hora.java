package labo_26_03.salarios;
import java.util.Scanner;
public class Hora extends Empleado{
    public int horas;
    public Hora (String nombre, int ci, int salario, int tipo){
        super(nombre, ci, salario, tipo);
        
    }

    public int Salario() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Horas trabajadas: ");
        horas = cin.nextInt();
        if(horas <= 40){
            return horas * salario;
        }    
        return ((salario - 40)*horas)*2 + 40 * horas;
    }
    
}
