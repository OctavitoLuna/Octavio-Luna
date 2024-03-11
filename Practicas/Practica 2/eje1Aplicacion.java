import java.util.Scanner;

public class eje1Aplicacion {
    public static void main(String[] args) {
        String palabra = "";
        Scanner cin = new Scanner(System.in);
        System.out.println("Ingresa una palabra");
        palabra = cin.next();
        eje1 contar = new eje1(palabra);
        contar.contar_palabras();
    }
}