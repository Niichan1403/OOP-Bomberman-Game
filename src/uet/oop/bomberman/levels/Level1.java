package uet.oop.bomberman.levels;


import javafx.scene.Group;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.LayoutGame;

import static uet.oop.bomberman.BombermanGame.level_;
import static uet.oop.bomberman.BombermanGame.player;
import static uet.oop.bomberman.entities.animal.Bomber.frameKill;
import static uet.oop.bomberman.entities.animal.Bomber.swapKill;
import static uet.oop.bomberman.graphics.LayoutGame.timeNumber;

public class Level1 {
    public Level1(Group root) {
        level_ = 1;
        new CreateMap("res/levels/level1.txt");
        LayoutGame.createLayout(root);
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        player.setImg(Sprite.player_right_2.getFxImage());
        timeNumber = 120;
        frameKill = 0;
        swapKill = 1;
    }
}
