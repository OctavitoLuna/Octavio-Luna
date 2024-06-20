package Controlador;

public class Personas {
	public String nombre, apellidoP, apellidoM, contrasena, direccion, nacion, carnet, sexo, estadoCivil, correoElectronico, fechaNacimiento;
	public int telefonoMovil;
	
	public Personas(String nombre, String apellidoP, String apellidoM, String contrasena, String direccion, String nacion, String carnet, String sexo, String estadoCivil, String correoElectronico, String fechaNacimiento, int telefonoMovil){
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.nacion = nacion;
		this.carnet = carnet;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.correoElectronico =correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
		
		this.telefonoMovil = telefonoMovil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacion() {
		return nacion;
	}

	public void setNacion(String nacion) {
		this.nacion = nacion;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(int telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	
}
