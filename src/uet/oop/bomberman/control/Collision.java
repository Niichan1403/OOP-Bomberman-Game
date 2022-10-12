package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Ballom;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.entities.block.*;

import java.util.Objects;

import static uet.oop.bomberman.BombermanGame.*;

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
                xt += 32;
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick;
            }
        }

        if(entity instanceof Ballom) {
            if(yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 - 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 - 1] instanceof Brick;
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
                if (object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick) {
                    return true;
                }
                xt += 32;
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick;
            }
        }
        if(entity instanceof Ballom) {
            if (yt % 32 == 0) {
                return object_ids[xt / 32][yt / 32 + 1] instanceof Wall ||
                        object_ids[xt / 32][yt / 32 + 1] instanceof Brick;
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
       if(entity instanceof Ballom) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 - 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 - 1][yt / 32] instanceof Brick;
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
       if(entity instanceof Ballom) {
           if(xt % 32 == 0) {
               return object_ids[xt / 32 + 1][yt / 32] instanceof Wall ||
                       object_ids[xt / 32 + 1][yt / 32] instanceof Brick;
           }
       }
       return false;
    }

    public static void checkCollisionWithEnemy() {
        for (Animal animal : enemy) {
            if (collision(player.getX(), player.getY(), 24, 32, animal.getX(), animal.getY(), 32, 32)) {
                player.setLife(false);
            }
        }
    }

    public static void unstuck(Animal animal) {
        if (animal.right) {
            animal.setX(animal.getX() - 2);
        } else if (animal.left) {
            animal.setX(animal.getX() + 2);
        } else if (animal.up) {
            animal.setY(animal.getY() - 2);
        } else if (animal.down) {
            animal.setY(animal.getY() + 2);
        }
    }
}
