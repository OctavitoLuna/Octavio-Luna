import java.util.Scanner;

public class eje5Aplicacion {
    public static void main(String[] args) {
        int n = 0;
        Scanner cin = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz: ");
        n = cin.nextInt();
        eje5 matris = new eje5(n);
        matris.matris_completa();
    }
}