public abstract class Empleado {
    protected String nombre;
    protected int ci;
    protected int salario;

    public Empleado(String nombre, int ci, int salario) {
        this.nombre = nombre;
        this.ci = ci;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    public int CaSalario(){
        return 0;
    }
    public int calcularSalario(){
        return 0;
    };
}
