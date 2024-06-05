

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("FIGURAS");
            System.out.println("Ingrese una de las siguientes opciones:");
            System.out.print("1)Cuadrado\n2)Triangulo\n3)Circulo\n4)Salir\nRes: ");

            String opcion = scanner.nextLine();
            String figura = "";
            String color = "";
            double a, b, c, radio;

            switch (opcion) {
                case "1":
                    figura = "Cuadrado";
                    System.out.print("Ingrese el color del " + figura + ": ");
                    color = scanner.nextLine();
                    System.out.print("Ingrese un lado del " + figura + ": ");
                    a = Double.parseDouble(scanner.nextLine());
                    Cuadrado cuadrado = new Cuadrado(figura, color, a);
                    System.out.println("El área del " + cuadrado.getNombre() + " " + cuadrado.getColor() + ": " + cuadrado.calcularArea());
                    System.out.println("El perímetro del " + cuadrado.getNombre() + " " + cuadrado.getColor() + ": " + cuadrado.calcularPerimetro());
                    break;

                case "2":
                    figura = "Triangulo";
                    System.out.print("Ingrese el color del " + figura + ": ");
                    color = scanner.nextLine();
                    System.out.print("Ingrese un lado del " + figura + ": ");
                    a = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese otro lado del " + figura + ": ");
                    b = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese el último lado del " + figura + ": ");
                    c = Double.parseDouble(scanner.nextLine());
                    Triangulo triangulo = new Triangulo(figura, color, a, b, c);
                    System.out.println("El área del " + triangulo.getNombre() + " " + triangulo.getColor() + ": " + triangulo.calcularArea());
                    System.out.println("El perímetro del " + triangulo.getNombre() + " " + triangulo.getColor() + ": " + triangulo.calcularPerimetro());
                    break;

                case "3":
                    figura = "Circulo";
                    System.out.print("Ingrese el color del " + figura + ": ");
                    color = scanner.nextLine();
                    System.out.print("Ingrese el radio del " + figura + ": ");
                    radio = Double.parseDouble(scanner.nextLine());
                    Circulo circulo = new Circulo(figura, color, radio);
                    System.out.println("El área del " + circulo.getNombre() + " " + circulo.getColor() + ": " + circulo.calcularArea());
                    System.out.println("El perímetro del " + circulo.getNombre() + " " + circulo.getColor() + ": " + circulo.calcularPerimetro());
                    break;

                case "4":
                    System.exit(0);

                default:
                    System.out.println("Te equivocaste en algo");
                    break;
            }
        }
    }
}
