package semana09.calculadora;

public class CalculadoraAplicacion {

    public static void main(String[] args) {

        double num1 = 10.5;
        double num2 = 5.2;

        Calculadora calculadora = new Calculadora(num1, num2);

        System.out.println("Suma: " + calculadora.sumar());
        System.out.println("Resta: " + calculadora.restar());
        System.out.println("Multiplicación: " + calculadora.multiplicar(num1, num2));
        System.out.println("División: " + calculadora.dividir(num1, num2));
    }
    
}
