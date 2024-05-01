import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        double x, y, h;
        System.out.println("SUPERFICIE Y VOLUMEN DE UN PARALELEPIPEDO");
        x = Entrada("Ingrese un lado: ");
        y = Entrada("Ingrese un lado: ");
        h = Entrada("Ingrese la altura: ");
        Parale parale = new Parale(x, y, h);
        System.out.println("Superficie: " + parale.Superficie());
        System.out.println("Volumen: " + parale.Volumen());
    }

    public static double Entrada(String mensaje){
        Double a = 0.0;
        Scanner cin = new Scanner(System.in);
        while(true){
            try{
                System.out.print(mensaje);
                a = Double.parseDouble(cin.next());
                return a;
            }
            catch (NumberFormatException e) {
                System.out.println("Ingresaste un dato incorrecto...");
            }
        }

    }
}
