package Modelo;
import Vista.Pantalla_1;
import Controlador.Carnes;
import Controlador.Frutas;
import Controlador.Lacteos;
import Controlador.Productos;
import java.util.ArrayList;
import Controlador.Productos;
import Vista.Editar;
public class App {
	public static ArrayList<Productos> productos;
	public static void main(String[] args){
		
		productos = new ArrayList<Productos>();
		productos.add(new Lacteos(123, "Mantequilla", 1.5, 5));
		productos.add(new Carnes(1234, "Res", 1.5, 5, 4.5));
		productos.add(new Frutas(12345, "Manzana", 1.5, 5, 4.5));
		
		Pantalla_1 Pantalla_1 = new Pantalla_1(productos);
		Editar Editar = new Editar(null);

		Pantalla_1.setVisible(true);
	}
}