package uet.oop.bomberman.entities.block;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.block;

public class Brick extends Entity {
    private int destroyedSwap = 1;
    private int destroyedCount = 0;

    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    public void brickAnimation(Entity e) {
        if (destroyedCount % 10 == 0) {
            if (destroyedSwap == 1) {
                e.setImg(Sprite.brick_exploded.getFxImage());
                destroyedSwap = 2;
            }
            else if (destroyedSwap == 2) {
                e.setImg(Sprite.brick_exploded1.getFxImage());
                destroyedSwap = 3;
            }
            else if (destroyedSwap == 3) {
                e.setImg(Sprite.brick_exploded2.getFxImage());
                destroyedSwap = 4;
            }
            else {
                block.remove(e);
            }
        }
    }

    @Override
    public void update() {
        if (this.isDestroyed) {
            destroyedCount++;
            brickAnimation(this);
        }
    }
}

