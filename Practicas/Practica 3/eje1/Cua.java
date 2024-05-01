public class Cua {
    protected double x, y;

    public Cua(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double Superficie(){
        double res = getX()*getY();
        return res;
    }
}
