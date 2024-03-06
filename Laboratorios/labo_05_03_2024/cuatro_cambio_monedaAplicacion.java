import java.util.Scanner;

public class cuatro_cambio_monedaAplicacion{
    public static void main(String[] args) {
        double opcion = 0;
        double monto = 0;
        double opcionMoneda = 0;

        System.out.print("Ingresa un monto en bolivianos: ");
        Scanner cin = new Scanner(System.in);
        monto = cin.nextInt();

        System.out.print("Elige una opción:\n1. Bolivianos a dolares.\n2. Dólares a bolivianos.\n3. Bolivianos a dolares paralelo barato.\n4. Bolivianos a dólares paralelo caro.\n5. Bolivianos a euros.\nIngrese la opción: ");
        opcion = cin.nextInt();

        if (opcion != 2) {
            System.out.print("Elige el tipo de cambio:\n1. Dolar paralelo barato.\n2. Dólar oficial.\n3. Dolar paralelo caro.\n4. Euro.\nIngrese la opción: ");
            opcionMoneda = cin.nextInt();
        }

        // Crear objeto CambioMoneda con los tipos de cambio especificados
        cuatro_cambio_moneda programaCambio = new cuatro_cambio_moneda(monto, opcion);

        double resultado = 0;

        // Realizar el cambio de acuerdo a la opción elegida
        if (opcion == 1) {
            resultado = programaCambio.bolivianosADolares();
        } else if (opcion == 2) {
            resultado = programaCambio.dolaresABolivianos();
        }

        // Mostrar el resultado
        System.out.print("Resultado: " + resultado);
    }
}
