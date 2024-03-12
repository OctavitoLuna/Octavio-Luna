import java.util.Scanner;

public class eje2Aplicacion {
    public static void main(String[] args) {
        int n = 0;
        int opciones = 0;
        Scanner cin = new Scanner(System.in);
        eje2 jugadores = new eje2(n);
        while(true){
            System.out.print("\nEscogue 2 opciones: \n1)Agregar jugadores\n2)Mostrar\n3)Salir\nRespuesta: ");
            opciones = cin.nextInt();
            switch(opciones){
                case 1:
                    System.out.print("Ingresa la cantidad de jugadores a agregar: ");
                    n = cin.nextInt();
                    jugadores.setN(n);
                    jugadores.agregar();
                    break;
                case 2:
                    jugadores.mostrar();
                    break;
                case 3:
                    System.exit(0);;
                    break;
                default:
                    System.out.println("Opción no válida\n");
            }
        }
    }
}