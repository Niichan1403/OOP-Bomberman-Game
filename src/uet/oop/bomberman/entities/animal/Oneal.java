package uet.oop.bomberman.entities.animal;


import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.player;
import static uet.oop.bomberman.control.Collision.*;

public class Oneal extends Animal{
    public Oneal(){}
    public Oneal(int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void update() {
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
                    this.up = false;
                }
            }

            if(this.up && this.left) {
                if(blockedLeft(this) && !blockedUp(this)){
                    this.left = false;
                } else if(!blockedLeft(this) && blockedUp(this)) {
                    this.up = false;
                } else {
                    this.left = false;
                }
            }

            if(this.down && this.left) {
                if(blockedLeft(this) && !blockedDown(this)) {
                    this.left = false;
                } else if(!blockedLeft(this) && blockedDown(this)){
                    this.down = false;
                } else {
                    this.down = false;
                }
            }

            if(this.down && this.right) {
                if(blockedRight(this) && !blockedDown(this)) {
                    this.right = false;
                } else if(!blockedRight(this) && blockedDown(this)){
                    this.down = false;
                } else {
                    this.right = false;
                }
            }
        }
    }
}
