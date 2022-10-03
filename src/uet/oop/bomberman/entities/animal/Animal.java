package uet.oop.bomberman.entities.animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class Animal extends Entity {
    public int dist = 1;             // distance in pixel
    protected int swap = 1;             // animation swap
    protected String direction;     // moving direction
    protected boolean life;         // check if player is alive or dead

    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;

    public Animal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Animal(int dist, int swap, String direction) {
        this.dist = dist;
        this.swap = swap;
        this.direction = direction;
    }

    public Animal(boolean life) {
        this.life = life;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public Animal() {}

    @Override
    public void update() {}
}
