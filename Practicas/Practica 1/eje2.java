import java.util.Scanner;

public class eje2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el texto: ");
        String texto = scanner.nextLine();
        scanner.close();
        
        int contador = 0, flag = 0;
        for (char letra : texto.toCharArray()) {
            letra = Character.toLowerCase(letra);
            if (letra >= 'a' && letra <= 'z') {
                flag++;
            } else {
                flag = 0;
            }
            if (flag == 1) {
                contador++;
            }
        }
        System.out.println("El número de palabras es: " + contador);
    }
}
