import java.util.Scanner;
public class eje4 {
    String contrasena;
    String nueva_contrasena;
    int contador = 0;
    boolean numero = false;
    boolean simbolos = false;
    boolean minuscula = false;
    int contador_minusculas = 0;
    boolean mayuscula = false;
    
    public eje4(String contrasena) {
        this.contrasena = contrasena;
    }

    public void revisar_contrasena() {
        Scanner cin = new Scanner(System.in);
        
        while(true){
            if(getContrasena().length() < 10){
                System.out.println("No tiene la cantidad de letras necesaria... Pon otra contraseña");
            }
            else{
                contador++;
            }
            
            for(int i = 0; i < getContrasena().length();i++){
                char letra = getContrasena().charAt(i);
                if(numero == false && letra >= '0' && letra <= '9'){
                    contador++;
                    numero = true;
                } else if(simbolos == false && (letra == '%' || letra == '&' || letra == '$' || letra == '/' || letra == '*')){
                    contador++;
                    simbolos = true;
                } else if(mayuscula == false && letra >= 'A' && letra <= 'Z'){
                    contador++;
                    mayuscula = true;
                } else if(minuscula == false && letra >= 'a' && letra <= 'z'){
                    if(contador_minusculas <= 2){
                        contador_minusculas++;
                    }else{
                        contador++;
                        minuscula = true;
                    }
                }
            }
            if(contador == 5){
                System.out.print("La contraseña cumple con todo");
                break;
            }
            System.out.println(contador);
            System.out.print("Ingresa otra contraseña: ");
            nueva_contrasena = cin.next();
            setContrasena(nueva_contrasena);
            numero = false;
            simbolos = false;
            contador = 0;
            mayuscula = false;
            minuscula = false;
            
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}