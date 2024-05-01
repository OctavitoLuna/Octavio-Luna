import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        ProTiempoCompleto protiempocompleto = new ProTiempoCompleto("Octavio", "9994931", "Ingenieria", 5, 1);
        System.out.println(protiempocompleto.toString());

        ProHoraCatedra prohoracatedra = new ProHoraCatedra("Octavio", "9994931", "Ingenieria", 5, 8);
        System.out.println(prohoracatedra.toString());

        RecursosHumanos recursoshumanos = new RecursosHumanos("Octavio", "9994931", "Ingenieria", 1);
        System.out.println(recursoshumanos.toString());



        
    }

}
