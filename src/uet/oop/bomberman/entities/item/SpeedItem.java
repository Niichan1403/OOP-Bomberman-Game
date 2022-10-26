package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Collision;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

import static uet.oop.bomberman.BombermanGame.player;

public class SpeedItem extends Item {
    public Sound speedItemSound = new Sound();
    public SpeedItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public SpeedItem() {
    }

    public SpeedItem(boolean received) {
        super(received);
    }

    @Override
    public void update() {
        if (this.isDestroyed && !this.isReceived()) {
            this.setImg(Sprite.powerup_speed.getFxImage());
            if (Collision.collision(player.getX(), player.getY(), 24, 32, this.getX(), this.getY(), 32, 32)) {
                this.setImg(Sprite.grass.getFxImage());
                this.setReceived(true);
                speedItemSound.playItem();
                if (player.getDist() % 2 == 1) {
                    if (player.getX() % 2 == 1) {
                        player.setX(player.getX() - 1);
                    }
                    if (player.getY() % 2 == 1) {
                        player.setY(player.getY() - 1);
                    }
                }
                else if (player.getDist() % 2 == 0) {
                    if (player.getX() % 2 == 0) {
                        player.setX(player.getX() - 1);
                    }
                    if (player.getY() % 2 == 0) {
                        player.setY(player.getY() - 1);
                    }
                }
                player.setDist(player.getDist() * 2);
            }
        }
    }
}
