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
import uet.oop.bomberman.control.Menu2;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu2.*;

public class LayoutGame {
    public static Pane pane;
    public static int boom = 0, heart = 0, coin = 0, enemy1Number = 0, enemy2Number = 0;
    public static ImageView status;
    public static ImageView[] bom = new ImageView[3];
    public static Rectangle[] rect_bom1 = new Rectangle[3];
    public static Rectangle[] rect_bom2 = new Rectangle[3];
    public static Rectangle[] rect_bom3 = new Rectangle[3];
    public static ImageView bomberImage, enemy1Image, enemy2Image;
    public static Text level, runTime, bomberman, quit;
    public static Text[] objectText = new Text[3];

    public static Text[] textBox1 = new Text[3];
    public static Text[] textBox2 = new Text[3];
    public static Text[] textBox3 = new Text[3];
    public static int timeNumber = 120;

    public static Rectangle[] rect_ = new Rectangle[6];
    public static void createLayout(Group root) {
        level = new Text("Level: " + level_);
        level.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        level.setFill(Color.WHITE);
        level.setX(400);
        level.setY(28);

        runTime = new Text("Times: " + timeNumber);
        runTime.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        runTime.setFill(Color.WHITE);
        runTime.setX(650);
        runTime.setY(28);

        bomberman = new Text("Bomberman Game ");
        bomberman.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,20));
        bomberman.setFill(Color.WHITE);
        bomberman.setX(15);
        bomberman.setY(28);

        quit = new Text("Menu");
        quit.setX(1036);
        quit.setY(436);
        quit.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,22));
        quit.setFill(Color.rgb(75,75,75));

        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                objectText[i] = new Text( "Bomber");
                objectText[i].setX(1010);
                objectText[i].setY(145);
            }
            else if(i == 1) {
                objectText[i] = new Text("Ballom");
                objectText[i].setX(1013);
                objectText[i].setY(265);
            }
            else {
                objectText[i] = new Text("Oneal");
                objectText[i].setX(1015);
                objectText[i].setY(385);
            }
            objectText[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,13));
            objectText[i].setFill(Color.rgb(75,75,75));
        }



        Image pauseGame = new Image("images/pauseGame.png");
        status = new ImageView(pauseGame);
        status.setX(800);
        status.setY(-5);
        status.setScaleX(0.54);
        status.setScaleY(0.54);

        rect_[0] = new Rectangle();
        rect_[0].setWidth(100);
        rect_[0].setHeight(28);
        rect_[0].setFill(Color.rgb(220,220,220));
        rect_[0].setX(1013);
        rect_[0].setY(415);
        rect_[0].setStroke(Color.rgb(105,105,105));
        rect_[0].setStrokeWidth(2);
        rect_[0].setArcWidth(5);
        rect_[0].setArcHeight(5);

        for(int i=1;i<=3;i++) {
            rect_[i] = new Rectangle();
            if(i == 1) {
                rect_[i].setY(60);
            }
            else if(i == 2) {
                rect_[i].setY(180);
            }
            else {
                rect_[i].setY(300);
            }

            rect_[i].setWidth(120);
            rect_[i].setHeight(100);
            rect_[i].setArcWidth(30);
            rect_[i].setArcHeight(30);
            rect_[i].setX(1003);
            rect_[i].setFill(Color.WHITE);
            rect_[i].setStroke(Color.rgb(105,105,105));
            rect_[i].setStrokeWidth(2);
        }

        Image bomberImage_ = new Image("images/player1.png");
        bomberImage = new ImageView(bomberImage_);
        bomberImage.setX(1005);
        bomberImage.setY(70);
        bomberImage.setScaleX(0.9);
        bomberImage.setScaleY(0.9);

        Image ballImage_ = new Image("images/ballom1.png");
        enemy1Image = new ImageView(ballImage_);
        enemy1Image.setX(1005);
        enemy1Image.setY(195);
        enemy1Image.setScaleX(0.85);
        enemy1Image.setScaleY(0.85);

        Image onealImage_ = new Image("images/oneal.png");
        enemy2Image = new ImageView(onealImage_);
        enemy2Image.setX(1005);
        enemy2Image.setY(316);
        enemy2Image.setScaleX(0.85);
        enemy2Image.setScaleY(0.85);

        for(int i = 0; i < 3; i++) {
            Image bomImage = new Image("images/a.png");
            bom[i] = new ImageView(bomImage);
            bom[i].setX(1060);
            if(i == 0) {
                bom[i].setY(53);
            }
            else if(i == 1) {
                bom[i].setY(173);
            }
            else {
                bom[i].setY(293);
            }
        }

        for(int i=0;i<3;i++) {
            rect_bom1[i] = new Rectangle();
            if(i == 0) {
                textBox1[i] = new Text(": " + coin);
                textBox1[i].setY(84);
                rect_bom1[i].setY(67);
            }
            else if(i == 1) {
                textBox1[i] = new Text(": " + heart);
                textBox1[i].setY(117);
                rect_bom1[i].setY(100);
            }
            else {
                textBox1[i] = new Text(": " + boom);
                textBox1[i].setY(149);
                rect_bom1[i].setY(132);
            }

            rect_bom1[i].setWidth(50);
            rect_bom1[i].setHeight(23);
            rect_bom1[i].setArcWidth(15);
            rect_bom1[i].setArcHeight(15);
            rect_bom1[i].setX(1063);
            rect_bom1[i].setFill(Color.WHITE);
            rect_bom1[i].setStroke(Color.rgb(105,105,105));
            rect_bom1[i].setStrokeWidth(2);

            textBox1[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,15));
            textBox1[i].setFill(Color.rgb(75,75,75));
            textBox1[i].setX(1085);
        }

        for(int i=0;i<3;i++) {
            rect_bom2[i] = new Rectangle();
            if(i == 0) {
                textBox2[i] = new Text(": 0");
                textBox2[i].setY(204);
                rect_bom2[i].setY(187);
            }
            else if(i == 1) {
                textBox2[i] = new Text(": " + enemy1Number);
                textBox2[i].setY(236);
                rect_bom2[i].setY(220);
            }
            else {
                textBox2[i] = new Text(": 0");
                textBox2[i].setY(269);
                rect_bom2[i].setY(252);
            }

            rect_bom2[i].setWidth(50);
            rect_bom2[i].setHeight(23);
            rect_bom2[i].setArcWidth(15);
            rect_bom2[i].setArcHeight(15);
            rect_bom2[i].setX(1063);
            rect_bom2[i].setFill(Color.WHITE);
            rect_bom2[i].setStroke(Color.rgb(105,105,105));
            rect_bom2[i].setStrokeWidth(2);

            textBox2[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,15));
            textBox2[i].setFill(Color.rgb(75,75,75));
            textBox2[i].setX(1085);
        }

        for(int i=0;i<3;i++) {
            rect_bom3[i] = new Rectangle();
            if(i == 0) {
                textBox3[i] = new Text(": 0");
                textBox3[i].setY(324);
                rect_bom3[i].setY(307);
            }
            else if(i == 1) {
                textBox3[i] = new Text(": " + enemy2Number);
                textBox3[i].setY(356);
                rect_bom3[i].setY(340);
            }
            else {
                textBox3[i] = new Text(": 0");
                textBox3[i].setY(389);
                rect_bom3[i].setY(372);
            }

            rect_bom3[i].setWidth(50);
            rect_bom3[i].setHeight(23);
            rect_bom3[i].setArcWidth(15);
            rect_bom3[i].setArcHeight(15);
            rect_bom3[i].setX(1063);
            rect_bom3[i].setFill(Color.WHITE);
            rect_bom3[i].setStroke(Color.rgb(105,105,105));
            rect_bom3[i].setStrokeWidth(2);

            textBox3[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,15));
            textBox3[i].setFill(Color.rgb(75,75,75));
            textBox3[i].setX(1085);
        }

        Pane pane = new Pane();
        pane.getChildren().addAll(bomberman,level,runTime,status,rect_[1],rect_[2],rect_[3],rect_[0],quit,bomberImage,enemy1Image,enemy2Image,rect_bom1[0],rect_bom1[1],rect_bom1[2],rect_bom2[0],rect_bom2[1],rect_bom2[2],rect_bom3[0],rect_bom3[1],rect_bom3[2],bom[0],bom[1],bom[2],objectText[0],objectText[1],objectText[2]
                ,textBox1[0],textBox1[1],textBox1[2],textBox2[0],textBox2[1],textBox2[2],textBox3[0],textBox3[1],textBox3[2]);
        pane.setMinSize(1140,40 );
        pane.setMaxSize(1140, 40);
        pane.setStyle("-fx-background-color: #353535");
        root.getChildren().add(pane);
    }


    public static void updateLayout() {
        level.setText("Level: " + level_);
        textBox1[1].setText(": " + heart);
        textBox1[2].setText(": " + boom);
        textBox1[0].setText(": " + coin);
        textBox2[1].setText(": " + enemy1Number);
        textBox3[1].setText(": " + enemy2Number);

        status.setOnMouseClicked(mouseEvent -> {
            if(running) {
                Image playGame = new Image("images/playGame.png");
                status.setImage(playGame);
                running = false;
            }
            else {
                Image pauseGame = new Image("images/pauseGame.png");
                status.setImage(pauseGame);
                running = true;
            }
        });

        rect_[0].setOnMouseClicked(event->{
            if(running) {
                if(!Menu2.getCheckCreateMenu2()) {
                    Menu2.creatMenu2();
                    Menu2.updateMenu2();
                    running = false;
                } else {
                    rect1.setY(80);
                    for(int i = 0; i < 4; i++) {
                        textMenu2[i].setY(180 + i * 50);
                    }
                    Menu2.updateMenu2();
                    running = false;
                }
            } else {
                rect1.setY(500);
                for(int i = 0; i < 4; i++) {
                    textMenu2[i].setY(500);
                }
                running = true;
            }
        });

        quit.setOnMouseClicked(event->{
            if(running) {
                if(!Menu2.getCheckCreateMenu2()) {
                    Menu2.creatMenu2();
                    Menu2.updateMenu2();
                    running = false;
                } else {
                    rect1.setY(80);
                    for(int i = 0; i < 4; i++) {
                        textMenu2[i].setY(180 + i * 50);
                    }
                    Menu2.updateMenu2();
                    running = false;
                }
            } else {
                rect1.setY(500);
                for(int i = 0; i < 4; i++) {
                    textMenu2[i].setY(500);
                }
                running = true;
            }
        });
    }
}
