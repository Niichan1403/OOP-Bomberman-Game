package uet.oop.bomberman.levels;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.sound.Sound;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.author;
import static uet.oop.bomberman.control.Menu.timeWaitLevel1;

public class NextLevel {
    public static Sound nextLevelSound = new Sound();
    public static boolean flag = false;
    public static boolean wait;
    public static long timeWait;
    public static ImageView imageLevelUp = new ImageView();

    public static void waitLevelToUp() {
        Image imageNext = new Image("images/transparent.png");
        if(wait) {
            long now = System.currentTimeMillis();
            if(now - timeWait >= 3000) {
                imageLevelUp.setImage(imageNext);
                switch (level_) {
                    case 1:
                        new Level2(root);
                        break;
                    default:
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
