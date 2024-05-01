public class Docente extends Empleado{
    public double calificacion_asignada;
    public Docente(String nombre, String cedula, String dependencia, double calificacion_asignada){
        super(nombre, cedula, dependencia);

        this.calificacion_asignada = calificacion_asignada;
        
    }
    public double getCalificacion_asignada() {
        return calificacion_asignada;
    }

    public void setCalificacion_asignada(double calificacion_asignada) {
        this.calificacion_asignada = calificacion_asignada;
    }


    @Override
    public String toString(){
        return super.toString() + "\n- Calificacion asignada: " + getCalificacion_asignada();
    }

    public double CalculoSalario(){
        return 0;
    }
}
