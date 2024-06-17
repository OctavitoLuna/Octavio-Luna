package Controlador;

public class Estudiantes extends Personas{
	String carrera, fechaIngreso, semestre;
	public Estudiantes(String nombre, String apellidoP, String apellidoM, String contrasena, String direccion, String nacion, String carnet, String sexo, String estadoCivil, String correoElectronico, String fechaNacimiento, int nRegistro, int telefonoMovil, String carrera, String fechaIngreso, String semestre) {
		super(nombre, apellidoP, apellidoM, contrasena, direccion, nacion, carnet, sexo, estadoCivil, correoElectronico, fechaNacimiento, nRegistro, telefonoMovil);
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.semestre = semestre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
	
}
