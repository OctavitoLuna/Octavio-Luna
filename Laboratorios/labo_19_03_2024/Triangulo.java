

public class Triangulo extends Figura {
    private double a;
    private double b;
    private double c;

    public Triangulo(String nombre, String color, double a, double b, double c) {
        super(nombre, color);
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double CalcularPerimetro() {
        return (a + b + c) / 2;
    }

    @Override
    public double calcularArea() {
        double s = CalcularPerimetro();
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calcularPerimetro() {
        return a + b + c;
    }
}
