package uet.oop.bomberman.levels;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.entities.animal.*;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.entities.animal.Bomber.frameKill;
import static uet.oop.bomberman.entities.animal.Bomber.swapKill;
import static uet.oop.bomberman.graphics.LayoutGame.*;
import static uet.oop.bomberman.graphics.LayoutGame.enemy2Number;

public class Level3 {
    public Level3(Group root) {

        objectText[1].setText("");
        objectText[1].setX(1005);
        objectText[2].setText("");
        objectText[2].setX(1023 );
        enemy1Number = 1;
        enemy2Number = 2;
        enemy3Number = 2;
        enemy4Number = 1;

        Image kondoria = new Image("images/ballom_kondoria.png");
        enemy1Image.setImage(kondoria);
        enemy1Image.setY(172);
        Image doll = new Image("images/oneal_doll.png");
        enemy2Image.setImage(doll);
        enemy2Image.setY(295);

        Image b = new Image("images/b.png");
        bom[1].setImage(b);
        bom[2].setImage(b);

        level_ = 3;
        new CreateMap("res/levels/level3.txt");
        player.setX(32);
        player.setY(32);
        player.setImg(Sprite.player_right.getFxImage());
        player.setDist(1);
        timeNumber = 150;

        frameKill = 0;
        swapKill = 1;
        boom = 20;
        Bomb.powerDirUp = 1;
        Bomb.powerDirDown = 1;
        Bomb.powerDirLeft = 1;
        Bomb.powerDirRight = 1;

        Animal enemy1 = new Ballom(13, 1, Sprite.balloom_left1.getFxImage());
        Animal enemy2 = new Doll(24, 8, Sprite.doll_left1.getFxImage());


        Animal enemy5 = new Oneal(7, 7, Sprite.oneal_left1.getFxImage());
        Animal enemy6 = new Oneal(26, 3, Sprite.oneal_left1.getFxImage());
        Animal enemy7 = new Kondoria(27, 8, Sprite.kondoria_left1.getFxImage());
        Animal enemy8 = new Kondoria(22, 3, Sprite.kondoria_left1.getFxImage());

        enemy.add(enemy1);
        enemy.add(enemy2);

        enemy.add(enemy5);
        enemy.add(enemy6);
        enemy.add(enemy7);
        enemy.add(enemy8);

        for(Animal item : enemy) {
            item.setLife(true);
            if(item instanceof Ballom || item instanceof Doll || item instanceof Kondoria) {
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
