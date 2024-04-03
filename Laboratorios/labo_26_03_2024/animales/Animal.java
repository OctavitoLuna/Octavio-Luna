package labo_26_03.animales;

public abstract class Animal {

    public String nombre;

    public Animal (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract String Sonido ();
    
}
