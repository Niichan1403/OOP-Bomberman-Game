package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.animal.*;
import uet.oop.bomberman.graphics.Sprite;

public class Move {
    public static void checkRun(Animal animal) {
        if (animal instanceof Bomber){
            setMovement(animal, 2);
        }
    }

    private static void setMovement(Animal animal, int dist) {
        int dx = 0, dy = 0;
        if (animal.up){
            upAnimation(animal);
            dy = -dist;
            animal.setY(animal.getY() + dy);
        }
        if (animal.down){
            downAnimation(animal);
            dy = dist;
            animal.setY(animal.getY() + dy);
        }
        if (animal.left){
            leftAnimation(animal);
            dx = -dist;
            animal.setX(animal.getX() + dx);
        }
        if (animal.right){
            rightAnimation(animal);
            dx = dist;
            animal.setX(animal.getX() + dx);
        }
    }

    private static void upAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.getY() % 8 == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(4);
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    private static void downAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.getY() % 8 == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(4);
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    private static void leftAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.getX() % 8 == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(4);
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    private static void rightAnimation(Animal animal) {
        if (animal instanceof Bomber && animal.getX() % 8 == 0){
            if (animal.getSwap() == 1){
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2){
                animal.setImg(Sprite.player_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3){
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(4);
            } else if (animal.getSwap() == 4){
                animal.setImg(Sprite.player_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

}
