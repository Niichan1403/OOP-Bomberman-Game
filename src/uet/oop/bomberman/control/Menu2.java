package uet.oop.bomberman.control;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.creatMenu;
import static uet.oop.bomberman.graphics.LayoutGame.coin;
import static uet.oop.bomberman.graphics.LayoutGame.heart;
import static uet.oop.bomberman.control.Menu.timeWaitLevel1;

public class Menu2 {
    public static Rectangle rect1;
    public static Text textMenu2[] = new Text[4];
    private static boolean checkCreate;
    public static void creatMenu2 () {
        rect1 = new Rectangle();
        rect1.setWidth(400);
        rect1.setHeight(300);
        rect1.setArcHeight(20);
        rect1.setArcWidth(20);
        rect1.setX(WidthView / 2 - 39/2 - rect1.getWidth()/2);
        rect1.setY(80);
        rect1.setFill(Color.rgb(75,75,75));

        for(int i = 0; i < 4; i++) {
            textMenu2[i] = new Text();
            if(i == 0) {
                textMenu2[i].setText("Resume");
                textMenu2[i].setX(510);
                textMenu2[i].setY(180);
            } else if(i == 1) {
                textMenu2[i].setText("Sounds");
                textMenu2[i].setX(510);
                textMenu2[i].setY(230);
            } else if(i == 2) {
                textMenu2[i].setText("Menu");
                textMenu2[i].setX(520);
                textMenu2[i].setY(280);
            } else if(i == 3) {
                textMenu2[i].setText("Quit");
                textMenu2[i].setX(525);
                textMenu2[i].setY(330);
            }
            textMenu2[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,27));
            textMenu2[i].setFill(Color.WHITE);
        }

        root.getChildren().addAll(rect1,textMenu2[0],textMenu2[1],textMenu2[2],textMenu2[3]);
        checkCreate = true;

    }

    public static boolean getCheckCreateMenu2() {
        return checkCreate;
    }

    public static void setCheckCreateMenu2(boolean checkCreate_) {checkCreate = checkCreate_;}

    public static void updateMenu2() {
        textMenu2[0].setOnMouseClicked(event->{
            rect1.setY(500);
            for(int i = 0; i < 4; i++) {
                textMenu2[i].setY(500);
            }
            running = true;
        });

        textMenu2[2].setOnMouseClicked(event->{
            running = false;
            timeWaitLevel1 = 0;
            level_ = 0;
            heart = 0;
            coin = 0;
            block.clear();
            enemy.clear();
            rect1.setY(500);
            for(int i = 0; i < 4; i++) {
                textMenu2[i].setY(500);
                setCheckCreateMenu2(false);
            }
            creatMenu(root);
        });

        textMenu2[3].setOnMouseClicked(event->{
            stage_.close();
        });

        for(Text text:textMenu2) {
            text.setOnMouseEntered(event->{
                text.setFill(Color.BLUE);
            });
        }

        for(Text text: textMenu2) {
            text.setOnMouseExited(event->{
                text.setFill(Color.WHITE);
            });
        }
    }
}
