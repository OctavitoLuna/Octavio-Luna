import java.util.Scanner;

public class eje3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int a = scanner.nextInt();
        System.out.print("Ingresa otro numero: ");
        int b = scanner.nextInt();
        scanner.close();
        
        int aDivisores = 0, bDivisores = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                aDivisores += i;
            }
        }
        
        for (int i = 1; i < b; i++) {
            if (b % i == 0) {
                bDivisores += i;
            }
        }
        
        if (a == bDivisores && b == aDivisores) {
            System.out.println("Son numeros amigos");
        } else {
            System.out.println("No son numeros amigos");
        }
    }
}
