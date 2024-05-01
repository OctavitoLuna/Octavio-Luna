public class Empleado {
    public String nombre, cedula, dependencia;
    public Empleado(String nombre, String cedula, String dependencia){
        this.nombre = nombre;
        this.cedula = cedula;
        this.dependencia = dependencia;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getDependencia() {
        return dependencia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public String toString() {
        return "SALARIO: \n- Nombre: " + getNombre() + "\n- Cedula: " + getCedula() + "\n- Dependencia: " + getDependencia();
    }
}
