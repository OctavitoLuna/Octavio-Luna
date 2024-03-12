import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class eje2 {
    public int n;
    public List<String> nombres_lista = new ArrayList<>();
    public List<Integer> amarillas_lista = new ArrayList<>();
    public List<Integer> rojas_lista = new ArrayList<>();
    public List<Integer> goles_lista = new ArrayList<>();
    public int mayor_expulsiones = 0;
    public int menor_amarillas = 1000;
    public int mayor_faltas = 0;
    public int mayor_faltas_posicion = 0;
    public int total_goles = 0;
    public int promedio_goles = 0;
    
    public eje2(int n) {
        this.n = n;
    }

    public void agregar() {
        String nombre;
        int amarilla;
        int roja;
        int goles;
        
        Scanner cin = new Scanner(System.in);
        for(int i = 0; i < getN(); i++){
            System.out.print("---------------------------\n");
            System.out.print("Numero: " + (i+1) + "\n");
            System.out.print("Nombre: ");
            nombre = cin.next();
            nombres_lista.add(nombre);
            System.out.print("Numero de amarillas: ");
            amarilla = cin.nextInt();
            amarillas_lista.add(amarilla);
            System.out.print("Numero de rojas: ");
            roja = cin.nextInt();
            rojas_lista.add(roja);
            System.out.print("Numero de goles: ");
            goles = cin.nextInt();
            goles_lista.add(goles);
            System.out.print("---------------------------");
        }
    }
    
public void mostrar() {
    System.out.println("Listado de jugadores:");
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("Nombre" + "\t\t      " + "Amarillas" + "\t\t      " + "Rojos" + "\t\t      " + "Goles" + "\n");
    for (int i = 0; i < nombres_lista.size(); i++) {
        if (mayor_expulsiones <= rojas_lista.get(i)) {
            mayor_expulsiones = i;
        }
        if (menor_amarillas >= amarillas_lista.get(i)) {
            menor_amarillas = i;
        }
        if (mayor_faltas <= (rojas_lista.get(i) + amarillas_lista.get(i))) {
            mayor_faltas = rojas_lista.get(i) + amarillas_lista.get(i);
            mayor_faltas_posicion = i;
        }
        total_goles += goles_lista.get(i);
        System.out.println(nombres_lista.get(i) + "\t\t\t" + amarillas_lista.get(i) + "\t\t\t" + rojas_lista.get(i) + "\t\t\t" + goles_lista.get(i));
    }
    promedio_goles = total_goles / nombres_lista.size();
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("Mayor numero de expulsiones: " + nombres_lista.get(mayor_expulsiones) + " - " + rojas_lista.get(mayor_expulsiones));
    System.out.println("Menor numero de amarillas: " + nombres_lista.get(menor_amarillas) + " - " + amarillas_lista.get(menor_amarillas));
    System.out.println("Mayor numero de faltas: " + nombres_lista.get(mayor_faltas_posicion) + " - " + mayor_faltas);
    System.out.println("Total de goles: " + total_goles);
    System.out.println("Promedio de goles: " + promedio_goles);
}

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}