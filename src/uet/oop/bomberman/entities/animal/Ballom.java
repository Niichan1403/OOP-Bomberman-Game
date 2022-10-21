package uet.oop.bomberman.entities.animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.enemy;

public class Ballom extends Animal {
    public Sound ballomSound = new Sound();
    private int swapKill = 1;
    private int countKill = 0;
    public Ballom(int dist, int swap, String direction, int countToRun) {

        super(4, 1, "up");
    }

    public Ballom() {

    }

    public Ballom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void killBallom(Animal animal) {
        if(countKill % 10 == 0) {
            if(swapKill == 1) {
                animal.setImg(Sprite.mob_dead1.getFxImage());
            } else if(swapKill == 2) {
                animal.setImg(Sprite.mob_dead2.getFxImage());
            } else if(swapKill == 3) {
                animal.setImg(Sprite.mob_dead3.getFxImage());
            } else {
                Image coin = new Image("images/coin.png");
                animal.setImg(coin);
            }
            swapKill ++;
        }
    }


    @Override
    public void update() {
        if(!this.isLife()) {
            countKill++;
            killBallom(this);
        }

        if (this.y % 32 == 0 && this.x % 32 == 0) {
            Random random = new Random();
            int dir = random.nextInt(4);
            switch (dir) {
                case 0:
                    this.up = true;
                    this.down = false;
                    this.left = false;
                    this.right = false;
                    break;
                case 1:
                    this.up = false;
                    this.down = true;
                    this.left = false;
                    this.right = false;
                    break;
                case 2:
                    this.up = false;
                    this.down = false;
                    this.left = true;
                    this.right = false;
                    break;
                case 3:
                    this.up = false;
                    this.down = false;
                    this.left = false;
                    this.right = true;
                    break;
            }
        }
    }
}

