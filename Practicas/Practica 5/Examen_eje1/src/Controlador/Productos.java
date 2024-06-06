package Controlador;

public class Productos {
	public int codigo;
	public String nombre;
	public Double precio_unitario;
	public int stock;
	public Productos(int codigo, String nombre, Double precio_unitario, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio_unitario = precio_unitario;
		this.stock = stock;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public Double getPrecio_unitario() {
        return precio_unitario;
    }
    public int getStock() {
        return stock;
    }
    
}
