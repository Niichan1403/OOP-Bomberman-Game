package uet.oop.bomberman.levels;

import javafx.scene.Group;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.level_;
import static uet.oop.bomberman.BombermanGame.player;
import static uet.oop.bomberman.entities.animal.Bomber.frameKill;
import static uet.oop.bomberman.entities.animal.Bomber.swapKill;
import static uet.oop.bomberman.graphics.LayoutGame.*;
import static uet.oop.bomberman.graphics.LayoutGame.enemy2Number;

public class Level3 {
    public Level3(Group root) {
        level_ = 3;
        new CreateMap("res/levels/level2.txt");
        player.setX(32);
        player.setY(32);
        player.setImg(Sprite.player_right.getFxImage());
        player.setDist(1);
        timeNumber = 150;

        frameKill = 0;
        swapKill = 1;
        boom = 20;
        enemy1Number  = 4;
        enemy2Number = 3;

        Bomb.powerDirUp = 1;
        Bomb.powerDirDown = 1;
        Bomb.powerDirLeft = 1;
        Bomb.powerDirRight = 1;
    }
}
