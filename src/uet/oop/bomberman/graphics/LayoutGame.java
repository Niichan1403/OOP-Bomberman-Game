package uet.oop.bomberman.graphics;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static uet.oop.bomberman.BombermanGame.level_;
import static uet.oop.bomberman.BombermanGame.running;

public class LayoutGame {
    public static ImageView status;
    public static ImageView bom[] = new ImageView[3];
    public static Rectangle rect_bom1[] = new Rectangle[3];
    public static Rectangle rect_bom2[] = new Rectangle[3];
    public static Rectangle rect_bom3[] = new Rectangle[3];
    public static ImageView bomberImage,ballomImage,onealImage;
    public static Text level,runTime,bomberman,quit;
    public static Text objectText[] = new Text[3];
    public static int timeNumber = 120;

    public static Rectangle rect_[] = new Rectangle[6];
    public static void createLayout(Group root) {
        level = new Text("Level: " + level_);
        level.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        level.setFill(Color.WHITE);
        level.setX(400);
        level.setY(35);

        runTime = new Text("Times: " + timeNumber);
        runTime.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        runTime.setFill(Color.WHITE);
        runTime.setX(650);
        runTime.setY(35);

        bomberman = new Text("Bomberman Game ");
        bomberman.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        bomberman.setFill(Color.WHITE);
        bomberman.setX(15);
        bomberman.setY(35);

        quit = new Text("Quit!");
        quit.setX(1036);
        quit.setY(458);
        quit.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,23));
        quit.setFill(Color.rgb(75,75,75));

        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                objectText[i] = new Text( "Bomber");
                objectText[i].setX(1010);
                objectText[i].setY(165);
            }
            else if(i == 1) {
                objectText[i] = new Text("Ballom");
                objectText[i].setX(1013);
                objectText[i].setY(285);
            }
            else {
                objectText[i] = new Text("Oneal");
                objectText[i].setX(1015);
                objectText[i].setY(405);
            }
            objectText[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,13));
            objectText[i].setFill(Color.rgb(75,75,75));
        }



        Image pauseGame = new Image("images/pauseGame.png");
        status = new ImageView(pauseGame);
        status.setX(800);
        status.setY(5);
        status.setScaleX(0.55);
        status.setScaleY(0.55);

        rect_[0] = new Rectangle();
        rect_[0].setWidth(100);
        rect_[0].setHeight(30);
        rect_[0].setFill(Color.rgb(220,220,220));
        rect_[0].setX(1013);
        rect_[0].setY(435);
        rect_[0].setStroke(Color.rgb(105,105,105));
        rect_[0].setStrokeWidth(2);
        rect_[0].setArcWidth(5);
        rect_[0].setArcHeight(5);

        for(int i=1;i<=3;i++) {
            rect_[i] = new Rectangle();
            if(i == 1) {
                rect_[i].setY(80);
            }
            else if(i == 2) {
                rect_[i].setY(200);
            }
            else {
                rect_[i].setY(320);
            }

            rect_[i].setWidth(120);
            rect_[i].setHeight(100);
            rect_[i].setArcWidth(30);
            rect_[i].setArcHeight(30);
            rect_[i].setX(1003);
            rect_[i].setFill(Color.WHITE);
            rect_[i].setStroke(Color.PINK);
            rect_[i].setStrokeWidth(3);
        }

        Image bomberImage_ = new Image("images/player.png");
        bomberImage = new ImageView(bomberImage_);
        bomberImage.setX(1010);
        bomberImage.setY(90);

        Image ballImage_ = new Image("images/ballom1.png");
        ballomImage = new ImageView(ballImage_);
        ballomImage.setX(1005);
        ballomImage.setY(215);

        Image onealImage_ = new Image("images/oneal.png");
        onealImage = new ImageView(onealImage_);
        onealImage.setX(1005);
        onealImage.setY(336);






        for(int i = 0; i < 3; i++) {
            Image bomImage = new Image("images/a.png");
            bom[i] = new ImageView(bomImage);
            bom[i].setX(1060);
            if(i == 0) {
                bom[i].setY(73);
            }
            else if(i == 1) {
                bom[i].setY(193);
            }
            else {
                bom[i].setY(313);
            }
        }

        for(int i=0;i<3;i++) {
            rect_bom1[i] = new Rectangle();
            if(i == 0) {
                rect_bom1[i].setY(87);
            }
            else if(i == 1) {
                rect_bom1[i].setY(120);
            }
            else {
                rect_bom1[i].setY(152);
            }

            rect_bom1[i].setWidth(50);
            rect_bom1[i].setHeight(23);
            rect_bom1[i].setArcWidth(15);
            rect_bom1[i].setArcHeight(15);
            rect_bom1[i].setX(1063);
            rect_bom1[i].setFill(Color.WHITE);
            rect_bom1[i].setStroke(Color.PINK);
            rect_bom1[i].setStrokeWidth(3);
        }

        for(int i=0;i<3;i++) {
            rect_bom2[i] = new Rectangle();
            if(i == 0) {
                rect_bom2[i].setY(207);
            }
            else if(i == 1) {
                rect_bom2[i].setY(240);
            }
            else {
                rect_bom2[i].setY(272);
            }

            rect_bom2[i].setWidth(50);
            rect_bom2[i].setHeight(23);
            rect_bom2[i].setArcWidth(15);
            rect_bom2[i].setArcHeight(15);
            rect_bom2[i].setX(1063);
            rect_bom2[i].setFill(Color.WHITE);
            rect_bom2[i].setStroke(Color.PINK);
            rect_bom2[i].setStrokeWidth(3);
        }

        for(int i=0;i<3;i++) {
            rect_bom3[i] = new Rectangle();
            if(i == 0) {
                rect_bom3[i].setY(327);
            }
            else if(i == 1) {
                rect_bom3[i].setY(360);
            }
            else {
                rect_bom3[i].setY(392);
            }

            rect_bom3[i].setWidth(50);
            rect_bom3[i].setHeight(23);
            rect_bom3[i].setArcWidth(15);
            rect_bom3[i].setArcHeight(15);
            rect_bom3[i].setX(1063);
            rect_bom3[i].setFill(Color.WHITE);
            rect_bom3[i].setStroke(Color.PINK);
            rect_bom3[i].setStrokeWidth(3);
        }

        status.setOnMouseClicked(mouseEvent -> {
            if(running) {
                Image playGame = new Image("images/playGame.png");
                status.setImage(playGame);
                running = false;
            }
            else {
                status.setImage(pauseGame);
                running = true;
            }
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(bomberman,level,runTime,status,rect_[1],rect_[2],rect_[3],rect_[0],quit,bomberImage,ballomImage,onealImage,rect_bom1[0],rect_bom1[1],rect_bom1[2],rect_bom2[0],rect_bom2[1],rect_bom2[2],rect_bom3[0],rect_bom3[1],rect_bom3[2],bom[0],bom[1],bom[2],objectText[0],objectText[1],objectText[2]);
        pane.setMinSize(1140,60 );
        pane.setMaxSize(1140, 60);
        pane.setStyle("-fx-background-color: #353535");
        root.getChildren().add(pane);

    }
}
