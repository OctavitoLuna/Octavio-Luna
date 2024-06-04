package Modelo;

public class Usuario {
	public String nombre;
	public String contraseña;
	public Usuario(String nombre, String contraseña){
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public String getNombre() {
        return nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
