import java.util.ArrayList;
import java.util.List;

public class eje1 {
    public String palabra;
    public List<Character> contar_letras_char = new ArrayList<>();
    public List<Integer> contar_letras = new ArrayList<>();
    public Boolean iniciar = false;
    public Boolean repetidos = false;
    public int posicion = 0;

    public eje1(String palabra) {
        this.palabra = palabra;

    }

    public void contar_palabras() {
        for (int i = 0; i < getPalabra().length(); i++) {
            char letra = getPalabra().charAt(i);
            if (iniciar == false) {
                contar_letras_char.add(letra);
                contar_letras.add(1);
                iniciar = true;
            } else {
                for (int j = 0; j < contar_letras_char.size(); j++) {
                    char letra_lista = contar_letras_char.get(j);
                    if (letra == letra_lista) {
                        posicion = j;
                        repetidos = true;
                        break;
                    }
                    // System.out.println(contar_letras_char.get(j));
                }
                if (repetidos == true) {
                    contar_letras.set(posicion, contar_letras.get(posicion) + 1);
                    repetidos = false;
                } else {
                    contar_letras_char.add(letra);
                    contar_letras.add(1);
                }
            }

        }

        for (int k = 0; k < contar_letras_char.size(); k++) {
            System.out.println(contar_letras_char.get(k) + ": " + contar_letras.get(k));
        }
        System.out.println("Total: " + getPalabra().length());

    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

}