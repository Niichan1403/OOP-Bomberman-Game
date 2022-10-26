package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Collision;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

import static uet.oop.bomberman.BombermanGame.player;

public class FlameItem extends Item {
    public Sound flameItemSound = new Sound();
    public FlameItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public FlameItem() {
    }

    public FlameItem(boolean received) {
        super(received);
    }

    @Override
    public void update() {
        if (this.isDestroyed && !this.isReceived()) {
            this.setImg(Sprite.powerup_flames.getFxImage());
            if (Collision.collision(player.getX(), player.getY(), 24, 32, this.getX(), this.getY(), 32, 32)) {
                this.setImg(Sprite.grass.getFxImage());
                this.setReceived(true);
                flameItemSound.playItem();
                Bomb.powerDirUp++;
                Bomb.powerDirDown++;
                Bomb.powerDirLeft++;
                Bomb.powerDirRight++;
            }
        }
    }
}
