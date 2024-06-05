package labo_16_04.eje;

public class Lavadora extends Electrodomestico{
    double carga;
	
	public Lavadora(double precio, String color, char consumo, double peso, double carga) {
		super(precio, color, consumo, peso);
		this.carga = carga;
	}

	public double getCarga() {
        return carga;
    }
    public void setCarga(double carga) {
        this.carga = carga;
    }

	@Override
	public double precioFinal() {
		if (carga > 30){
			return super.precioFinal()+50;
		}
		return super.precioFinal();
	}
}
