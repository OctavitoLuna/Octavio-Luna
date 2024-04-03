package labo_26_03.salarios;
import java.util.Scanner;
public class Asalariado extends Empleado{
    public Asalariado (String nombre, int ci, int salario, int tipo){
        super(nombre, ci, salario, tipo);
    }

    public int Salario() {
        return salario*4;
    }
    
}