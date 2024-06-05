
import javax.swing.JOptionPane;

public class NotaAplicacion {
    public static void main(String[] args) {
        String par1Str = JOptionPane.showInputDialog("Ingresa la nota del primer parcial:");
        double par1 = Double.parseDouble(par1Str);
        
        String par2Str = JOptionPane.showInputDialog("Ingresa la nota del segundo parcial:");
        double par2 = Double.parseDouble(par2Str);
        
        String tFinalStr = JOptionPane.showInputDialog("Ingresa la nota del trabajo final:");
        double t_final = Double.parseDouble(tFinalStr);
        
        T t = new T(par1, par2, t_final);
        String resultado = t.Res();
        
        JOptionPane.showMessageDialog(null, resultado);
    }    
}
