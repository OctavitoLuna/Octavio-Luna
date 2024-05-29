

public abstract class NoArquero extends Jugador{
    public int remates;

    public NoArquero (String nombre, int dorsal, int tarjetasAmarillas, int tarjetasRojas, int remates){
        super(nombre, dorsal, tarjetasAmarillas, tarjetasRojas);
        this.remates =remates;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public int getDorsal() {
        return super.getDorsal();
    }
    @Override
    public void setDorsal(int dorsal) {
        super.setDorsal(dorsal);
    }
    @Override
    public int getTarjetasAmarillas() {
        return super.getTarjetasAmarillas();
    }
    @Override
    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        super.setTarjetasAmarillas(tarjetasAmarillas);
    }
    @Override
    public int getTarjetasRojas() {
        return super.getTarjetasRojas();
    }
    @Override
    public void setTarjetasRojas(int tarjetasRojas) {
        super.setTarjetasRojas(tarjetasRojas);
    }





    public int getRemates() {
        return remates;
    }
    public void setRemates(int remates) {
        this.remates = remates;
    }
    @Override
    public void SimularTarjetasAmarillas (int a, int b){
       super.SimularTarjetasAmarillas(a, b);
    }
    @Override
    public void SimularTarjetasRojas (int a, int b){
       super.SimularTarjetasRojas(a, b);
    }
}
