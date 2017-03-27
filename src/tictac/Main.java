package tictac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu/start.fxml"));
        primaryStage.setTitle("TicTac Using JavaFX");
        primaryStage.getIcons().add(new Image("file:src/close_fav.png"));
        primaryStage.setScene(new Scene(root, 550, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
