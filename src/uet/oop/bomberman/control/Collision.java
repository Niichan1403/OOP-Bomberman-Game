package uet.oop.bomberman.control;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Ballom;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.entities.block.*;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Objects;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.block.Bomb.flameList;
import static uet.oop.bomberman.graphics.LayoutGame.heart;

public class Collision {
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
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick;
            } else if (xt % 32 != 0 && yt % 32 == 0) {
                while (xt % 32 != 0) {
                    xt--;
                }
                if (object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick) {
                    return true;
                }

                if (object_ids[xt / 32][yt / 32 - 1] instanceof Grass) {
                    if ((object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Brick ||
                            object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Wall) &&
                            collision(entity.getX(), entity.getY() - 1, 24, 32, xt + 32, yt - 32, 32, 32)) {
                        return true;
                    }
                }
            }
        }

        if(entity instanceof Ballom || entity instanceof Oneal) {
            if(yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick ||
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
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick;
            } else if (xt % 32 != 0 && yt % 32 == 0) {
                while (xt % 32 != 0) {
                    xt--;
                }
                if ((object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick)) {
                    return true;
                }

                if (object_ids[xt / 32][yt / 32 + 1] instanceof Grass) {
                    if ((object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Brick ||
                            object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Wall) &&
                            collision(entity.getX(), entity.getY() + 8, 24, 25, xt + 32, yt + 32, 32, 32)) {
                        return true;
                    }
                }
            }
        }

        if(entity instanceof Ballom || entity instanceof Oneal) {
            if (yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick||
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
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick;
           } else if (xt % 32 == 0) {
               while (yt % 32 != 0) {
                   yt--;
               }
               if (object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick) {
                   return true;
               }
               yt += 32;
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick;
           }
       }

       if(entity instanceof Ballom || entity instanceof Oneal) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick ||
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
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick;
           } else if (xt % 32 == 8 && yt % 32 != 0) {
               while (yt % 32 != 0) {
                   yt--;
               }
               if (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick) {
                   return true;
               }
               yt += 32;
               return object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick;
           }
       }

       if(entity instanceof Ballom || entity instanceof Oneal) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 + 1][yt / 32] instanceof Brick||
                       object_ids[xt / 32 + 1][yt / 32] instanceof Bomb;
           }
       }

       return false;
    }

    public static void checkCollisionWithEnemy() {
        for (Animal animal : enemy) {
            if (collision(player.getX(), player.getY(), 24, 32, animal.getX(), animal.getY(), 32, 32)) {
                if (player.isLife() && animal.isLife()) {
                    if (heart > 0) {
                        heart--;
                        animal.setLife(false);
                        player.setLife(false);
                    }
                }
            }
        }
    }

    public static void checkCollisionWithFlame() {
        for (Entity flame : flameList) {
            for (Animal e : enemy) {
                if (collision(flame.getX(), flame.getY(), 32, 32, e.getX(), e.getY(), 32, 32)) {
                    e.setLife(false);
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
    }

    // Swerve around corner to avoid hard-stuck
    public static void swerveUp() {
        int xt = player.getX();
        int yt = player.getY();

        if (xt % 32 != 0 && yt % 32 == 0) {
            while (xt % 32 != 0) {
                xt--;
            }
            if (object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                    object_ids[xt / 32][yt / 32 - 1] instanceof Brick) {
                if (player.getX() % 32 > 20) {
                    player.setX(player.getX() + 1);
                }
            }

            if (object_ids[xt / 32][yt / 32 - 1] instanceof Grass) {
                if ((object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Brick ||
                        object_ids[xt / 32 + 1][yt / 32 - 1] instanceof Wall) &&
                        collision(player.getX(), player.getY() - 1, 24, 32, xt + 32, yt - 32, 32, 32)) {
                    if ((player.getX() + 24) % 32 < 12) {
                        player.setX(player.getX() - 1);
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
                    player.setX(player.getX() + 1);
                }
            }

            if (object_ids[xt / 32][yt / 32 + 1] instanceof Grass) {
                if ((object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Brick ||
                        object_ids[xt / 32 + 1][yt / 32 + 1] instanceof Wall) &&
                        collision(player.getX(), player.getY() + 1, 24, 32, xt + 32, yt + 32, 32, 32)) {
                    if ((player.getX() + 24) % 32 < 12) {
                        player.setX(player.getX() - 1);
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
                    player.setY(player.getY() + 1);
                }
            }
            yt += 32;
            if (object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                    object_ids[xt / 32 - 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 < 12) {
                    player.setY(player.getY() - 1);
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
                    player.setY(player.getY() + 1);
                }
            }
            yt += 32;
            if (object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Wall ||
                    object_ids[(xt - 8) / 32 + 1][yt / 32] instanceof Brick) {
                if (player.getY() % 32 < 12) {
                    player.setY(player.getY() - 1);
                }
            }
        }
    }
}
