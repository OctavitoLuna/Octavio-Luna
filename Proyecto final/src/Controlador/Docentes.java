package Controlador;

public class Docentes extends Personas{
	String tituloAcademico, departamento, fechaContrato, tipoContrato;
	public Docentes(String nombre, String apellidoP, String apellidoM, String contrasena, String direccion, String nacion, String carnet, String sexo, String estadoCivil, String correoElectronico, String fechaNacimiento, int nRegistro, int telefonoMovil, String tituloAcademico, String departamento, String fechaContrato, String tipoContrato) {
		super(nombre, apellidoP, apellidoM, contrasena, direccion, nacion, carnet, sexo, estadoCivil, correoElectronico, fechaNacimiento, nRegistro, telefonoMovil);
		this.tituloAcademico = tituloAcademico;
		this.departamento = departamento;
		this.fechaContrato = fechaContrato;
		this.tipoContrato =tipoContrato;
	}
	public String getTituloAcademico() {
		return tituloAcademico;
	}
	public void setTituloAcademico(String tituloAcademico) {
		this.tituloAcademico = tituloAcademico;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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
