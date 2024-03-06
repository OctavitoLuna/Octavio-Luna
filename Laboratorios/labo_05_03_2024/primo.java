public class primo{
    public int a;

    public int indentificar_primo(int a){
        for(int i = 2; i < a; i++){
            if(a % i == 0){
                return 0;
            }
        }
        return 1;
    }


    public void setNum1(int a){
        this.a = a;
    }
    public int getNum1(){    
        return a;
    }
}