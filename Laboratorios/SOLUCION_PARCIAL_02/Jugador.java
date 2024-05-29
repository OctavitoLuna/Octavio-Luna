

import java.util.Random;

public abstract class Jugador implements InterfaceTarjetas{
    public String nombre;
    public int dorsal;
    public int tarjetasAmarillas;
    public int tarjetasRojas;

    public Jugador (String nombre, int dorsal, int tarjetasAmarillas, int tarjetasRojas){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }
    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }
    public int getTarjetasRojas() {
        return tarjetasRojas;
    }
    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }



    public void SimularTarjetasAmarillas (int a, int b){
        Random random = new Random();
        tarjetasAmarillas = random.nextInt(b - a + 1) + a;
    }
    public void SimularTarjetasRojas (int a, int b){
        Random random = new Random();
        tarjetasRojas = random.nextInt(b - a + 1) + a;
    }
}
