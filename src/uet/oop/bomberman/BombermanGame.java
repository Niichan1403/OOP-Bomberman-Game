package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.block.Grass;
import uet.oop.bomberman.entities.block.Wall;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class BombermanGame extends Application {
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int width_ = 0;
    public static int height_ = 0;
    public static int level_ = 1;
    public Animal player;
    public static final List<Entity> block = new ArrayList<>();
    public static List<Entity> enemy = new ArrayList<>();

    public static String[][] object_ids;

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

        // Create root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Create scene
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            if (true)
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
//                    case SPACE:
//                        Bomb.putBomb();
//                        break;
                }
        });

        scene.setOnKeyReleased(event -> {
            if (true)
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
//                    case SPACE:
//                        Bomb.putBomb();
//                        break;
                }
        });


        // Add scene to stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        new CreateMap("res/levels/level1.txt");

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
    }

    public void update() {
        block.forEach(Entity::update);
        enemy.forEach(Entity::update);
        player.update();

        Move.checkRun(player);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        player.render(gc);
    }
}
