package uet.oop.bomberman.entities.animal;


import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.BombermanGame.player;
import static uet.oop.bomberman.control.Collision.*;

public class Oneal extends Animal{
    private int swapKill = 0;
    private int countKill = 0;
    public Oneal(){}
    public Oneal(int x, int y, Image img) {
        super(x,y,img);
    }
    public Oneal(int isMove, int swap, String direction) {
        super(4, 1, "up");
    }

    public void killOneal(Animal animal) {
        if (countKill % 16 == 0) {
            if(swapKill == 0 || swapKill == 1) {
                animal.setImg(Sprite.oneal_dead.getFxImage());
            }
            else if (swapKill == 2) {
                animal.setImg(Sprite.mob_dead1.getFxImage());
            } else if (swapKill == 3) {
                animal.setImg(Sprite.mob_dead2.getFxImage());
            } else if(swapKill == 4) {
                animal.setImg(Sprite.mob_dead3.getFxImage());
            }else {
                Image coin = new Image("images/coin.png");
                animal.setImg(coin);
            }
            swapKill++;
        }
    }

    @Override
    public void update() {
        if(!this.isLife()) {
            countKill++;
            killOneal(this);
        }
        if(this.x % 32 == 0 && this.y % 32 == 0) {
            if(player.getY() < this.y) {
                this.up = true;
                this.down = false;
            } else if(player.getY() > this.y) {
                this.down = true;
                this.up = false;
            }

            if(player.getX() < this.x) {
                this.left = true;
                this.right = false;
            } else if(player.getX() > this.x) {
                this.left = false;
                this.right = true;
            }

            if(this.up && this.right) {
                if(blockedRight(this) && !blockedUp(this)){
                    this.right = false;
                } else if(blockedUp(this) && !blockedRight(this)) {
                    this.up = false;
                } else {
                    if(enemy.indexOf(this) % 2 ==0) {
                        this.up = false;
                    } else {
                        this.right = false;
                    }
                }
            }

            if(this.up && this.left) {
                if(blockedLeft(this) && !blockedUp(this)){
                    this.left = false;
                } else if(!blockedLeft(this) && blockedUp(this)) {
                    this.up = false;
                } else {
                    if(enemy.indexOf(this) % 2 ==0) {
                        this.left = false;
                    } else {
                        this.up = false;
                    }
                }
            }

            if(this.down && this.left) {
                if(blockedLeft(this) && !blockedDown(this)) {
                    this.left = false;
                } else if(!blockedLeft(this) && blockedDown(this)){
                    this.down = false;
                } else {
                    if(enemy.indexOf(this) % 2 ==0) {
                        this.down = false;
                    } else {
                        this.left = false;
                    }
                }
            }

            if(this.down && this.right) {
                if(blockedRight(this) && !blockedDown(this)) {
                    this.right = false;
                } else if(!blockedRight(this) && blockedDown(this)){
                    this.down = false;
                } else {
                    if(enemy.indexOf(this) % 2 ==0) {
                        this.right = false;
                    } else {
                        this.down = false;
                    }
                }
            }
        }
    }
}
