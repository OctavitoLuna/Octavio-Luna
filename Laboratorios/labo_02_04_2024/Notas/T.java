

public class T extends Parciales implements OperacionesFinales {
    public double t_final;

    public T(double par1, double par2, double t_final){
        super(par1, par2);
        this.t_final = t_final;
    }

    @Override
    public double calcularPromedio(double par1, double par2, double t_final) {
        return (par1 + par2 + t_final) / 3;
    }

    public String Res() {
        double promedio = calcularPromedio(getPar1(), getPar2(), t_final);
        return "El promedio final es: " + promedio;
    }
}
