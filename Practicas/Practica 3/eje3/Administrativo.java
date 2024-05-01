public class Administrativo extends Empleado{
    public double salario = 5000;
    public Administrativo(String nombre, String cedula, String dependencia){
        super(nombre, cedula, dependencia);
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }


    public double CalculoSalario(){
        return getSalario();
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
