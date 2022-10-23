package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.animal.*;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.control.Collision.*;

public class Move {
    public static int dx = 0;
    public static int dy = 0;
    public static boolean blocked = false;

    public static void checkRun(Animal animal, int dist) {
        if (animal instanceof Bomber){
            setMovement(animal, dist);
        }

        if(animal instanceof Ballom || animal instanceof Oneal || animal instanceof Kondoria || animal instanceof Doll){
            setMovement(animal, dist);
        }
    }

    private static void setMovement(Animal animal, int dist) {
        if (animal.isLife()) {
            if (animal.up){
                upAnimation(animal);
                if (blockedUp(animal)) {
                    dist = 0;
                    swerveUp();
                }
                dy = -dist;
                animal.setY(animal.getY() + dy);
            }
            else if (animal.down){
                downAnimation(animal);
                if (blockedDown(animal)) {
                    dist = 0;
                    swerveDown();
                }
                dy = dist;
                animal.setY(animal.getY() + dy);
            }
            else if (animal.left){
                leftAnimation(animal);
                if (blockedLeft(animal)) {
                    dist = 0;
                    swerveLeft();
                }
                dx = -dist;
                animal.setX(animal.getX() + dx);
            }
            else if (animal.right){
                rightAnimation(animal);
                if (blockedRight(animal)) {
                    dist = 0;
                    swerveRight();
                }
                dx = dist;
                animal.setX(animal.getX() + dx);
            }
        }
    }

    private static void upAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.animationFrame-- == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_up_1.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_up_2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Ballom && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Oneal && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Kondoria && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Doll && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
    }

    private static void downAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.animationFrame-- == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_down_1.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_down_2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Ballom && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
        if (animal instanceof Oneal && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Kondoria && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Doll && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
    }

    private static void leftAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.animationFrame-- == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_left_1.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_left_2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Ballom && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
        if (animal instanceof Oneal && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Kondoria && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Doll && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
    }

    private static void rightAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.animationFrame-- == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_right_1.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_right_2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Ballom && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Oneal && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if(animal instanceof Kondoria && animal.animationFrame-- == 0) {
            if(animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else if(animal.getSwap() == 4) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }

        if (animal instanceof Doll && animal.animationFrame-- == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
                animal.animationFrame = 6;
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
                animal.animationFrame = 6;
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
                animal.animationFrame = 6;
            }
        }
    }
}
