import java.util.Scanner;

public class cambio_monedaAplicacion{
    public static void main(String[] args){
        double opcion = 0;
        double moneda = 0;
        double opcion_paralelo = 0;
        System.out.print("Ingresa un numero: ");
        Scanner cin = new Scanner(System.in);
        moneda = cin.nextInt();
        System.out.print("Pon 1 si quieres cambiar de boliviano a dolar|Pon 2 si quieres cambiar de dolar a boliviano: ");
        opcion = cin.nextInt();
        System.out.print("Quieres el dolar paralelo o el normal: paralelo 1, normal 2");
        opcion_paralelo = cin.nextInt();

        cambio_moneda programa_cambio = new cambio_moneda();
        double bo_do = programa_cambio.bo_do(moneda, opcion_paralelo);
        double do_bo = programa_cambio.do_bo(moneda, opcion_paralelo);

        if(opcion == 1){
            System.out.print("res: " + bo_do);
        }
        else{
            System.out.print("res: " + do_bo);
        }




    }
}