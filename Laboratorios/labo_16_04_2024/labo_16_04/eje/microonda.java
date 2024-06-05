package labo_16_04.eje;

public class microonda extends Electrodomestico{
    double capacidad;
	double potencia;
	
	public microonda(double precio, String color, char consumo, double peso, double capacidad, double potencia) {
		super(precio, color, consumo, peso);
		this.capacidad = capacidad;
		this.potencia = potencia;
	}

	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	@Override
	public double precioFinal() {
		if (potencia % 5 == 0){
			return super.precioFinal() + 5;
		}
		return super.precioFinal();
	}
}
