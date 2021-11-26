import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract class AnimatedThing {
    protected double x, y;
    protected ImageView imV;
    protected int etat;
    protected int index;
    protected long time;
    protected int maxIndex;
    protected int[] windowSize;
    protected int offSet;

    AnimatedThing(double x, double y, String fileDirectory, int etat, int index, long time, int maxIndex, int[] windowSize, int offSet){
        this.x = x;
        this.y = y;
        Image im = new Image(fileDirectory);
        this.imV = new ImageView(im);
        this.etat = etat;
        this.index = index;
        this.maxIndex = maxIndex;
        this.time = time;
        this.windowSize = windowSize;
        this.offSet = offSet;

    }

    public ImageView getImV(){
        return this.imV;
    }

    abstract public double getX();
    abstract public double getY();

    public abstract void update(double l);

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
