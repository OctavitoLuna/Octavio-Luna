import java.io.*;
import java.util.Scanner;

public class eje4 {
    // Un método para calcular la deuda total basada en la cantidad de materias elegidas
    public static double calcularDeuda(int cantidadMaterias) {
        int totalCreditos = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cantidadMaterias; i++) {
            System.out.print("Ingresa la cantidad de créditos para la materia " + (i + 1) + " : ");
            int creditos = scanner.nextInt();
            totalCreditos += creditos;
        }
        double deudaTotal = totalCreditos * 582;
        return deudaTotal;
    }

    // Método para registrar la información del estudiante y su deuda en un archivo
    public static void escribirDatosEstudiante() {
        try {
            FileWriter archivo = new FileWriter("deudas.txt", true);
            BufferedWriter bufferEscritura = new BufferedWriter(archivo);
            PrintWriter escritor = new PrintWriter(bufferEscritura);
            String ci, nombre;
            int cantidadMaterias;
            double deuda;
            int flag = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Detalles del estudiante:");
            System.out.print("Número de Carnet: ");
            ci = scanner.nextLine();
            System.out.print("Nombre completo: ");
            nombre = scanner.nextLine();
            System.out.print("Ingresa la cantidad de materias a cursar: ");
            cantidadMaterias = scanner.nextInt();
            deuda = calcularDeuda(cantidadMaterias);
            escritor.println(ci + ";" + nombre + ";" + cantidadMaterias + ";" + deuda + ";" + flag);
            escritor.close();
            bufferEscritura.close();
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Un método para aplicar un descuento por pago anticipado
    public static void aplicarDescuentoProntoPago() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("deudas.txt"));
            String ci, nombre = "", materias, deuda, descuento;
            int carnetEstudiante;
            double descuentoAplicado = 0;
            System.out.print("Introduce el número de Carnet del estudiante: ");
            Scanner scanner = new Scanner(System.in);
            carnetEstudiante = scanner.nextInt();
            double monto;
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                ci = datos[0];
                nombre = datos[1];
                materias = datos[2];
                deuda = datos[3];
                descuento = datos[4];
                int carnet = Integer.parseInt(ci);
                double deudaTotal = Double.parseDouble(deuda);
                if (carnet == carnetEstudiante) {
                    descuentoAplicado = 1;
                    System.out.println("\nDeuda total actual: " + deudaTotal + "bs.");
                    System.out.println("Se aplicó un descuento del 8% por pago anticipado con éxito.");
                    break;
                } else {
                    descuentoAplicado = 0;
                }
            }
            lector.close();
            if (descuentoAplicado == 0) {
                System.out.println("\nEstudiante no encontrado, inténtalo nuevamente.\n");
                aplicarDescuentoProntoPago();
            } else {
                FileWriter archivo = new FileWriter("deudas.txt", true);
                BufferedWriter bufferEscritura = new BufferedWriter(archivo);
                PrintWriter escritor = new PrintWriter(bufferEscritura);
                escritor.println(carnetEstudiante + ";" + nombre + ";" + "0" + ";" + "0" + ";" + 0.08);
                escritor.close();
                bufferEscritura.close();
                archivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para generar una factura de pago
    public static void generarFactura() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("deudas.txt"));
            String ci, nombre, materias = "", deuda, descuento;
            int carnetEstudiante;
            double totalDeuda = 0, descuentoAplicado = 0;
            System.out.print("Introduce el número de Carnet del estudiante: ");
            Scanner scanner = new Scanner(System.in);
            carnetEstudiante = scanner.nextInt();
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                ci = datos[0];
                nombre = datos[1];
                materias = datos[2];
                deuda = datos[3];
                descuento = datos[4];
                int carnet = Integer.parseInt(ci);
                if (carnet == carnetEstudiante) {
                    descuentoAplicado = 1;
                    totalDeuda += Double.parseDouble(deuda);
                    if (!datos[2].equals("0")) {
                        descuentoAplicado = Double.parseDouble(descuento);
                    }
                }
            }
            lector.close();
            if (descuentoAplicado == 0) {
                System.out.println("\nEstudiante no encontrado, inténtalo nuevamente.\n");
                generarFactura();
            } else {
                FileWriter archivo = new FileWriter("deudas.txt", true);
                BufferedWriter bufferEscritura = new BufferedWriter(archivo);
                PrintWriter escritor = new PrintWriter(bufferEscritura);
                int nit;
                String fecha;
                String nombreEstudiante = "";
                System.out.println("\nEstudiante encontrado: " + nombreEstudiante);
                System.out.println("Total de deuda: " + totalDeuda + "bs.");
                System.out.print("Introduce el NIT para facturar: ");
                nit = scanner.nextInt();
                System.out.print("Introduce la fecha de facturación: ");
                scanner.nextLine(); // Consumir el salto de línea
                fecha = scanner.nextLine();
                System.out.print("Introduce el monto a facturar: ");
                double monto = scanner.nextDouble();
                System.out.print("\nFactura generada exitosamente.");
                System.out.print("\n---------------------------------------------------------\n");
                System.out.print("\nFactura");
                System.out.print("\nFecha: " + fecha + "\n");
                System.out.print("\nNombre del estudiante: " + nombreEstudiante + "\t\tCarnet: " + carnetEstudiante + "\n");
                System.out.print("\n---------------------------------------------------------\n");
                System.out.print("Concepto\t\tSubtotal\n");
                System.out.print("Pago de " + materias + " materias\t" + monto + "\n");
                System.out.print("Descuento Bs: " + (monto * descuentoAplicado) + "\n");
                System.out.print("Total Bs: " + (monto - (totalDeuda * descuentoAplicado)) + "\n");
                System.out.print("Monto a pagar Bs: " + (monto - (totalDeuda * descuentoAplicado)) + "\n");

                escritor.println(carnetEstudiante + ";" + nombreEstudiante + ";" + "0" + ";" + -(monto - (totalDeuda * descuentoAplicado)) + ";" + 0);
                escritor.close();
                bufferEscritura.close();
                archivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Un método para generar un reporte del estado de cuenta del estudiante
    public static void generarReporte() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("deudas.txt"));
            String ci, nombre, materias, deuda, descuento;
            int carnetEstudiante;
            double totalDeuda = 0, descuentoAplicado = 0;
            System.out.print("Introduce el número de Carnet del estudiante: ");
            Scanner scanner = new Scanner(System.in);
            carnetEstudiante = scanner.nextInt();
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                ci = datos[0];
                nombre = datos[1];
                materias = datos[2];
                deuda = datos[3];
                descuento = datos[4];
                int carnet = Integer.parseInt(ci);
                if (carnet == carnetEstudiante) {
                    descuentoAplicado = 1;
                    totalDeuda += Double.parseDouble(deuda);
                    if (!datos[2].equals("0")) {
                        descuentoAplicado = Double.parseDouble(descuento);
                    }
                }
            }
            lector.close();
            if (descuentoAplicado == 0) {
                System.out.println("\nEstudiante no encontrado, inténtalo nuevamente.\n");
                generarReporte();
            } else {
                FileReader archivo = new FileReader("deudas.txt");
                BufferedReader bufferLectura = new BufferedReader(archivo);
                String nombreEstudiante = "";
                System.out.println("\nEstudiante encontrado: " + nombreEstudiante);
    
                System.out.print("\nReporte ");
                System.out.print("\nNombre del estudiante: " + nombreEstudiante + "\t\tCarnet: " + carnetEstudiante + "\n");
    
                while ((linea = bufferLectura.readLine()) != null) {
                    String[] datos = linea.split(";");
                    ci = datos[0];
                    nombre = datos[1];
                    materias = datos[2];
                    deuda = datos[3];
                    descuento = datos[4];
                    int carnet = Integer.parseInt(ci);
                    int cantidadMaterias = Integer.parseInt(materias);
                    double deudaTotal = Double.parseDouble(deuda);
                    double descuentoFinal = Double.parseDouble(descuento);
                    if (carnet == carnetEstudiante) {
                        System.out.print("Inscripción de " + materias + " materias" + deudaTotal + "Bs.\n");
                        nombreEstudiante = nombre;
                    }
                }
                System.out.print("Total Deuda Bs: " + (totalDeuda - (totalDeuda * descuentoAplicado)) + "\n");

                archivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1 : Agregar deuda por inscripción de materias. \n");
            System.out.print("2 : Aplicar descuento por pago anticipado. \n");
            System.out.print("3 : Generar factura. \n");
            System.out.print("4 : Mostrar reporte de estado de cuenta. \n");
            System.out.print("5 : Salir \n");
            System.out.print("Selección:  ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    escribirDatosEstudiante();
                    break;
                case 2:
                    aplicarDescuentoProntoPago();
                    break;
                case 3:
                    generarFactura();
                    break;
                case 4:
                    generarReporte();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.\n");
                    break;
            }
        }
    }
}
