package uet.oop.bomberman.levels;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.sound.Sound;

import static uet.oop.bomberman.BombermanGame.root;

public class NextLevel {
    public static Sound nextLevelSound = new Sound();
    public static boolean flag = false;
    public static boolean wait;
    public static long timeWait;

    public static void waitLevelToUp() {
        if(wait) {
            Image levelUpImage = new Image("images/menu.png");
            ImageView levelUp = new ImageView(levelUpImage);
            root.getChildren().add(levelUp);
            if (!flag) {
//                nextLevelSound.playLevelComplete();
                flag = true;
            }
        }
    }
}
