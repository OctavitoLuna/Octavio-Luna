package Controlador;

public class Intercambio extends Estudiantes{
	public String anterior_universidad;
	public Intercambio(String nombre, String carnet, String fecha_de_nacimiento, String carrera, String anterior_universidad){
		super(nombre, carnet, fecha_de_nacimiento, carrera);
		this.anterior_universidad = anterior_universidad;
	}
	public String getAnterior_universidad() {
		return anterior_universidad;
	}
	public void setAnterior_universidad(String anterior_universidad) {
		this.anterior_universidad = anterior_universidad;
	}

}
