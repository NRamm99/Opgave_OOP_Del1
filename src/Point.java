public class Point {
    private double x;
    private double y;
    private int id;

    public Point (double x, double y, int id){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public int getId(){
        return id;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void moveX(double x){
        this.x += x;
    }

    public void moveY(double y){
        this.y += y;
    }

    public void move(double k, double j){
        this.x += k;
        this.y += j;
    }
}
