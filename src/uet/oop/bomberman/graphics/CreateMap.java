package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.block.Brick;
import uet.oop.bomberman.entities.block.Grass;
import uet.oop.bomberman.entities.block.Wall;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static uet.oop.bomberman.BombermanGame.*;

public class CreateMap {
    public CreateMap(String lv) {
        final File file = new File(lv);

        try (FileReader fr = new FileReader(file)) {
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);
            level_ = Integer.parseInt(tokens.nextToken());
            height_ = Integer.parseInt(tokens.nextToken());
            width_ = Integer.parseInt(tokens.nextToken());

            while (sc.hasNextLine()) {
                for (int i = 0; i < height_; i++) {
                    String lineTile = sc.nextLine();
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);

                    for (int j = 0; j < width_; j++) {
                        String s = tokenTile.nextToken();
                        Entity ett;
                        switch(s) {
                            case "#":
                                ett = new Wall(j, i, Sprite.wall.getFxImage());
                                break;
                            case "*":
                                ett = new Brick(j, i, Sprite.brick.getFxImage());
                                break;
                            default:
                                ett = new Grass(j, i, Sprite.grass.getFxImage());
                                break;
                        }
                        block.add(ett);
                    }
                }
            }
            //sc.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
