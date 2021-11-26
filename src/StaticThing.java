import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class StaticThing {
    /* -- On fixe la position du StaticThing -- */
    private double x, y;
    private ImageView imV;

    StaticThing(double x, double y, String fileName) {
        this.x = x;
        this.y = y;
        Image im = new Image(fileName);
        this.imV = new ImageView(im);
        this.imV.setX(this.x);
        this.imV.setY(this.y);
    }

    public ImageView getImV() {
        return imV;
    }
}
