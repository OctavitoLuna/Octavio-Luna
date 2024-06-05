import java.util.Scanner;

public class EmpleadoAsalariadoMasComision extends EmpleadoAsalariado {
    private double ventasBrutas;
    private double tasaComision;

    public EmpleadoAsalariadoMasComision(String nombre, int ci, int salario, double tasaComision) {
        super(nombre, ci, salario);
        this.tasaComision = tasaComision;
    }

    @Override
    public int Salario() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Ventas brutas mensuales: ");
        ventasBrutas = cin.nextDouble();
        int salarioBase = super.Salario();
        int salarioComision = (int) (ventasBrutas * (tasaComision / 100.0));
        return salarioBase + salarioComision;
    }
}
