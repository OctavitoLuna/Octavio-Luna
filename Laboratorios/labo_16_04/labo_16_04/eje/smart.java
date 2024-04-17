package labo_16_04.eje;

public class smart extends television{
    String internet = "No tiene";
    public smart(double precio, String color, char consumo, double peso, double capacidad, double pulgadas, String internet) {
		super(precio, color, consumo, peso, pulgadas);
        this.internet = internet;
	}
    
}
