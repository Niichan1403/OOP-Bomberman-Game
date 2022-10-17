package uet.oop.bomberman.levels;


import javafx.scene.Group;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Ballom;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.LayoutGame;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.animal.Bomber.frameKill;
import static uet.oop.bomberman.entities.animal.Bomber.swapKill;
import static uet.oop.bomberman.graphics.LayoutGame.*;

public class Level1 {
    public Level1(Group root) {
        level_ = 1;
        new CreateMap("res/levels/level1.txt");
        LayoutGame.createLayout(root);
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        player.setImg(Sprite.player_right.getFxImage());
        timeNumber = 150;

        frameKill = 0;
        swapKill = 1;
        heart = 3;
        boom = 20;
        coin = 0;
        ballomNumber  = 3;
        onealNumber = 2;

        Animal enemy1 = new Ballom(13, 1, Sprite.balloom_left1.getFxImage());
        Animal enemy2 = new Ballom(18, 3, Sprite.balloom_left1.getFxImage());
        Animal enemy3 = new Ballom(26, 5, Sprite.balloom_left1.getFxImage());


        Animal enemy4 = new Oneal(9, 7, Sprite.oneal_left1.getFxImage());
        Animal enemy5 = new Oneal(26, 3, Sprite.oneal_left1.getFxImage());

        enemy.add(enemy1);
        enemy.add(enemy2);
        enemy.add(enemy3);
        enemy.add(enemy4);
        enemy.add(enemy5);

        for(Animal item : enemy) {
            item.setLife(true);
        }
    }
}
