package Controlador;

import java.io.Serializable;

public class Estudiantes implements Serializable{
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String carnet;
	public String fecha_de_nacimiento;
	public String carrera;
	public Estudiantes(String nombre, String carnet, String fecha_de_nacimiento, String carrera) {
		this.nombre = nombre;
		this.carnet = carnet;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.carrera = carrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}
	public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
    @Override
    public String toString() {
        return "Estudiante nombre=" + nombre + ", carnet=" + carnet + "fecha=" + fecha_de_nacimiento + "carrera=" + carrera;
    }
	
}
