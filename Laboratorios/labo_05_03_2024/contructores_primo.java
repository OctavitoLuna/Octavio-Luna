public class contructores_primo{
    public int a;

    public contructores_primo(int a){
        this.a = a;
    }
    public int indentificar_primo(){
        for(int i = 2; i < getNum1(); i++){
            if(getNum1() % i == 0){
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