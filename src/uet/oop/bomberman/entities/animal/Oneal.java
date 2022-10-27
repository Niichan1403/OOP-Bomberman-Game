package uet.oop.bomberman.entities.animal;


import javafx.scene.image.Image;
import javafx.util.Pair;
import uet.oop.bomberman.graphics.Sprite;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Collision.*;

public class Oneal extends Animal{
    public static char[][] str = new char[height_][width_];
    int dx[] = {-1,0,1,0};
    int dy[] = {0,-1,0,1};
    int d[][] = new int[1000][1000];
    boolean visit[][] = new boolean[100][100];
    private int swapKill = 0;
    private int countKill = 0;
    public Oneal(){}
    public Oneal(int x, int y, Image img) {
        super(x,y,img);
    }
    public Oneal(int isMove, int swap, String direction) {
        super(4, 1, "up");
    }

    public void killOneal(Animal animal) {
        if (countKill % 16 == 0) {
            if(swapKill == 0 || swapKill == 1) {
                animal.setImg(Sprite.oneal_dead.getFxImage());
            }
            else if (swapKill == 2) {
                animal.setImg(Sprite.mob_dead1.getFxImage());
            } else if (swapKill == 3) {
                animal.setImg(Sprite.mob_dead2.getFxImage());
            } else if(swapKill == 4) {
                animal.setImg(Sprite.mob_dead3.getFxImage());
            }else {
                Image coin = new Image("images/coin.png");
                animal.setImg(coin);
            }
            swapKill++;
        }
    }

    public void BFS(int x, int y) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer,Integer>(y,x));
        visit[y][x] = true;
        d[y][x] = 0;
        while(!q.isEmpty()) {
            Pair<Integer,Integer> top = q.peek(); q.remove();
            for(int k = 0; k < 4;k++) {
                int i1 = top.getValue() + dx[k];
                int j1 = top.getKey() + dy[k];
                if(i1>=0 && i1 <= width_-1 && j1>=0 && j1 <= height_-1 && str[j1][i1] != '#' && str[j1][i1] != '*' && visit[j1][i1] == false) {
                    d[j1][i1] =d[top.getKey()][top.getValue()] + 1;
                    if(j1 == this.y/32 && i1 == this.x /32) return;
                    q.add(new Pair<Integer,Integer>(j1,i1));
                    visit[j1][i1] = true;
                }
            }
        }
    }

    @Override
    public void update() {
        if(!this.isLife()) {
            countKill++;
            killOneal(this);
        }
        for(int i = 0; i< height_; i++) {
            for(int j = 0; j < width_;j++) {
                visit[i][j] = false;
            }
        }
        if(d[this.x/32][this.y/32] == 0) {
            if(this.up == true && blockedUp(this) || this.down == true && blockedDown(this)
                    || this.left == true && blockedLeft(this) || this.right == true && blockedRight(this)) {
                Random random = new Random();
                int dir = random.nextInt(4);
                switch (dir) {
                    case 0:
                        this.up = true;
                        this.down = false;
                        this.left = false;
                        this.right = false;
                        break;
                    case 1:
                        this.up = false;
                        this.down = true;
                        this.left = false;
                        this.right = false;
                        break;
                    case 2:
                        this.up = false;
                        this.down = false;
                        this.left = true;
                        this.right = false;
                        break;
                    case 3:
                        this.up = false;
                        this.down = false;
                        this.left = false;
                        this.right = true;
                        break;
                }
            }
        }
        if(this.x % 32 == 0 && this.y % 32 == 0) {
            BFS(player.getX()/32, player.getY()/32);
            for(int i = 0;i<4;i++) {
                int x = this.x/32 + dx[i];
                int y = this.y/32 + dy[i];
                if(d[y][x] == d[this.y/32][this.x/32] - 1) {
                    if(i == 0) {
                        this.up = false;
                        this.left = true;
                        this.right = false;
                        this.down = false;
                    } else if(i == 1) {
                        this.up = true;
                        this.left = false;
                        this.right = false;
                        this.down = false;
                        break;
                    } else if(i == 2) {
                        this.up = false;
                        this.left = false;
                        this.right = true;
                        this.down = false;
                    } else {
                        this.up = false;
                        this.left = false;
                        this.right = false;
                        this.down = true;
                    }
                    break;
                }
            }
        }
   }
}
