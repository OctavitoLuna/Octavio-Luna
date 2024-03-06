import java.util.Scanner;

public class calculadoraAplicacion{
    public static void main(String[] args){
        int numeroUno = 0;
        int numeroDos = 0;
        int numeroTres = 0;
        System.out.println("Ingresa 2 numeros");
        Scanner cin = new Scanner(System.in);
        System.out.print("a: ");
        numeroUno = cin.nextInt();
        System.out.print("b: ");
        numeroDos = cin.nextInt();

        calculadora casio = new calculadora(numeroUno, numeroDos);
        int suma = casio.sumar();
        int restar = casio.restar();
        int multiplicar = casio.multiplicar();
        double dividir = casio.dividir();
        System.out.println("Resta:" + restar);
        System.out.println("Suma:" + suma);
        System.out.println("Multiplicacion:" + multiplicar);
        System.out.println("Division:" + dividir);

        System.out.print("Ingrese otro numero");
        numeroTres = cin.nextInt();

        casio.setNum2(numeroTres);
        double res2 = casio.sumar();
        System.out.println("Suma:" + res2);

        




    }
}