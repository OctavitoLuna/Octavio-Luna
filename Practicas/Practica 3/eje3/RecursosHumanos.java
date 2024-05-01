public class RecursosHumanos extends Administrativo{
    public int tipo;
    public double res;
    public double tesoreria = 1000;
    public double secretaria = 700;
    public RecursosHumanos(String nombre, String cedula, String dependencia, int tipo){
        super(nombre, cedula, dependencia);
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    @Override
    public double CalculoSalario(){
        if(getTipo() == 1){
            res = tesoreria;
        }
        else{
            res = secretaria;
        }
        return super.CalculoSalario() + res;
    }
    @Override
    public String toString(){
        return super.toString() + "\n- Salario = " + CalculoSalario();
    }
}
