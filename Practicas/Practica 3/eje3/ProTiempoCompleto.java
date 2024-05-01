public class ProTiempoCompleto extends Docente{
    public int tipo;
    public double pregrado = 10000;
    public double maestria = 18000;
    public double doctorado = 25000;
    public double res;
    public ProTiempoCompleto(String nombre, String cedula, String dependencia, double calificacion_asignada, int tipo){
        super(nombre, cedula, dependencia, calificacion_asignada);
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
            res += pregrado;
        }
        else if(getTipo() == 2){
            res += maestria;
        }
        else{
            res += doctorado;
        }

        if(calificacion_asignada >= 4.5){
            res += 2000;
        }
        return super.CalculoSalario() + res;
    }

    @Override
    public String toString(){
        return super.toString() + "\n- Salario = " + CalculoSalario();
    }
}
