import java.util.Scanner;
public class eje3 {
    String entrada;
    String salida;
    int retrazo_entrada;
    int retrazo_salida;

    
    public eje3(String entrada, String salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    public void atrasos() {
        String[] partes_entrada = getEntrada().split(":");
        String[] partes_salida = getSalida().split(":");
    
        int hora_entrada = Integer.parseInt(partes_entrada[0]);
        int minuto_entrada = Integer.parseInt(partes_entrada[1]);
        int hora_salida = Integer.parseInt(partes_salida[0]);
        int minuto_salida = Integer.parseInt(partes_salida[1]);
        
        if(minuto_entrada > 30 || hora_entrada > 8){
            if(hora_entrada > 8){
                retrazo_entrada = (hora_entrada - 8) * 60;
                retrazo_entrada = retrazo_entrada + minuto_entrada;
            }
            else{
                retrazo_entrada = minuto_entrada;
            }
        }
        
        if(hora_salida < 16){
            if(hora_salida == 15){
                retrazo_salida = 60 - minuto_salida;
            }
            else{
                retrazo_salida = ((15 - hora_salida) * 60) + (60 - minuto_salida); 
            }
            
        }
        
        
        if((retrazo_salida + retrazo_entrada) > 0){
            System.out.print("los dias que se le restan a su paga son: " + (retrazo_salida + retrazo_entrada));    
        }
        else{
            System.out.print("No debe ningun dia...");
        }
        
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

}