package uet.oop.bomberman.levels;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static uet.oop.bomberman.BombermanGame.root;

public class NextLevel {
    public static boolean wait;
    public static long timeWait;

    public static void waitLevelToUp() {
        if(wait) {
            Image levelUpImage = new Image("images/menu.png");
            ImageView levelUp = new ImageView(levelUpImage);
            root.getChildren().add(levelUp);

        }
    }
}
