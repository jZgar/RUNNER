import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Runner");
        Group root = new Group();
        primaryStage.setResizable(true);
        GameScene theScene = new GameScene(root, 600, 400);
        primaryStage.setScene(theScene);
//        (int) theScene.getBcgndL().getImV().getImage().getWidth();
       // long time = 5;
       // String heroDirectory = "D:\\ENSEA\\2A\\JAVA\\runner_docs\\heros.png";

// KEY PRESSED EVENT
        theScene.setOnKeyPressed((pressed) -> {
            System.out.println("KEYPRESSED");
            if(theScene.getHero().getEtat() == 0) {
                theScene.getHero().setEtat(1);
            }
        });

        theScene.lifeDisp();

// Running Hero Animation
        theScene.getHero().course(theScene.getHero().getTime());

        LongValue clong = new LongValue(System.nanoTime());

        AnimationTimer loop = new AnimationTimer() {
            @Override
            public void handle(long ref) {
                double now = (ref-clong.V)/5000000.0;
                System.out.println(now);
                if(now>theScene.getHero().getTime()) {
                    clong.V = ref;
    // Lives of the Hero
                    //theScene.lifeDisp();
    // The hero RUN
                    if (theScene.getHero().getEtat() == 0) {
                        System.out.println("COURSE");
                        theScene.getHero().update(now);
                    }
    // The hero JUMP
                    if(theScene.getHero().getEtat() == 1){
                        System.out.println("SAUT");
                        theScene.getHero().jump(now);
                    }
                    if(theScene.getHero().getEtat() == 2){
                        System.out.println("DESCENTE");
                        theScene.getHero().gravity(now);
                    }

    // The cam follow the hero
                    theScene.getCam().update(now);
                    theScene.update(now);

                    //theScene.createBcgnd(theScene.getBcgndL(), theScene.getCam().getX()%l, 0, l-theScene.getCam().getX()%l, 400, 0, 0);
                    //theScene.createBcgnd(theScene.getBcgndR(), 0, 0, theScene.getCam().getX()%l, 400, l-theScene.getCam().getX()%l/*+(theScene.getCam().getX()%l)*/, 0);


                }
            }
        };

// start the timer
        loop.start();

        root.getChildren().add(theScene.getBcgndL().getImV());
        root.getChildren().add(theScene.getBcgndR().getImV());
        root.getChildren().add(theScene.getHero().getImV());
        root.getChildren().add(theScene.getImVwNbOfL());
        primaryStage.setScene(theScene);
        primaryStage.show();

    }

    public static void main (String[] args) {

        launch(args);


    }
}
