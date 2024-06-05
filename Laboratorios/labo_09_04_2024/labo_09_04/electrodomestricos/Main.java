package labo_09_04.electrodomestricos;

import javax.swing.JOptionPane;

public class Main {

    public double precio = 100;
    public String color = "blanco";
    public char consumo = 'F';
    public double peso = 5;

    public Main(double precio, String color, char consumo, double peso){
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }
    

    //public abstract String Sonido ();


    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public char getConsumo() {
        return consumo;
    }
    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    

    public double ConsumoEnergetico(char letra){
        char f = 'F';
        int verificador = 0;
        int contador = 0;
        double[] lista_precios = {100, 80, 60, 50, 30, 10};
        for(char a = 'A'; letra <= f; a++){
            
            if (letra == a) {
                
                JOptionPane.showMessageDialog(null, "Comprobacion existosa");
                //letra = a;

                verificador = 1;
                double res = lista_precios[contador];
                return res;
            }
            verificador = 0;
            contador++;
        }
        if(verificador == 0){
            throw new ClassCastException("no existe");
            JOptionPane.showMessageDialog(null, "Comprobacion fallida");
        }
    }
    public void ComprobarColor(String color){
        String[] lista_color = {"blanco", "negro", "rojo", "azul", "gris"};
        int verificador = 0;
        for(int i = 0; i < 5; i++){
            if(color == lista_color[i]){
                JOptionPane.showMessageDialog(null, "Comprobacion existosa");
                //color = lista_color[i];
                verificador = 1;
                break;
            }
            verificador = 0;

        }
        if(verificador == 0){
            throw new ClassCastException("no existe");
            JOptionPane.showMessageDialog(null, "Comprobacion fallida");
        }
    }

    public double PrecioFinal(double ConsumoEnergetico, double peso){
        double precio =+ ConsumoEnergetico;
        if(peso < 0){
            precio = 5;
        }
        else if(peso >= 0 && peso <= 19){
            precio += 10;
        }
        else if(peso >= 20 && peso <= 49){
            precio += 50;
        }
        else if(peso >= 50 && peso <= 79){
            precio += 80;
        }
        else{
            precio += 100;
        }

        return precio;
    }



