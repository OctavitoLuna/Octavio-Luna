package labo_26_03.salarios;

public abstract class Empleado {
    public String nombre;
    public int ci;
    public int salario;
    public int tipo;

    public Empleado (String nombre, int ci, int salario, int tipo){
        this.nombre = nombre;
        this.ci = ci;
        this.salario = salario;
        this.tipo = tipo;
    }


    public int getCi() {
        return ci;
    }
    public void setCi(int ci) {
        this.ci = ci;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public abstract int Salario();
}
