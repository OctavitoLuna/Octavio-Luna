

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
        System.out.print("Salario semanal: ");
        salario = cin.nextInt();
        System.out.print("Tipo de salario\n1) Asalariado\n2) Por hora\n3) Por comisión\nRespuesta: ");
        tipo = cin.nextInt();

        Empleado empleado = null;
        
        switch (tipo) {
            case 1:
                empleado = new EmpleadoAsalariado(nombre, ci, salario);
                break;
            case 2:
                empleado = new EmpleadoPorHoras(nombre, ci, salario);
                break;
            case 3:
                empleado = new EmpleadoPorComision(nombre, ci, salario);
                break;
            default:
                System.out.println("Tipo de salario no válido.");
                System.exit(1);
        }

        System.out.println("Salario mensual: " + empleado.Salario());
    }
}
