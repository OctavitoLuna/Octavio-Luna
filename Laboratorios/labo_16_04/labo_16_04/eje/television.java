package labo_16_04.eje;

public class television extends Electrodomestico{
    double pulgadas;
	
	public television(double precio, String color, char consumo, double peso, double pulgadas) {
		super(precio, color, consumo, peso);
		this.pulgadas = pulgadas;
	}
    public double getPulgadas() {
        return pulgadas;
    }
    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }


	@Override
	public double precioFinal() {
		if (pulgadas >= 50){
            pulgadas = pulgadas - 50;
			return super.precioFinal() + (pulgadas * 100);
		}
		return super.precioFinal();
	}

}
