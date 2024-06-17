package Modelo;
//importar otros script
import Vista.Bienvenida;


public class App {
	public static void main(String[] args){
		System.out.println("Hello, Universidad!");
		Bienvenida Bienvenida = new Bienvenida();
		Bienvenida.setVisible(true);
	}
}
