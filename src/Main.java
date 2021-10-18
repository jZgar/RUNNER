import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 800, 400,true);
        primaryStage.setScene(theScene);

        Image spriteSheet = new Image("D:\\ENSEA\\2A\\JAVA\\runner_docs\\desert.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);

        primaryStage.show();


    }

    public static void main (String[] args) {
        launch(args);
    }
}
