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

public class Menu {
    public static Image authorImage;
    public static ImageView author;
    private static Text newGameText, exitText, optionsText;
    private static Text item[] = new Text[3];
    private static Rectangle rect[] = new Rectangle[3];
    public static Pane layoutMenu;


    public static void creatMenu(Group root) {
        authorImage = new Image("images/menu.png");
        author = new ImageView(authorImage);
        author.setX(0);
        author.setY(0);

        for(int i = 0;i < 3; i++) {
            item[i] = new Text();
            if(i == 0) {
                item[i].setText("New Game");
                item[i].setX(510);
                item[i].setY(280);
            }
            else if(i == 1) {
                item[i].setText("Options");
                item[i].setX(520);
                item[i].setY(340);
            }
            else {
                item[i].setText("Exit");
                item[i].setX(540);
                item[i].setY(400);
            }

            item[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,25));
            item[i].setFill(Color.WHITE);
            item[i].setStroke(Color.BLACK);
        }

        for(int i = 0; i < 3; i++) {
            rect[i] = new Rectangle();
            if(i == 0) {
                rect[i].setY(250);
            }
            else if(i == 1) {
                rect[i].setY(310);
            }
            else {
                rect[i].setY(370);
            }

            rect[i].setWidth(200);
            rect[i].setHeight(40);
            rect[i].setX(WidthView/2-rect[i].getWidth()/2);
            rect[i].setFill(Color.ORANGE);
            rect[i].setArcHeight(30);
            rect[i].setArcWidth(30);
            rect[i].setStroke(Color.WHITE);
            rect[i].setStrokeWidth(3);
        }

        layoutMenu = new Pane();
        layoutMenu.getChildren().addAll(rect[0],rect[1],rect[2],item[0],item[1],item[2]);
        layoutMenu.setMinSize(600,600);
        layoutMenu.setMaxSize(600,600);
        root.getChildren().addAll(author,layoutMenu);


        rect[0].setOnMouseClicked(event -> {
            author.setX(-1000);
            author.setY(-1000);
            layoutMenu.setTranslateX(-1000);
            layoutMenu.setTranslateY(-1000);
            running = true;
            new Level1(root);
        });

        rect[2].setOnMouseClicked(event->{
            stage_.close();
        });

        for(Rectangle Rect:rect) {
            Rect.setOnMouseEntered(event->{
                Rect.setFill(Color.rgb(127,255,0));
            });
        }

        for(Rectangle Rect:rect) {
            Rect.setOnMouseExited(event->{
                Rect.setFill(Color.ORANGE);
            });
        }
    }

}
