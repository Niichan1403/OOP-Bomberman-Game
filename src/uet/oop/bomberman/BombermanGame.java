package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import uet.oop.bomberman.control.Menu;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.entities.block.Grass;
import uet.oop.bomberman.entities.block.Wall;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static uet.oop.bomberman.graphics.LayoutGame.runTime;
import static uet.oop.bomberman.graphics.LayoutGame.timeNumber;

public class BombermanGame extends Application {
    public static Image authorImage;
    public static final int WidthView = 1140;
    public static boolean running;      // check if game is running
    private long timeLast;
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int width_ = 0;   // board's width
    public static int height_ = 0;  // board's height
    public static int level_ = 1;   // board's level
    public static Animal player;
    public static final List<Entity> block = new ArrayList<>(); // list of idle object
    public static List<Animal> enemy = new ArrayList<>(); // list of enemy

    public static Entity[][] object_ids; // store (x, y) coordinate of objects on game board
    public static String[][] killed_list; // store (x, y) coordinate of killed objects on game board

    private GraphicsContext gc;
    private Canvas canvas;
    public static ImageView author;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Create Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        canvas.setTranslateY(40);
        authorImage = new Image("images/menu0.png");
        author = new ImageView(authorImage);
        author.setX(0);
        author.setY(0);
        // Create root container
        Group root = new Group();
        root.getChildren().addAll(canvas,author);
        Menu.creatMenu(root);


        // Create scene
        Scene scene = new Scene(root,1140,455);

        // Input handling
        scene.setOnKeyPressed(event -> {
//            if (player.isLife())
                switch (event.getCode()) {
                    case UP:
                        player.up = true;
                        break;
                    case DOWN:
                        player.down = true;
                        break;
                    case LEFT:
                        player.left = true;
                        break;
                    case RIGHT:
                        player.right = true;
                        break;
                    case SPACE:
                        Bomb.putBomb();
                        break;
                }
        });

        scene.setOnKeyReleased(event -> {
//            if (player.isLife())
                switch (event.getCode()) {
                    case UP:
                        player.up = false;
                        break;
                    case DOWN:
                        player.down = false;
                        break;
                    case LEFT:
                        player.left = false;
                        break;
                    case RIGHT:
                        player.right = false;
                        break;
                    case SPACE:
                        Bomb.putBomb();
                        break;
                }
        });


        // Add scene to stage
        Image logo = new Image("images/logo.png");
        stage.getIcons().add(logo);
        stage.setTitle("Bomberman Game");
        stage.setScene(scene);
        stage.show();

        // Game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(running) {
                    update();
                    render();
                    time();
                }
            }
        };
        timer.start();

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        timeLast = System.currentTimeMillis();
    }

    public void update() {
        block.forEach(Entity::update);
        enemy.forEach(Entity::update);
        player.update();

        Move.checkRun(player, player.getDist());

        for (Animal a : enemy) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                Move.checkRun(a,4);
                a.setCountToRun(0);
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        player.render(gc);
    }

    public void time() {
        long now = System.currentTimeMillis();
        if(now - timeLast >= 1000) {
            timeLast = System.currentTimeMillis();
            runTime.setText("Times: " + timeNumber);
            timeNumber--;
            if(timeNumber < 0)
            {
                player.setLife(false);
            }
        }
    }
}
