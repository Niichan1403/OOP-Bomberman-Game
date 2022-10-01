package uet.oop.bomberman.entities.animal;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;

public class Bomber extends Animal {

    public Bomber() {}
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public Bomber(int dist, int swap, String direction) {
        super(dist, swap, direction);
    }

    @Override
    public void update() {

    }
}
