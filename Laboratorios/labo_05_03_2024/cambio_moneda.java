public class cambio_moneda{
    public int a;
    public double opcion;
    public double dolar = 6.96;
    public double dolar_paralelo = 8.5;


    public double bo_do(double a, double opcion){
        double res;
        if(opcion == 1){
            res = a / dolar_paralelo;
        }
        else{
            res = a / dolar;
        }
        return res;
    }
    public double do_bo(double a, double opcion){
        double res;
        if(opcion == 1){
            res = a * dolar_paralelo;
        }
        else{
            res = a * dolar;
        }
        return res;
    }


    public void setNum1(int a){
        this.a = a;
    }
    public int getNum1(){    
        return a;
    }
}