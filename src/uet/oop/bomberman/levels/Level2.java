package uet.oop.bomberman.levels;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.BombermanGame;
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
        levelSound.playBackground();
        player.setX(32);
        player.setY(32);
        player.setImg(Sprite.player_right.getFxImage());
        player.setDist(1);
        timeNumber = 150;

        frameKill = 0;
        swapKill = 1;
        boom = 20;
        enemy1Number  = 3;
        enemy2Number = 2;

        Bomb.powerDirUp = 1;
        Bomb.powerDirDown = 1;
        Bomb.powerDirLeft = 1;
        Bomb.powerDirRight = 1;

//        Animal enemy1 = new Kondoria(13, 1, Sprite.balloom_left1.getFxImage());
//        Animal enemy2 = new Kondoria(15, 3, Sprite.balloom_left1.getFxImage());
//        Animal enemy3 = new Kondoria(13, 9, Sprite.balloom_left1.getFxImage());
//
//
//        Animal enemy5 = new Doll(20, 1, Sprite.oneal_left1.getFxImage());
//        Animal enemy6 = new Doll(5, 7, Sprite.oneal_left1.getFxImage());
//
//        enemy.add(enemy1);
//        enemy.add(enemy2);
//        enemy.add(enemy3);
//
//        enemy.add(enemy5);
//        enemy.add(enemy6);

        for(Animal item : enemy) {
            item.setLife(true);
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
