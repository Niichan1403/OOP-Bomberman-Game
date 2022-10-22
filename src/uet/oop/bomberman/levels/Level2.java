package uet.oop.bomberman.levels;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Ballom;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.LayoutGame;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.animal.Bomber.frameKill;
import static uet.oop.bomberman.entities.animal.Bomber.swapKill;
import static uet.oop.bomberman.graphics.LayoutGame.*;

public class Level2 {
    public Level2(Group root) {
        level_ = 2;
        objectText[1].setText("Kondoria");
        objectText[1].setX(1005);
        objectText[2].setText("Doll");
        objectText[2].setX(1023 );

        Image kondoria = new Image("images/kondoria.png");
        enemy1Image.setImage(kondoria);
        Image doll = new Image("images/doll.png");
        enemy2Image.setImage(doll);

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


        Animal enemy4 = new Oneal(9, 7, Sprite.oneal_left1.getFxImage());

        enemy.add(enemy4);

        for(Animal item : enemy) {
            item.setLife(true);
        }
    }
}
