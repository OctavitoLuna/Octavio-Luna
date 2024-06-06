package Modelo;
import Vista.Pantalla_1;
import Controlador.Estudiantes;
import Controlador.Extranjeros;
import Controlador.Regulares;

import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class App {

    public static void escribirObjeto(Estudiantes estudiante, String archivo) {
        try (FileOutputStream fos = new FileOutputStream(archivo, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos) {
                 @Override
                 protected void writeStreamHeader() throws IOException {
                     reset();
                 }
             }) {
            oos.writeObject(estudiante);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void leerObjetos(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                	Estudiantes estudiante = (Estudiantes) ois.readObject();
                    System.out.println(estudiante);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    
	public static void main(String[] args){
		Estudiantes estudiante = new Extranjeros("Juan", "789", "23/04/2008", "comunicacion", "bolivia", "español", "789", "su casa");
		String archivo = "registros.obj";
		//escribirObjeto(estudiante, archivo);
		
        System.out.println("Objetos leídos del archivo:");
        leerObjetos(archivo);
		
		
		Pantalla_1 Pantalla_1 = new Pantalla_1();
		Pantalla_1.setVisible(true);
		
	}
}
