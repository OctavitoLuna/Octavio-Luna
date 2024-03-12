import java.util.Scanner;

public class eje4Aplicacion {
    public static void main(String[] args) {
        String contrasena = "";
        Scanner cin = new Scanner(System.in);
        System.out.print("Ingresa la contraseña: ");
        contrasena = cin.next();
        eje4 fun_contrasena = new eje4(contrasena);
        fun_contrasena.revisar_contrasena();
    }
}
