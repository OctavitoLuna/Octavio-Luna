
import java.util.Scanner;

public class EmpleadoPorHoras extends Empleado {
    private int horas;

    public EmpleadoPorHoras(String nombre, int ci, int salario) {
        super(nombre, ci, salario);
    }

    @Override
    public int Salario() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Horas trabajadas por semana: ");
        horas = cin.nextInt();
        int pagoSemanal;

        if (horas <= 40) {
            pagoSemanal = horas * salario;
        } else {
            pagoSemanal = (40 * salario) + ((horas - 40) * salario * 2);
        }

        return pagoSemanal * 4; // Salario mensual basado en 4 semanas
    }
}
