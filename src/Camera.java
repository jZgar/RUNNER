public class Camera {
    private double x;
    private double y;
    private Hero hero;

    Camera(int x, int y, Hero h) {
        this.hero = h;
        this.x = (int) this.hero.getX()-3;
        this.y = (int) this.hero.getY()-250;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }

    public void update(double l){
        double kM = 0.001;
        double fM = 0.0002;
        this.x += ((kM*l*l*this.hero.getX())/(1 + kM*l*l - fM*l));
        //System.out.println(this.x);
        this.x = (int) this.hero.getX()-3;
        //this.y = this.hero.getY()-250;

    }


}