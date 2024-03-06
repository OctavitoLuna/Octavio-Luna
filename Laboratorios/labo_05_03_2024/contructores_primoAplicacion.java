import java.util.Scanner;

public class contructores_primoAplicacion{
    public static void main(String[] args){
        int numeroUno = 0;
        System.out.print("Ingresa un numero: ");
        Scanner cin = new Scanner(System.in);
        numeroUno = cin.nextInt();

        contructores_primo programa_primo = new contructores_primo(numeroUno);
        int identificar_primo = programa_primo.indentificar_primo();

        if(identificar_primo == 1){
            System.out.print("Es primo");
        }
        else{
            System.out.print("No es primo");
        }





    }
}