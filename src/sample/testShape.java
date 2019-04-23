package sample;

import java.util.Map;
import java.util.Scanner;

//JavaFx part
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import static sample.Controller.dao;

public class testShape extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Eksamiks kordamine");
        primaryStage.setScene(new Scene(root, 550, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        String name;
        Float voolutugevus;
        Float pinge;
        Float takisti;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta number, Voolutugevus, pinge ja takistus!");
        name = scanner.nextLine();
        voolutugevus = scanner.nextFloat();
        pinge = scanner.nextFloat();
        takisti = scanner.nextFloat();
        scanner.close();
        Vooluring vooluring = new Vooluring(name, voolutugevus, pinge, takisti);
        vooluring.give_info();

        SQLDao dao = new SQLDao();
        Map<String, Vooluring> data = dao.selectAll();
        Vooluring sqlVooluring = data.get("1");
        sqlVooluring.give_info();


        launch(args);

    }
}