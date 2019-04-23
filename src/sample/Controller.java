
//Controller
package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Controller {

    @FXML
    Canvas joonis = new Canvas();
    @FXML
    CheckBox check1 = new CheckBox();


    private static boolean drawn1 = false;

    //Connect to Database and get info
    static SQLDao dao = new SQLDao();
    static Map<String, sample.Vooluring> data = dao.selectAll();
    static sample.Vooluring Vooluring = data.get("1");



    public void vajuta(MouseEvent event) {

        GraphicsContext gc = joonis.getGraphicsContext2D();
        gc.setFill(Color.BLACK);


        if (check1.isSelected()) {
            if (!drawn1) {
                drawn1 = true;
                gc.fillText(" id:" + Vooluring.name + "  Voolutugevus: " + Vooluring.Voolutugevus +"A ,"+"  Pinge: " + Vooluring.pinge+"V ,"+ "Takisti: "+Vooluring.takisti+"Ω", 100, 400);
                DrawRoom(gc);
            }
        }
//
    }

    private static void DrawRoom(GraphicsContext gc) {

        gc.setFill(Color.BLACK);

        gc.fillRect(100,100, 1,70);//vasak sein
        gc.fillRect(100,100, 50,1);//ylemine parem sein
        gc.fillRect(130, 90, 1, 20);//vooluallikas
        gc.fillRect(132, 85, 1, 30);//vooluallikas
        gc.strokeLine(170,100,150,90);//lyliti
        gc.fillRect(170,100, 50,1);
        gc.fillRect(220,100, 1,70);
        gc.fillRect(100,170, 120,1);
        gc.strokeRect(140,160, 40,20);
        gc.fillOval(130,168, 4,4);
        gc.fillOval(190,168, 4,4);
        gc.fillRect(131,168,1, 40);
        gc.fillRect(191,168,1, 40);
        gc.fillRect(131,208,60, 1);
        gc.strokeOval(85, 120, 30,30);//A
        gc.strokeOval(147, 193, 30,30);//V
        gc.fillText("A", 96, 140,200);
        gc.fillText("V", 158, 213,200);



    }

    private static void DrawRoomColor(GraphicsContext gc) {
    }

    @FXML
    public void liiguta(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            GraphicsContext gc = joonis.getGraphicsContext2D();
            gc.fillRect(100,100, 50,3);//ylemine parem sein
            gc.strokeLine(170,100,150,90);//lyliti
            gc.strokeLine(171,101,151,91);//lyliti
            gc.strokeLine(172,102,152,92);//lyliti
            gc.fillRect(170,100, 50,3);

        }


    }

    public void initialize() {
        GraphicsContext gc = joonis.getGraphicsContext2D();
        DrawRoom(gc);
    }
}