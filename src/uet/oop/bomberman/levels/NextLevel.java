package uet.oop.bomberman.levels;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.sound.Sound;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.*;
import static uet.oop.bomberman.control.Menu2.setCheckCreateMenu2;
import static uet.oop.bomberman.graphics.LayoutGame.coin;
import static uet.oop.bomberman.graphics.LayoutGame.heart;

public class NextLevel {
    public static Sound nextLevelSound = new Sound();
    public static boolean flag = false;
    public static boolean wait;
    public static long timeWait;
    public static ImageView imageLevelUp2 = new ImageView();
    public static ImageView imageLevelUp3 = new ImageView();
    public static ImageView imageLevelUp1 = new ImageView();
    public static Image imageNext2 = new Image("images/nextLevel2.png");
    public static Image imageNext3 = new Image("images/nextLevel3.png");
    public static Image endGame = new Image("images/endGame.png");


    public static void waitLevelToUp() {
        Image imageNext = new Image("images/transparent.png");
        if(wait) {
            long now = System.currentTimeMillis();
            if(now - timeWait >= 3000) {
                switch (level_) {
                    case 1:
                        imageLevelUp2.setImage(imageNext);
                        new Level2(root);
                        break;
                    case 2:
                        imageLevelUp3.setImage(imageNext);
                        new Level3(root);
                        break;
                    case 3:
                        imageLevelUp1.setImage(imageNext);
                        new Level1(root);
                        break;
                }
                wait = false;
            }
        } else if(level_ == 0 && timeWaitLevel1 > 0) {
            long now = System.currentTimeMillis();
            if(now - timeWaitLevel1>=3000) {
                author.setX(-1000);
                author.setY(-1000);
                new Level1(root);
                running = true;
            }
        }
    }
}
