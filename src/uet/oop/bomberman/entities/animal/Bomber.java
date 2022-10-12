package uet.oop.bomberman.entities.animal;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Collision.checkCollisionWithEnemy;
import static uet.oop.bomberman.control.Menu.*;
import static uet.oop.bomberman.graphics.LayoutGame.*;

public class Bomber extends Animal {

    public static int frameKill = 0;
    public static int swapKill = 1;
    public Bomber() {}
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public Bomber(int dist, int swap, String direction) {
        super(dist, swap, direction);
    }

    private void killBomber() {
        if(frameKill % 15 == 0) {
            if(swapKill == 1) {
                player.setImg(Sprite.player_dead1.getFxImage());
            }
            else if(swapKill == 2) {
                player.setImg(Sprite.player_dead2.getFxImage());
            }
            else if(swapKill == 3) {
                player.setImg(Sprite.player_dead3.getFxImage());
            }
            else if(swapKill == 4) {
                Image playerDead = new Image("images/transparent.png");
                player.setImg(playerDead);
            }
            else {
                if(heart > 0) {
                    if(timeNumber < 0) {
                        running = false;
                        heart = 0;
                        enemy.clear();
                        creatMenu(root);
                        return;
                    }
                    else {
                        swapKill = 1;
                        player.setX(32);
                        player.setY(32);
                        player.setLife(true);
                        player.setImg(Sprite.player_right_2.getFxImage());
                    }
                } else {
                    running = false;
                    heart = 0;
                    enemy.clear();
                    creatMenu(root);
                }
            }
            swapKill++;
        }
    }

    @Override
    public void update() {
        checkCollisionWithEnemy();
        if(!player.isLife()) {
            frameKill++;
            killBomber();
        }
    }
}
