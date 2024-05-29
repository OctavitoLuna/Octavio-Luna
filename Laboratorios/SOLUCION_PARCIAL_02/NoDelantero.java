

public abstract class NoDelantero extends NoArquero{
    
    public int despejes;

    public NoDelantero (String nombre, int dorsal, int tarjetasAmarillas, int tarjetasRojas, int remates, int despejes){
        super(nombre, dorsal, tarjetasAmarillas, tarjetasRojas, remates);
        this.despejes = despejes;
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
    @Override
    public int getRemates() {
        return super.getRemates();
    }
    @Override
    public void setRemates(int remates) {
        super.setRemates(remates);
    }
    public int getDespejes() {
        return despejes;
    }
    public void setDespejes(int despejes) {
        this.despejes = despejes;
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
