import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        int numAlumnos = EntradaEntero("Ingrese la cantidad de alumnos en el curso ");
        int pCurso = EntradaEntero("Ingrese el paralelo del curso ");
        String nomCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso ");

        String siglaMateria = JOptionPane.showInputDialog("Ingrese la sigla de la materia ");
        Curso curso = new Curso(nomCurso, numAlumnos, pCurso, siglaMateria);
        String nombreEstudiante;
        
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        
        for (int i=0;i<numAlumnos;i++){
            nombreEstudiante=JOptionPane.showInputDialog("Ingrese el nombre del estudiante "+(i+1));
            Estudiante estudiante = new Estudiante(nombreEstudiante);
            estudiantes.add(estudiante);
        }
        curso.setEstudiantes(estudiantes);
        curso.MostrarEstudiantes();
    }

    public static int EntradaEntero(String mensaje){
        
        int num=0;
        while(true){
            try{
                num=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return num;
            
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingrese valores enteros");
            }
        }
    }
}
