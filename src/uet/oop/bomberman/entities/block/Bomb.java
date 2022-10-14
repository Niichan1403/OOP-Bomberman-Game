package uet.oop.bomberman.entities.block;

import com.sun.webkit.dom.EntityImpl;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.graphics.LayoutGame.boom;

public class Bomb extends Entity {
    private static Entity bomb;
    private static long activeFrame = 20;    // frame counted before switch animation when active bomb
    private static long explodeFrame = 20;    // frame counted before switch animation when bomb explodes
    private static long timeToExplode;
    private static long explosionTime;
    private static int activeSwap;            // swap animation when bomb is active
    private static int explodeSwap;         // swap animation when bomb explodes
    public static int hasBomb = 0;          // check if there's a bomb
    public static int bombNumber = 1;

    public static int powerDirUp = 2;
    public static int powerDirDown= 2;
    public static int powerDirLeft = 2;
    public static int powerDirRight = 2;

    private static Entity middleFlame;

    public static List<Entity> center = new ArrayList<>();
    public static List<Entity> upFlame = new ArrayList<>();
    public static List<Entity> downFlame = new ArrayList<>();
    public static List<Entity> leftFlame = new ArrayList<>();
    public static List<Entity> rightFlame = new ArrayList<>();

    private static boolean hasFlame = false;

    public static List<Entity> flameList = new ArrayList<>();

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public static void putBomb() {
        if (hasBomb == 0 && bombNumber > 0 && boom > 0) {
            bombNumber--;
            boom--;
            hasBomb = 1;
            timeToExplode = 180;
            explosionTime = 140;
            int x = Math.round((float) player.getX() / 32);
            int y = Math.round((float) player.getY() / 32);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            block.add(bomb);
            object_ids[x][y] = bomb;
            activeSwap = 1;
            explodeSwap = 1;
        }
    }

    // Bomb's animation before explosion
    public static void activeBomb() {
        if (activeSwap == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            if (activeFrame-- < 0) {
                activeSwap = 2;
                activeFrame = 20;
            }
        }
        else if (activeSwap == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            if (activeFrame-- < 0) {
                activeSwap = 3;
                activeFrame = 20;
            }
        }
        else if (activeSwap == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            if (activeFrame-- < 0) {
                activeSwap = 4;
                activeFrame = 20;
            }
        }
        else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            if (activeFrame-- < 0) {
                activeSwap = 1;
                activeFrame = 20;
            }
        }
    }

    public static void createFlame() {
        middleFlame = new Bomb(bomb.getX() / 32, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
        center.add(middleFlame);
        Entity flame;
        int i;
        for (i = 1; i <= powerDirUp; i++) {
            if (object_ids[bomb.getX() / 32][bomb.getY() / 32 - i] instanceof Wall ||
                    object_ids[bomb.getX() / 32][bomb.getY() / 32 - i] instanceof Brick) {
                break;
            }
            flame = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - i, Sprite.bomb_exploded.getFxImage());
            upFlame.add(flame);
        }
        for (i = 1; i <= powerDirDown; i++) {
            if (object_ids[bomb.getX() / 32][bomb.getY() / 32 + i] instanceof Wall ||
                    object_ids[bomb.getX() / 32][bomb.getY() / 32 + i] instanceof Brick) {
                break;
            }
            flame = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + i, Sprite.bomb_exploded.getFxImage());
            downFlame.add(flame);
        }
        for (i = 1; i <= powerDirLeft; i++) {
            if (object_ids[bomb.getX() / 32 - i][bomb.getY() / 32] instanceof Wall ||
                    object_ids[bomb.getX() / 32 - i][bomb.getY() / 32] instanceof Brick) {
                break;
            }
            flame = new Bomb(bomb.getX() / 32 - i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            leftFlame.add(flame);
        }
        for (i = 1; i <= powerDirRight; i++) {
            if (object_ids[bomb.getX() / 32 + i][bomb.getY() / 32] instanceof Wall ||
                    object_ids[bomb.getX() / 32 + i][bomb.getY() / 32] instanceof Brick) {
                break;
            }
            flame = new Bomb(bomb.getX() / 32 + i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            rightFlame.add(flame);
        }

        block.add(middleFlame);
        block.addAll(upFlame);
        block.addAll(downFlame);
        block.addAll(leftFlame);
        block.addAll(rightFlame);

        flameList.add(middleFlame);
        flameList.addAll(upFlame);
        flameList.addAll(downFlame);
        flameList.addAll(leftFlame);
        flameList.addAll(rightFlame);

        hasFlame = true;
    }

    public static void flameAnimation() {
        int i;
        if (explodeSwap == 1) {
            middleFlame.setImg(Sprite.bomb_exploded.getFxImage());

            if (upFlame.size() > 0) {
                for (i = 0; i < upFlame.size(); i++) {
                    if (i == powerDirUp - 1 ||
                            (i == upFlame.size() - 1 && upFlame.size() < powerDirUp
                                    && object_ids[upFlame.get(i).getX() / 32][upFlame.get(i).getY() / 32 - 1] instanceof Wall)) {
                        upFlame.get(i).setImg(Sprite.explosion_vertical_top_last.getFxImage());
                    } else {
                        upFlame.get(i).setImg(Sprite.explosion_vertical.getFxImage());
                    }
                }
            }

            if (downFlame.size() > 0) {
                for (i = 0; i < downFlame.size(); i++) {
                    if (i == powerDirDown - 1 ||
                            (i == downFlame.size() - 1 && downFlame.size() < powerDirDown
                                    && object_ids[downFlame.get(i).getX() / 32][downFlame.get(i).getY() / 32 + 1] instanceof Wall)) {
                        downFlame.get(i).setImg(Sprite.explosion_vertical_down_last.getFxImage());
                    } else {
                        downFlame.get(i).setImg(Sprite.explosion_vertical.getFxImage());
                    }
                }
            }

            if (leftFlame.size() > 0) {
                for (i = 0; i < leftFlame.size(); i++) {
                    if (i == powerDirLeft - 1 ||
                            (i == leftFlame.size() - 1 && leftFlame.size() < powerDirLeft
                                    && object_ids[leftFlame.get(i).getX() / 32 - 1][leftFlame.get(i).getY() / 32] instanceof Wall)) {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal_left_last.getFxImage());
                    } else {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal.getFxImage());
                    }
                }
            }

            if (rightFlame.size() > 0) {
                for (i = 0; i < rightFlame.size(); i++) {
                    if (i == powerDirRight - 1 ||
                            (i == rightFlame.size() - 1 && rightFlame.size() < powerDirRight
                                    && object_ids[rightFlame.get(i).getX() / 32 + 1][rightFlame.get(i).getY() / 32] instanceof Wall)) {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal_right_last.getFxImage());
                    } else {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal.getFxImage());
                    }
                }
            }

            if (explodeFrame-- < 0) {
                explodeSwap = 2;
                explodeFrame = 20;
            }
        }

        if (explodeSwap == 2) {
            middleFlame.setImg(Sprite.bomb_exploded1.getFxImage());

            if (upFlame.size() > 0) {
                for (i = 0; i < upFlame.size(); i++) {
                    if (i == powerDirUp - 1 ||
                            (i == upFlame.size() - 1 && upFlame.size() < powerDirUp
                                    && object_ids[upFlame.get(i).getX() / 32][upFlame.get(i).getY() / 32 - 1] instanceof Wall)) {
                        upFlame.get(i).setImg(Sprite.explosion_vertical_top_last1.getFxImage());
                    } else {
                        upFlame.get(i).setImg(Sprite.explosion_vertical1.getFxImage());
                    }
                }
            }

            if (downFlame.size() > 0) {
                for (i = 0; i < downFlame.size(); i++) {
                    if (i == powerDirDown - 1 ||
                            (i == downFlame.size() - 1 && downFlame.size() < powerDirDown
                                    && object_ids[downFlame.get(i).getX() / 32][downFlame.get(i).getY() / 32 + 1] instanceof Wall)) {
                        downFlame.get(i).setImg(Sprite.explosion_vertical_down_last1.getFxImage());
                    } else {
                        downFlame.get(i).setImg(Sprite.explosion_vertical1.getFxImage());
                    }
                }
            }

            if (leftFlame.size() > 0) {
                for (i = 0; i < leftFlame.size(); i++) {
                    if (i == powerDirLeft - 1 ||
                            (i == leftFlame.size() - 1 && leftFlame.size() < powerDirLeft
                                    && object_ids[leftFlame.get(i).getX() / 32 - 1][leftFlame.get(i).getY() / 32] instanceof Wall)) {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
                    } else {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal1.getFxImage());
                    }
                }
            }

            if (rightFlame.size() > 0) {
                for (i = 0; i < rightFlame.size(); i++) {
                    if (i == powerDirRight - 1 ||
                            (i == rightFlame.size() - 1 && rightFlame.size() < powerDirRight
                                    && object_ids[rightFlame.get(i).getX() / 32 + 1][rightFlame.get(i).getY() / 32] instanceof Wall)) {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
                    } else {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal1.getFxImage());
                    }
                }
            }

            if (explodeFrame-- < 0) {
                explodeSwap = 3;
                explodeFrame = 20;
            }
        }

        if (explodeSwap == 3) {
            middleFlame.setImg(Sprite.bomb_exploded2.getFxImage());

            if (upFlame.size() > 0) {
                for (i = 0; i < upFlame.size(); i++) {
                    if (i == powerDirUp - 1 ||
                            (i == upFlame.size() - 1 && upFlame.size() < powerDirUp
                                    && object_ids[upFlame.get(i).getX() / 32][upFlame.get(i).getY() / 32 - 1] instanceof Wall)) {
                        upFlame.get(i).setImg(Sprite.explosion_vertical_top_last2.getFxImage());
                    } else {
                        upFlame.get(i).setImg(Sprite.explosion_vertical2.getFxImage());
                    }
                }
            }

            if (downFlame.size() > 0) {
                for (i = 0; i < downFlame.size(); i++) {
                    if (i == powerDirDown - 1 ||
                            (i == downFlame.size() - 1 && downFlame.size() < powerDirDown
                                    && object_ids[downFlame.get(i).getX() / 32][downFlame.get(i).getY() / 32 + 1] instanceof Wall)) {
                        downFlame.get(i).setImg(Sprite.explosion_vertical_down_last2.getFxImage());
                    } else {
                        downFlame.get(i).setImg(Sprite.explosion_vertical2.getFxImage());
                    }
                }
            }

            if (leftFlame.size() > 0) {
                for (i = 0; i < leftFlame.size(); i++) {
                    if (i == powerDirLeft - 1 ||
                            (i == leftFlame.size() - 1 && leftFlame.size() < powerDirLeft
                                    && object_ids[leftFlame.get(i).getX() / 32 - 1][leftFlame.get(i).getY() / 32] instanceof Wall)) {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal_left_last2.getFxImage());
                    } else {
                        leftFlame.get(i).setImg(Sprite.explosion_horizontal2.getFxImage());
                    }
                }
            }

            if (rightFlame.size() > 0) {
                for (i = 0; i < rightFlame.size(); i++) {
                    if (i == powerDirRight - 1 ||
                            (i == rightFlame.size() - 1 && rightFlame.size() < powerDirRight
                                    && object_ids[rightFlame.get(i).getX() / 32 + 1][rightFlame.get(i).getY() / 32] instanceof Wall)) {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal_right_last2.getFxImage());
                    } else {
                        rightFlame.get(i).setImg(Sprite.explosion_horizontal2.getFxImage());
                    }
                }
            }

            if (explodeFrame-- < 0) {
                explodeSwap = 1;
                explodeFrame = 20;
            }
        }
    }

    public static void checkActive() {
        if (hasBomb == 1) {
            if (timeToExplode-- > 0) {
                activeBomb();
            } else {
                block.remove(bomb);
                hasBomb = 2;
            }
        }
    }

    private static void checkExplosion() {
        if (hasBomb == 2) {
            if (!hasFlame) {
                createFlame();
            }
            if (explosionTime-- > 0) {
                flameAnimation();
            } else {
                hasBomb = 3;
            }
        } else if (hasBomb == 3) {
            block.remove(middleFlame);
            block.removeAll(upFlame);
            block.removeAll(downFlame);
            block.removeAll(leftFlame);
            block.removeAll(rightFlame);

            flameList.remove(middleFlame);
            flameList.removeAll(upFlame);
            flameList.removeAll(downFlame);
            flameList.removeAll(leftFlame);
            flameList.removeAll(rightFlame);

            center.clear();
            upFlame.clear();
            downFlame.clear();
            leftFlame.clear();
            rightFlame.clear();

            bombNumber = 1;
            hasFlame = false;
            hasBomb = 0;
        }
    }

    @Override
    public void update() {
        checkActive();
        checkExplosion();
    };
}
