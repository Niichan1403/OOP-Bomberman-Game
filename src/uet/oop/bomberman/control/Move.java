package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.animal.*;

public class Move {
    public static void checkRun(Animal animal) {
        if (animal instanceof Bomber && animal.getCount() > 0){
            setMovement(animal.getDirection(), animal, 4);
            animal.setCount(animal.getCount() - 1);
        }
    }

    private static void setMovement(String direction, Animal animal, int isMove) {
        switch (direction) {
            case "down":
//                down_step(animal);
                animal.setY(animal.getY() + isMove);
                break;
            case "up":
                animal.setY(animal.getY() - isMove);
                break;
            case "left":
                animal.setX(animal.getX() - isMove);
                break;
            case "right":
                animal.setX(animal.getX() + isMove);
                break;
        }
    }

    public static void down(Animal animal) {
        if (animal.getX() % 16 == 0 && animal.getY() % 16 == 0){
            if (animal instanceof Bomber){
                animal.setDirection("down");
                animal.setCount(4);
                checkRun(animal);
            }
        }
    }

    public static void up(Animal animal) {
        if (animal.getX() % 16 == 0 && animal.getY() % 16 == 0){
            if (animal instanceof Bomber){
                animal.setDirection("up");
                animal.setCount(4);
                checkRun(animal);
            }
        }
    }

    public static void left(Animal animal) {
        if (animal.getX() % 16 == 0 && animal.getY() % 16 == 0){
            if (animal instanceof Bomber){
                animal.setDirection("left");
                animal.setCount(4);
                checkRun(animal);
            }
        }
    }

    public static void right(Animal animal) {
        if (animal.getX() % 16 == 0 && animal.getY() % 16 == 0){
            if (animal instanceof Bomber){
                animal.setDirection("right");
                animal.setCount(4);
                checkRun(animal);
            }
        }
    }
}
