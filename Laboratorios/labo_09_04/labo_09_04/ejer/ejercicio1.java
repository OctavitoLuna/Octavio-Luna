package labo_09_04.ejer;
import javax.swing.JOptionPane;
public class ejercicio1 {
    public static void main(String[] args) {
        int[] numero = {10, 12, 93};
        mostrar(numero, 10);

    }
    public static void mostrar(int[] vector, int n) throws ArrayIndexOutOfBoundsException{
        int t = 2;
        if(n > t){
            throw new ArrayIndexOutOfBoundsException("No existe la posicion " + n);
        }        
        System.out.println(vector[n]);
    }
}
