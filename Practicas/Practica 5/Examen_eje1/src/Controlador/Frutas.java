package Controlador;

public class Frutas extends Productos {
	public Double descuento;
	public Frutas(int codigo, String nombre, Double precio_unitario, int stock, Double descuento) {
		super(codigo, nombre, precio_unitario, stock);
		this.descuento = descuento;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
}
