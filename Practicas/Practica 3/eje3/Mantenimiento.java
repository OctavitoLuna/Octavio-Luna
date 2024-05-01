public class Mantenimiento extends Administrativo{
    public double hora;
    public String lista;
    public Mantenimiento(String nombre, String cedula, String dependencia, int hora, String lista){
        super(nombre, cedula, dependencia);
        this.hora = hora;
        this.lista = lista;

    }
    public double getHora() {
        return hora;
    }
    public String getLista() {
        return lista;
    }
    public void setHora(double hora) {
        this.hora = hora;
    }
    public void setLista(String lista) {
        this.lista = lista;
    }

    @Override
    public double CalculoSalario(){
        return super.CalculoSalario() + (getHora() * 40);
    }

    @Override
    public String toString(){
        return super.toString() + "\n- Salario = " + CalculoSalario() + "\n" + getLista();
    }

}
