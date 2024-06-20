package Controlador;

public class Estudiantes extends Personas{
	String fechaIngreso, semestre;
	int carrera;
	public Estudiantes(String nombre, String apellidoP, String apellidoM, String contrasena, String direccion, String nacion, String carnet, String sexo, String estadoCivil, String correoElectronico, String fechaNacimiento, int nRegistro, int telefonoMovil, int carrera, String fechaIngreso, String semestre) {
		super(nombre, apellidoP, apellidoM, contrasena, direccion, nacion, carnet, sexo, estadoCivil, correoElectronico, fechaNacimiento, telefonoMovil);
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.semestre = semestre;
	}
	public int getCarrera() {
		return carrera;
	}
	public void setCarrera(int carrera) {
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
