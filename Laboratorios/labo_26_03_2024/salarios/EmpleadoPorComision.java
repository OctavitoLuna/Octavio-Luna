
import java.util.Scanner;

public class EmpleadoPorComision extends Empleado {
    private double ventasBrutas;
    private double tasaComision;

    public EmpleadoPorComision(String nombre, int ci, int salario) {
        super(nombre, ci, salario);
        this.tasaComision = salario; // Asumimos que el salario es la tasa de comisión
    }

    @Override
    public int Salario() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Ventas brutas mensuales: ");
        ventasBrutas = cin.nextDouble();
        return (int) (ventasBrutas * (tasaComision / 100.0));
    }
}
