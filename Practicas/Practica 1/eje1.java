import java.util.Scanner;

public class eje1 {
    public static int verificar(String texto) {
        if (texto.equals("")) {
            return 0;
        }
        return 1;
    }

    public static int contarVocales(String texto) {
        int contador = 0;
        if (verificar(texto) == 1) {
            for (char letra : texto.toLowerCase().toCharArray()) {
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    contador++;
                }
            }
            return contador;
        } else {
            System.out.println("No introdujo una palabra");
            return 0;
        }
    }

    public static int contarConsonantes(String texto) {
        int contador = 0;
        if (verificar(texto) == 1) {
            for (char letra : texto.toLowerCase().toCharArray()) {
                if (letra >= 'a' && letra <= 'z' && letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                    contador++;
                }
            }
            return contador;
        } else {
            System.out.println("No introdujo una palabra");
            return 0;
        }
    }

    public static int encontrarPalabra(String texto, String palabraBuscada) {
        int contador = 0, flag = 0, finalPosicion = 0;

        if (verificar(texto) == 1) {
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == palabraBuscada.charAt(0)) {
                    flag = 1;
                    for (int j = 0; j < palabraBuscada.length(); j++) {
                        if (texto.charAt(i + j) != palabraBuscada.charAt(j)) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        finalPosicion = i;
                        break;
                    }
                }
                contador++;
            }
            if (flag == 1) {
                System.out.println("La palabra buscada se encuentra en el texto. Empieza en la letra: " + (finalPosicion + 1) + ". Y el texto es: " + texto);
                return 1;
            } else {
                System.out.println("La palabra no está en el texto...");
                return 0;
            }
        } else {
            System.out.println("No introdujo una palabra");
            return 0;
        }
    }

    public static String reemplazarPalabra(String texto) {
        if (verificar(texto) == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Escribe la palabra a reemplazar: ");
            String palabraBuscada = scanner.nextLine();
            System.out.print("Escribe la palabra nueva: ");
            String reemplazo = scanner.nextLine();
            scanner.close();

            String textoModificado = texto.replace(palabraBuscada, reemplazo);

            if (!textoModificado.equals(texto)) {
                System.out.println("La palabra fue reemplazada exitosamente en el texto.");
                System.out.println("El texto modificado es: " + textoModificado);
                return textoModificado;
            } else {
                System.out.println("La palabra no fue encontrada en el texto.");
                return texto;
            }

        } else {
            System.out.println("No introdujo una palabra");
            return "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        String texto = "hola mundo";
        while (true) {
            System.out.println("Escoger una opcion:\n1)Ingresar texto\n2)Contar vocales\n3)Contar consonantes\n4)Encontrar una palabra en el texto\n5)Reemplazar una palabra por otra palabra\n6)Salir\nRespuesta: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.next();
                continue;
            }
            n = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter de nueva línea
            switch (n) {
                case 1:
                    System.out.print("Usted ha seleccionado la opción 1\nIngresar el texto: ");
                    texto = scanner.nextLine(); // Usar nextLine() para leer una línea completa
                    break;
                case 2:
                    System.out.println("Usted ha seleccionado la opción 2\nNumero de vocales: " + contarVocales(texto));
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado la opción 3\nNumero de consonantes: " + contarConsonantes(texto));
                    break;
                case 4:
                    System.out.print("Usted ha seleccionado la opción 4\nEscribir la palabra que esta buscando: ");
                    String palabraBuscada = scanner.next();
                    encontrarPalabra(texto, palabraBuscada);
                    break;
                case 5:
                    System.out.println("Usted ha seleccionado la opción 5\n" + reemplazarPalabra(texto));
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Usted ha ingresado una opción incorrecta");
            }
            System.out.println("\n\n\n\n\n");
        }
    }
}
