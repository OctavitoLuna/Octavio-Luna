package labo_26_03.animales;

public class Bovino extends Animal{
    public int cuernos;

    public Bovino(String nombre, int cuernos){
        super(nombre);
        this.cuernos = cuernos;
    }

    public String Sonido (){
        return "MUGE";
    }

}
