package Controlador;

public class Docentes extends Personas{
	String tituloAcademico, fechaContrato, tipoContrato;
	int facultad;
	public Docentes(String nombre, String apellidoP, String apellidoM, String contrasena, String direccion, String nacion, String carnet, String sexo, String estadoCivil, String correoElectronico, String fechaNacimiento, int telefonoMovil, String tituloAcademico, int facultad, String fechaContrato, String tipoContrato) {
		super(nombre, apellidoP, apellidoM, contrasena, direccion, nacion, carnet, sexo, estadoCivil, correoElectronico, fechaNacimiento, telefonoMovil);
		this.tituloAcademico = tituloAcademico;
		this.facultad = facultad;
		this.fechaContrato = fechaContrato;
		this.tipoContrato =tipoContrato;
	}
	public String getTituloAcademico() {
		return tituloAcademico;
	}
	public void setTituloAcademico(String tituloAcademico) {
		this.tituloAcademico = tituloAcademico;
	}
	public int getFacultad() {
		return facultad;
	}
	public void setFacultad(int facultad) {
		this.facultad = facultad;
	}
	public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
}
