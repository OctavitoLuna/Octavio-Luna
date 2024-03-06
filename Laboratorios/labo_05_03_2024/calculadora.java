public class calculadora{
    public int a;
    public int b;

    public calculadora(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int sumar(){
        return getNum1() + getNum2();
    }
    public int restar(){
        return getNum1() - getNum2();
    }
    public int multiplicar(){
        return getNum1() * getNum2();
    }
    public double dividir(){
        double res = 0;
        if(b != 0){
            res = getNum1() / getNum2();
        }
        else{
            res = 0;
        }
        return res;
        
    }





    public void setNum1(int a){
        this.a = a;
    }
    public int getNum1(){    
        return a;
    }
    public void setNum2(int b){
        this.b = b;
    }
    public int getNum2(){    
        return b;
    }
}