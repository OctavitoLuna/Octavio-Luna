package labo_16_04.eje;

public class licuadora extends Electrodomestico{
    public double capacidad;
	
	public licuadora(double precio, String color, char consumo, double peso, double capacidad) {
		super(precio, color, consumo, peso);
		this.capacidad = capacidad;
	}

    public double getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

	@Override
	public double precioFinal() {
		if (capacidad >= 2){
            capacidad = capacidad - 2;

			return super.precioFinal()+(capacidad * 10);
		}
		return super.precioFinal();
	}
}
