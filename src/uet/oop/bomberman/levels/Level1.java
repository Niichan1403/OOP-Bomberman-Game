package uet.oop.bomberman.levels;


import javafx.scene.Group;
import uet.oop.bomberman.entities.animal.*;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.LayoutGame;

import java.util.Random;

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
        player.setDist(1);
        Bomb.powerDirUp = 1;
        Bomb.powerDirDown = 1;
        Bomb.powerDirLeft = 1;
        Bomb.powerDirRight = 1;
        player.setImg(Sprite.player_right.getFxImage());
        timeNumber = 150;

        frameKill = 0;
        swapKill = 1;
        heart = 3;
        boom = 20;
        coin = 0;
        enemy1Number  = 4;
        enemy2Number = 3;

        Animal enemy1 = new Ballom(13, 1, Sprite.balloom_left1.getFxImage());
        Animal enemy2 = new Ballom(24, 8, Sprite.balloom_left1.getFxImage());
        Animal enemy3 = new Ballom(22, 5, Sprite.balloom_left1.getFxImage());
        Animal enemy4 = new Ballom(3,7 , Sprite.balloom_left1.getFxImage());


        Animal enemy5 = new Oneal(7, 7, Sprite.oneal_left1.getFxImage());
        Animal enemy6 = new Oneal(26, 3, Sprite.oneal_left1.getFxImage());
        Animal enemy7 = new Oneal(27, 8, Sprite.oneal_left1.getFxImage());

        enemy.add(enemy1);
        enemy.add(enemy2);
        enemy.add(enemy3);
        enemy.add(enemy4);
        enemy.add(enemy5);
        enemy.add(enemy6);
        enemy.add(enemy7);

        for(Animal item : enemy) {
            item.setLife(true);
            if(item instanceof Ballom) {
                Random random = new Random();
                int dir = random.nextInt(4);
                switch (dir) {
                    case 0:
                        item.up = true;
                        break;
                    case 1:
                        item.down = true;
                        break;
                    case 2:
                        item.left = true;
                        break;
                    case 3:
                        item.right = true;
                        break;
                }
            }
        }
    }
}
