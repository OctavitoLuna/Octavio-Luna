import java.util.Scanner;

public class primoAplicacion{
    public static void main(String[] args){
        int numeroUno = 0;
        System.out.print("Ingresa un numero: ");
        Scanner cin = new Scanner(System.in);
        numeroUno = cin.nextInt();

        primo programa_primo = new primo();
        int identificar_primo = programa_primo.indentificar_primo(numeroUno);

        if(identificar_primo == 1){
            System.out.print("Es primo");
        }
        else{
            System.out.print("No es primo");
        }





    }
}