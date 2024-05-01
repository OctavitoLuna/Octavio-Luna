public class Parale extends Cua{
    private double h;
    public Parale(double x, double y, double h){
        super(y, x);
        this.h = h;
    }
    public double getH() {
        return h;
    }
    public void setH(double h) {
        this.h = h;
    }
    @Override
    public double Superficie(){
        return super.Superficie();
    }

    public double Volumen(){
        double res = getH()*x*y;
        return res;
    }

}
