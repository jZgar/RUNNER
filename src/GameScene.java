import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameScene extends Scene {
    private Camera camera;
    private StaticThing bcgndL, bcgndR;
    private Hero hero;
    private int nbOfLives;
    private ImageView imVwNbOfL;
    private ArrayList<Foe> foes;


    GameScene(Parent parent, int x, int y) {
        super(parent, x, y);

        int[] windowSize = {85, 100};
        int offset = 3;
        this.bcgndL = new StaticThing(0, 0, "desert.png");
        //(int) this.bcgndL.getImV().getImage().getWidth();
        int l = 800;
        this.bcgndR = new StaticThing(l, 0, "desert.png");
        this.hero = new Hero(100, 0, "heros.png", 0, 0, 5, 6, windowSize, 3);
        this.camera = new Camera(0, 0, this.hero);
        this.camera.setX(0);
        this.camera.setY(0);

        this.nbOfLives = 3;
        this.imVwNbOfL = new ImageView(new Image("heart_nb_of_lives.png"));

    }

    public void setHero(double x, double y, String fileDirectory, int etat, int index, long time, int maxIndex, int[] windowSize, int offSet){
        this.hero = new Hero( x, y, fileDirectory, etat, index, time, maxIndex, windowSize, offSet);
    }

    public Hero getHero() {

        return hero;
    }

    public void setNbOfLives(int nbOfLives) {
        this.nbOfLives = nbOfLives;
    }

    public ImageView getImVwNbOfL() {
        return imVwNbOfL;
    }

    public void lifeDisp() {
            switch (this.nbOfLives){
                case 0:
                    System.out.println("GAME OVER");
                    this.imVwNbOfL = new ImageView(new Image("GAME_OVER.png"));
                    this.imVwNbOfL.setViewport(new Rectangle2D(126, 40, 600, 400));
                    this.imVwNbOfL.setX(0);
                    this.imVwNbOfL.setY(0);
                    break;
                case 1:
                    imVwNbOfL.setViewport(new Rectangle2D(6, 184, 49, 50));
                    this.imVwNbOfL.setX(10);
                    this.imVwNbOfL.setY(10);
                    break;
                case 2:
                    imVwNbOfL.setViewport(new Rectangle2D(6, 184, 99, 50));
                    this.imVwNbOfL.setX(10);
                    this.imVwNbOfL.setY(10);
                    break;
                case 3:
                    imVwNbOfL.setViewport(new Rectangle2D(6, 184, 148, 50));
                    this.imVwNbOfL.setX(10);
                    this.imVwNbOfL.setY(10);
                    break;

            }
        }

    public StaticThing getBcgndL() {

        return bcgndL;
    }

    public StaticThing getBcgndR() {

        return bcgndR;
    }

    public void createBcgnd(StaticThing b, double xPos, double yPos, double largeur, double hauteur, double X, double Y){
        b.getImV().setViewport(new Rectangle2D(xPos, yPos, largeur, hauteur));
        b.getImV().setX(X);
        b.getImV().setY(Y);
    }

    public Camera getCam() {
        return camera;
    }

    public void setCam(Camera camera) {
        this.camera = camera;
    }

    public void update(double time){
//(int) this.getBcgndL().getImV().getImage().getWidth();
        double l = 800;
        this.createBcgnd(this.getBcgndL(), this.camera.getX()%l, 0, l, 400, 0, 0);
        this.createBcgnd(this.getBcgndR(),  0, 0, l, 400, l-this.camera.getX()%l, 0);

        }
    }


