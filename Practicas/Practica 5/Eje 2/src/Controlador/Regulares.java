package Controlador;

public class Regulares extends Estudiantes{
	private static final long serialVersionUID = 1L;
	public String nacionalidad;
	public String departamento;
	public String ubicacion;
	public Regulares(String nombre, String carnet, String fecha_de_nacimiento, String carrera, String nacionalidad, String departamento, String ubicacion) {
		super(nombre, carnet, fecha_de_nacimiento, carrera);
		this.nacionalidad = nacionalidad;
		this.departamento = departamento;
		this.ubicacion = ubicacion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	@Override
    public String toString() {
    	return "Estudiante nombre=" + nombre + ", carnet=" + carnet + "fecha=" + fecha_de_nacimiento + "carrera=" + carrera + "nacionalidad=" + nacionalidad + ", departamento=" + departamento + ", ubicacion=" + ubicacion;
    }

	
	
}
