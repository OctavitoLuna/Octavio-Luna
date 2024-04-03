package semana09.calculadora;

public class Calculadora implements OperacionMatematicaInterfaz {
    public double a;
    public double b;

    public Calculadora (double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double sumar() {
        return a + b;
    }

    @Override
    public double restar() {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
        return a / b;
    }
}
