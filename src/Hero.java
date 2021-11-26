import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {
    private double g = 6;
    private double vX = 2;
    private double vY = -4;
    private double aX;
    private double aY;


    Hero(double x, double y, String fileDirectory, int etat, int index, long time, int maxIndex, int[] windowSize, int offSet) {

        super(x, y, fileDirectory, etat, index, time, maxIndex, windowSize, offSet);

        super.imV.setViewport(new Rectangle2D(offSet, 0, windowSize[0], windowSize[1]));
        super.imV.setX(100);
        super.imV.setY(super.y);
    }

    @Override
    public double getY() {
        return super.y;
    }

    @Override
    public double getX() {
        return super.x;
    }

    @Override
    public ImageView getImV() {
        return super.getImV();
    }

    public long getTime(){
        return this.time;
    }

    public void setImV(Image image) {
        this.imV = new ImageView(image);
    }

    public void course(long present) {
        LongValue clong = new LongValue(System.nanoTime());
        AnimationTimer anime = new AnimationTimer() {
            @Override
            public void handle(long wsh) {
                double present = (wsh-clong.V)/1000000000.0;
                if(present>0.07) {
                    clong.V = wsh;
                switch (etat){
                    case 0:
                            imV.setViewport(new Rectangle2D(offSet + (windowSize[0]) * index, 0, windowSize[0], windowSize[1]));
                            index++;
                            if (index == 6) {
                                index = 0;
                            }
                            break;
                    case 1:
                            imV.setViewport(new Rectangle2D(offSet, 165, windowSize[0], windowSize[1]));
                            break;
                    case 2:
                            imV.setViewport(new Rectangle2D(offSet + windowSize[0], 165, windowSize[0], windowSize[1]));
                            break;
                        }
                }
                //System.out.println(now);

            }

        };
        anime.start();

    }

    @Override
    public void update(double l) {
        this.x = this.x + vX*l;
        this.y = 250;
        this.imV.setY(this.y);
    }

    public void jump(double l){
        this.x += vX*l;
        this.imV.setY(this.y);
        this.y += vY*l;

        if(this.y < 60){
            this.etat = 2;

        }
    }

    public void gravity(double l){
        this.x += vX*l;
        this.y += g*l*l/25;
        this.imV.setY(this.y);
        if(this.y >= 250){
            this.etat = 0;
        }

    }
}
