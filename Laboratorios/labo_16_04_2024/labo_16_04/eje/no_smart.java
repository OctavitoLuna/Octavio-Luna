package labo_16_04.eje;

public class no_smart extends television{
    String internet = "Tiene";
    public no_smart(double precio, String color, char consumo, double peso, double capacidad, double pulgadas, String internet) {
		super(precio, color, consumo, peso, pulgadas);
        this.internet = internet;
	}
    
}
