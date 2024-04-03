package labo_26_03.animales;

public class Leon extends Animal{
    public String TipoCazador;

    public Leon (String nombre, String TipoCazador){
        super(nombre);
        this.TipoCazador = TipoCazador;
    }

    public String getTipoCazador() {
        return TipoCazador;
    }

    public void setTipoCazador(String tipoCazador) {
        TipoCazador = tipoCazador;
    }
    
    public String Sonido() {
        return "Ruge";
    }




    
}
