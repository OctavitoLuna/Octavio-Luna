import java.util.Scanner;

public class eje3Aplicacion {
    public static void main(String[] args) {
        String entrada = "";
        String salida = "";
        Scanner cin = new Scanner(System.in);
        System.out.print("Hora entrada (hh:mm): ");
        entrada = cin.next();
        System.out.print("Hora salida (hh:mm): ");
        salida = cin.next();
        eje3 horario = new eje3(entrada, salida);
        horario.atrasos();
    }
}
