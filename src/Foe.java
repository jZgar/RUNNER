import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Foe extends AnimatedThing{
    private double vX = -2;

    Foe(double x, double y, String fileDirectory, int etat, int index, long time, int maxIndex, int[] windowSize, int offSet){
        super(x, y, fileDirectory, etat, index, time, maxIndex, windowSize, offSet);
        super.imV = new ImageView(new Image("radioactiv_barrel"));


    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void update(double l) {
        this.x += vX*l;
        this.imV.setViewport(new Rectangle2D(0, 0, 150, 200));
    }
}
