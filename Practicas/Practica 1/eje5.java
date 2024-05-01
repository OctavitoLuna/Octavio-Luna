import java.util.Scanner;
import javafx.application.Application;

public class eje5 {
    public static int reducir(int numero) {
        while (true) {
            if (numero >= 10) {
                int sumaDigitos = 0;
                while (numero != 0) {
                    sumaDigitos += numero % 10;
                    numero /= 10;
                }
                numero = sumaDigitos;
            } else {
                break;
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu año de nacimiento: ");
        int año = scanner.nextInt();
        System.out.print("Ingresa tu mes de nacimiento: ");
        int mes = scanner.nextInt();
        System.out.print("Ingresa tu día de nacimiento: ");
        int dia = scanner.nextInt();
        scanner.close();

        año = reducir(año);
        mes = reducir(mes);
        dia = reducir(dia);

        int res = año + mes + dia;

        System.out.println("Tu número es: " + reducir(res));
    }
}
