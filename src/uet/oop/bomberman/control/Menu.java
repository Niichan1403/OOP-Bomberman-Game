package uet.oop.bomberman.control;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.LayoutGame;
import uet.oop.bomberman.levels.Level1;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.root;
import static uet.oop.bomberman.levels.NextLevel.waitLevelToUp;

public class Menu {
    public static long timeWaitLevel1 = 0;
    public static Image authorImage;
    public static Image item1,item2,item3;
    public static ImageView[] itemMenu = new ImageView[3];
    public static ImageView author;
    public static Pane layoutMenu;


    public static void creatMenu(Group root) {
        item1 = new Image("images/item1.png");
        item2 = new Image("images/item2.png");
        item3 = new Image("images/item3.png");

        authorImage = new Image("images/menu.png");
        author = new ImageView(authorImage);
        author.setX(0);
        author.setY(0);

        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                itemMenu[i] = new ImageView(item1);
                itemMenu[i].setY(250);
            }
            else if(i == 1) {
                itemMenu[i] = new ImageView(item2);
                itemMenu[i].setY(310);
            }
            else {
                itemMenu[i] = new ImageView(item3);
                itemMenu[i].setY(370);
            }

            itemMenu[i].setX(WidthView/2-100);
            itemMenu[i].setScaleY(0.9);
        }

        layoutMenu = new Pane();
        layoutMenu.getChildren().addAll(itemMenu[0],itemMenu[1],itemMenu[2]);
        layoutMenu.setMinSize(600,600);
        layoutMenu.setMaxSize(600,600);
        root.getChildren().addAll(author,layoutMenu);


        itemMenu[0].setOnMouseClicked(event -> {
            Image imageNext = new Image("images/nextLevel1.png");
            author.setImage(imageNext);
            timeWaitLevel1 = System.currentTimeMillis();
            layoutMenu.setTranslateX(-1000);
            layoutMenu.setTranslateY(-1000);
        });

        itemMenu[2].setOnMouseClicked(event->{
            stage_.close();
        });

        for(ImageView img:itemMenu) {

            img.setOnMouseEntered(event->{
                if(img.equals(itemMenu[0])) {
                    item1 = new Image("images/item1_1.png");
                    itemMenu[0].setImage(item1);
                } else if(img.equals(itemMenu[1])) {
                    item2 = new Image("images/item2_1.png");
                    itemMenu[1].setImage(item2);
                } else {
                    item3 = new Image("images/item3_1.png");
                    itemMenu[2].setImage(item3);
                }
                img.setX(WidthView/2 - 120);
            });
        }

        for(ImageView img:itemMenu) {
            img.setOnMouseExited(event->{
                if(img.equals(itemMenu[0])) {
                    item1 = new Image("images/item1.png");
                    itemMenu[0].setImage(item1);
                } else if(img.equals(itemMenu[1])) {
                    item2 = new Image("images/item2.png");
                    itemMenu[1].setImage(item2);
                } else {
                    item3 = new Image("images/item3.png");
                    itemMenu[2].setImage(item3);
                }
                img.setX(WidthView/2 - 100);
            });
        }
    }
}
