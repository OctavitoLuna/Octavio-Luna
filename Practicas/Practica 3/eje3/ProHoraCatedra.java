public class ProHoraCatedra extends Docente{
    public double hora;
    public ProHoraCatedra(String nombre, String cedula, String dependencia, double calificacion_asignada, int hora){
        super(nombre, cedula, dependencia, calificacion_asignada);
        this.hora = hora;
    }
    public double getHora() {
        return hora;
    }
    public void setHora(double hora) {
        this.hora = hora;
    }
    @Override
    public double CalculoSalario(){
        return super.CalculoSalario() + (hora * 50);
    }
    @Override
    public String toString(){
        return super.toString() + "\n- Salario = " + CalculoSalario();
    }
}
