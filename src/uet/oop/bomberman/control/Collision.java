package uet.oop.bomberman.control;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.*;
import uet.oop.bomberman.entities.block.*;
import uet.oop.bomberman.entities.item.FlameItem;
import uet.oop.bomberman.entities.item.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

import java.util.Objects;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.animal.Oneal.str;
import static uet.oop.bomberman.entities.block.Bomb.*;
import static uet.oop.bomberman.graphics.LayoutGame.*;

public class Collision {
    public static Sound check = new Sound();
    public static int MAX(int a, int b) {
        return Math.max(a, b);
    }

    public static int MIN(int a, int b) {
        return Math.min(a, b);
    }
    public static boolean collision(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2)
    {
        return (MAX(x1, x2) < MIN(x1 + w1, x2 + w2)) && (MAX(y1, y2) < MIN(y1 + h1, y2 + h2));
    }

    // Check if entity is blocked in 4 direction up, down, left, right
    public static boolean blockedUp(Entity entity) {
        int xt = entity.getX();
        int yt = entity.getY();

        if(entity instanceof Bomber) {
            if (xt % 32 == 0 && yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed());
            } else if (xt % 32 != 0 && yt % 32 == 0) {
                while (xt % 32 != 0) {
                    xt--;
                }
                if (object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed())) {
                    return true;
                }

                if (object_ids[xt / 32][yt / 32 - 1] instanceof Grass) {
                    if ((object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Brick ||
                            object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Wall ||
                            (object_ids[xt / 32 + 1][yt / 32 - 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed()) ||
                            (object_ids[xt / 32 + 1][yt / 32 - 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed())) &&
                            collision(entity.getX(), entity.getY() - 1, 24, 33, xt + 32, yt - 32, 32, 32)) {
                        return true;
                    }
                }
            }
        }

        if(entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll) {
            if(yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Bomb ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 - 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 - 1]).isRevealed());
            }
        }

        if(entity instanceof Kondoria) {
            if(yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Bomb;
            }
        }
        return false;
    }

    public static boolean blockedDown(Entity entity) {
        int xt = entity.getX();
        int yt = entity.getY();

        if(entity instanceof Bomber) {
            if (xt % 32 == 0 && yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed());
            } else if (xt % 32 != 0 && yt % 32 == 0) {
                while (xt % 32 != 0) {
                    xt--;
                }
                if (object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed())) {
                    return true;
                }

                if (object_ids[xt / 32][yt / 32 + 1] instanceof Grass) {
                    if ((object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Brick ||
                            object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Wall ||
                            (object_ids[xt / 32 + 1][yt / 32 + 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed()) ||
                            (object_ids[xt / 32 + 1][yt / 32 + 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed())) &&
                            collision(entity.getX(), entity.getY() + 8, 24, 25, xt + 32, yt + 32, 32, 32)) {
                        return true;
                    }
                }
            }
        }

        if(entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll) {
            if (yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Bomb ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed()) ||
                        (object_ids[xt / 32][yt / 32 + 1] instanceof FlameItem && !((FlameItem) object_ids[xt / 32][yt / 32 + 1]).isRevealed());
            }
        }

        if(entity instanceof Kondoria) {
            if(yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Bomb;
            }
        }

        return false;
    }

    public static boolean blockedLeft(Entity entity) {
        int xt = entity.getX();
        int yt = entity.getY();

       if(entity instanceof Bomber) {
           if (xt % 32 == 0 && yt % 32 == 0) {
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed()) ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed());
           } else if (xt % 32 == 0) {
               while (yt % 32 != 0) {
                   yt--;
               }
               if (object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed()) ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed())) {
                   return true;
               }
               yt += 32;
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed()) ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed());
           }
       }

       if(entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Bomb ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed()) ||
                       (object_ids[xt / 32 - 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[xt / 32 - 1][yt / 32]).isRevealed());
           }
       }

        if(entity instanceof Kondoria) {
            if(xt % 32 == 0) {
                return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                        object_ids[xt / 32 - 1][yt / 32] instanceof Bomb;
            }
        }
       return false;
    }

    public static boolean blockedRight(Entity entity) {
        int xt = entity.getX();
        int yt = entity.getY();

        if(entity instanceof Bomber) {
           if (xt % 32 == 8 && yt % 32 == 0) {
               return object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed()) ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed());
           } else if (xt % 32 == 8 && yt % 32 != 0) {
               while (yt % 32 != 0) {
                   yt--;
               }
               if (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed()) ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed())) {
                   return true;
               }
               yt += 32;
               return object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed()) ||
                       (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[(xt - 8) / 32 + 1][yt / 32]).isRevealed());
           }
       }

       if(entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 + 1][yt / 32] instanceof Brick ||
                       object_ids[xt / 32 + 1][yt / 32] instanceof Bomb ||
                       (object_ids[xt / 32 + 1][yt / 32] instanceof SpeedItem && !((SpeedItem) object_ids[xt / 32 + 1][yt / 32]).isRevealed()) ||
                       (object_ids[xt / 32 + 1][yt / 32] instanceof FlameItem && !((FlameItem) object_ids[xt / 32 + 1][yt / 32]).isRevealed());
           }
       }

        if(entity instanceof Kondoria) {
            if(xt % 32 == 0) {
                return object_ids[xt / 32 + 1][yt / 32] instanceof Wall ||
                        object_ids[xt / 32 + 1][yt / 32] instanceof Bomb;
            }
        }

       return false;
    }

    public static void checkCollisionWithEnemy() {
        for (int i = 0; i < enemy.size(); i++) {
            Animal animal = enemy.get(i);
            if (collision(player.getX(), player.getY(), 24, 32, animal.getX(), animal.getY(), 32, 32)) {
                if (player.isLife() && animal.isLife()) {
                    if (heart > 0) {
                        heart--;
                        player.setLife(false);
                    }
                } else if (player.isLife() && !animal.isLife()) {
                    enemy.remove(animal);
                    coin++;
                    check.playCoin();
                }
            }
        }
    }

    public static void checkCollisionWithFlame() {
        for (Entity flame : flameList) {
            for (Animal e : enemy) {
                if (collision(flame.getX(), flame.getY(), 32, 32, e.getX(), e.getY(), 32, 32) && e.isLife()) {
                    e.setLife(false);
                    if(level_ == 3) {
                        if(e instanceof Ballom) {
                            enemy1Number--;
                        } else if(e instanceof Kondoria) {
                            enemy2Number--;
                        } else if(e instanceof Oneal) {
                            enemy3Number--;
                        } else if(e instanceof Doll) {
                            enemy4Number--;
                        }
                    } else {
                        if(e instanceof Ballom || e instanceof Kondoria) {
                            enemy1Number--;
                        } else if(e instanceof Oneal || e instanceof Doll) {
                            enemy2Number--;
                        }
                    }
                }
            }

            if (collision(flame.getX(), flame.getY(), 32, 32, player.getX(), player.getY(), 24, 32)) {
                if (player.isLife()) {
                    if (heart > 0) {
                        heart--;
                        player.setLife(false);
                    }
                }
            }
        }

        if (upFlame.size() > 0) {
            for (int i = 0; i < upFlame.size(); i++) {
                if (i == upFlame.size() - 1 && upFlame.size() < powerDirUp) {
                    destroyBrick(object_ids[upFlame.get(i).getX() / 32][upFlame.get(i).getY() / 32 - 1]);
                }
            }
        }
        if (downFlame.size() > 0) {
            for (int i = 0; i < downFlame.size(); i++) {
                if (i == downFlame.size() - 1 && downFlame.size() < powerDirDown) {
                    destroyBrick(object_ids[downFlame.get(i).getX() / 32][downFlame.get(i).getY() / 32 + 1]);
                }
            }
        }
        if (leftFlame.size() > 0) {
            for (int i = 0; i < leftFlame.size(); i++) {
                if (i == leftFlame.size() - 1 && leftFlame.size() < powerDirLeft) {
                    destroyBrick(object_ids[leftFlame.get(i).getX() / 32 - 1][leftFlame.get(i).getY() / 32]);
                }
            }
        }
        if (rightFlame.size() > 0) {
            for (int i = 0; i < rightFlame.size(); i++) {
                if (i == rightFlame.size() - 1 && rightFlame.size() < powerDirRight) {
                    destroyBrick(object_ids[rightFlame.get(i).getX() / 32 + 1][rightFlame.get(i).getY() / 32]);
                }
            }
        }

        if (center.size() > 0) {
            destroyBrick(object_ids[center.get(0).getX() / 32][center.get(0).getY() / 32 - 1]);
            destroyBrick(object_ids[center.get(0).getX() / 32][center.get(0).getY() / 32 + 1]);
            destroyBrick(object_ids[center.get(0).getX() / 32 - 1][center.get(0).getY() / 32]);
            destroyBrick(object_ids[center.get(0).getX() / 32 + 1][center.get(0).getY() / 32]);
        }
    }

    public static void destroyBrick(Entity e) {
        if (e instanceof Brick) {
            int xt = e.getX() / 32;
            int yt = e.getY() / 32;

            block.remove(e);

            Entity newGrass = new Grass(xt, yt, Sprite.grass.getFxImage());
            Entity brickAnimation = new Brick(xt, yt, Sprite.brick.getFxImage());
            block.add(newGrass);
            block.add(brickAnimation);

            brickAnimation.isDestroyed = true;

            object_ids[xt][yt] = newGrass;
            str[yt][xt] = '-';
        }
        else if (e instanceof SpeedItem && !((SpeedItem) e).isRevealed()) {
            int xt = e.getX() / 32;
            int yt = e.getY() / 32;

            Entity brickAnimation = new Brick(xt, yt, Sprite.brick.getFxImage());
            block.add(brickAnimation);

            brickAnimation.isDestroyed = true;
            e.isDestroyed = true;
            ((SpeedItem) e).setRevealed(true);

            object_ids[xt][yt] = e;
        }
        else if (e instanceof FlameItem && !((FlameItem) e).isRevealed()) {
            int xt = e.getX() / 32;
            int yt = e.getY() / 32;

            Entity brickAnimation = new Brick(xt, yt, Sprite.brick.getFxImage());
            block.add(brickAnimation);

            brickAnimation.isDestroyed = true;
            e.isDestroyed = true;
            ((FlameItem) e).setRevealed(true);

            object_ids[xt][yt] = e;
        }
    }

    // Swerve around corner to avoid hard-stuck
    public static void swerveUp() {
        int xt = player.getX();
        int yt = player.getY();

        if (xt % 32 != 0 && yt % 32 == 0) {
            while (xt % 32 != 0) {
                xt--;
            }
            if ((object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                    object_ids[xt / 32][yt / 32 - 1] instanceof Brick)) {
                if (player.getX() % 32 > 20) {
                    player.setX(player.getX() + player.getDist());
                }
            }

            if (object_ids[xt / 32][yt / 32 - 1] instanceof Grass) {
                if ((object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Brick ||
                        object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Wall) &&
                        collision(player.getX(), player.getY() - 1, 24, 32, xt + 32, yt - 32, 32, 32)) {
                    if ((player.getX() + 24) % 32 < 12 && (player.getX() + 24) % 32 > 0) {
                        player.setX(player.getX() - player.getDist());
                    }
                }
            }
        }
    }

    public static void swerveDown() {
        int xt = player.getX();
        int yt = player.getY();

        if (xt % 32 != 0 && yt % 32 == 0) {
            while (xt % 32 != 0) {
                xt--;
            }
            if (object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                    object_ids[xt / 32][yt / 32 + 1] instanceof Brick) {
                if (player.getX() % 32 > 20) {
                    player.setX(player.getX() + player.getDist());
                }
            }

            if (object_ids[xt / 32][yt / 32 + 1] instanceof Grass) {
                if ((object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Brick ||
                        object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Wall) &&
                        collision(player.getX(), player.getY() + 1, 24, 32, xt + 32, yt + 32, 32, 32)) {
                    if ((player.getX() + 24) % 32 < 12 && (player.getX() + 24) % 32 > 0) {
                        player.setX(player.getX() - player.getDist());
                    }
                }
            }
        }
    }


    public static void swerveLeft() {
        int xt = player.getX();
        int yt = player.getY();

        if (xt % 32 == 0) {
            while (yt % 32 != 0) {
                yt--;
            }
            if (object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                    object_ids[xt / 32 - 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 > 20) {
                    player.setY(player.getY() + player.getDist());
                }
            }
            yt += 32;
            if (object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                    object_ids[xt / 32 - 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 < 12 && player.getY() % 32 > 0) {
                    player.setY(player.getY() - player.getDist());
                }
            }
        }
    }

    public static void swerveRight() {
        int xt = player.getX();
        int yt = player.getY();

        if (xt % 32 == 8 && yt % 32 != 0) {
            while (yt % 32 != 0) {
                yt--;
            }
            if (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                    object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 > 20) {
                    player.setY(player.getY() + player.getDist());
                }
            }
            yt += 32;
            if (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                    object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 < 12 && player.getY() % 32 > 0) {
                    player.setY(player.getY() - player.getDist());
                }
            }
        }
    }
}
