package Controlador;

public class Extranjeros extends Estudiantes{
	private static final long serialVersionUID = 1L;
	public String nacionalidad;
	public String idioma;
	public String pasaporte;
	public String ubicacion;
	
	public Extranjeros(String nombre, String carnet, String fecha_de_nacimiento, String carrera, String nacionalidad, String idioma, String pasaporte, String ubicacion){
		super(nombre, carnet, fecha_de_nacimiento, carrera);
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.pasaporte = pasaporte;
		this.ubicacion = ubicacion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
    @Override
    public String toString() {
    	return "Estudiante nombre=" + nombre + ", carnet=" + carnet + "fecha=" + fecha_de_nacimiento + "carrera=" + carrera + "nacionalidad=" + nacionalidad + "idioma=" + idioma + "pasaporte=" + pasaporte+ "ubicacion=" + ubicacion;
    }
	
	
}
