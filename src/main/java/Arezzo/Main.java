package Arezzo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("top.fxml"));
        root.setTop(fxmlLoader.load());

        fxmlLoader = new FXMLLoader(Main.class.getResource("centre.fxml"));
        root.setCenter(fxmlLoader.load());

        fxmlLoader = new FXMLLoader(Main.class.getResource("bottom.fxml"));
        root.setBottom(fxmlLoader.load());

        Scene scene = new Scene(root, 1280, 720);


        stage.setTitle("Arezzo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}