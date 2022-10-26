package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import uet.oop.bomberman.control.Menu;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Doll;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.entities.block.Portal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.*;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

import static java.awt.Color.PINK;
import static uet.oop.bomberman.control.Collision.checkCollisionWithFlame;
import static uet.oop.bomberman.control.Menu.author;
import static uet.oop.bomberman.graphics.LayoutGame.*;
import static uet.oop.bomberman.levels.NextLevel.*;

public class BombermanGame extends Application {
    public static Group root;
    public static Stage stage_;
    public static final int WidthView = 1140;
    public static boolean running;      // check if game is running
    private long timeLast;      // used to determine level's play time
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int width_ = 0;   // board's width
    public static int height_ = 0;  // board's height
    public static int level_ = 0;   // board's level
    public static Animal player;
    public static final List<Entity> block = new ArrayList<>(); // list of idle object
    public static List<Animal> enemy = new ArrayList<>(); // list of enemy

    public static Entity[][] object_ids; // store (x, y) coordinate of objects on game board
    public static String[][] killed_list; // store (x, y) coordinate of killed objects on game board

    public static Sound levelSound = new Sound();
    private GraphicsContext gc;
    private Canvas canvas;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Create Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        canvas.setTranslateY(40);
        // Create root container
        root = new Group();
        root.getChildren().addAll(canvas);
        Menu.creatMenu(root);


        // Create scene
        Scene scene = new Scene(root,1140,455, Color.LIGHTGRAY);

        // Input handling
        scene.setOnKeyPressed(event -> {
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
                switch (event.getCode()) {
                    case UP:
                        player.up = false;
                        player.setImg(Sprite.player_up.getFxImage());
                        break;
                    case DOWN:
                        player.down = false;
                        player.setImg(Sprite.player_down.getFxImage());
                        break;
                    case LEFT:
                        player.left = false;
                        player.setImg(Sprite.player_left.getFxImage());
                        break;
                    case RIGHT:
                        player.right = false;
                        player.setImg(Sprite.player_right.getFxImage());
                        break;
                   case SPACE:
                       Bomb.putBomb();
                        break;
                }
        });


        // Add scene to stage
        stage_ = stage;
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
                waitLevelToUp();
            }
        };
        timer.start();

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        timeLast = System.currentTimeMillis();
    }

    public void update() {
        for (int i = 0; i < block.size(); i++) {
            block.get(i).update();
        }
        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).update();
        }
        player.update();
        updateLayout();
        Move.checkRun(player, player.getDist());
        checkCollisionWithFlame();

        for (Animal a : enemy) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 2) {
                if(a instanceof Doll) {
                    Move.checkRun(a,4);
                } else Move.checkRun(a,2);
                a.setCountToRun(0);
            }
        }

        if(enemy.size() == 0 && !wait) {
            Entity portal = new Portal(WIDTH - 2,HEIGHT - 2,Sprite.portal.getFxImage());
            block.add(portal);
            if(player.getX() == portal.getX() && player.getY() == portal.getY()) {
                timeNumber += 3;
                wait = true;
                timeWait = System.currentTimeMillis();
                if(level_ == 1) {
                    imageLevelUp2.setImage(imageNext2);
                    imageLevelUp2.setX(0);
                    imageLevelUp2.setY(0);
                    root.getChildren().add(imageLevelUp2);
                    levelSound.stopBackground();
                    levelSound.playNextLevel();
                } else if(level_ == 2) {
                    imageLevelUp3.setImage(imageNext3);
                    imageLevelUp3.setX(0);
                    imageLevelUp3.setY(0);
                    root.getChildren().add(imageLevelUp3);
                    levelSound.stopBackground();
                    levelSound.playNextLevel();
                } else if(level_ == 3) {
                    imageLevelUp1.setImage(endGame);
                    imageLevelUp1.setX(0);
                    imageLevelUp1.setY(0);
                    root.getChildren().add(imageLevelUp1);
                    levelSound.stopBackground();
                    levelSound.playWinTitle();
                }
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
            if(timeNumber <= 0)
            {
                heart = 0;
                player.setLife(false);
            }
        }
    }
}
