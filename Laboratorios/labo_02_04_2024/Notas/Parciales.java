
public class Parciales implements OperacionesParciales {
    double par1_n, par2_n;
    
    public Parciales(double par1_n, double par2_n){
        this.par1_n = par1_n;
        this.par2_n = par2_n;
    }

    public double getPar1() {
        return par1_n;
    }
    public void setPar1(double par1_n) {
        this.par1_n = par1_n;
    }
    public double getPar2() {
        return par2_n;
    }
    public void setPar2(double par2_n) {
        this.par2_n = par2_n;
    }

    @Override
    public double par1(double par1_n){
        return par1_n;
    }
    
    @Override
    public double par2(double par2_n){
        return par2_n;
    }
}
