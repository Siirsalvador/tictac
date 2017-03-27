package tictac.StartMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import tictac.MainGame.MainController;
import tictac.Services.GetPlayers;


import java.io.IOException;

/**
 * Created by siirsalvador on 3/24/2017.
 */
public class StartController {

    @FXML TextField player1tf;
    @FXML TextField player2tf;
    @FXML Button start;

    String player_one_name;
    String player_two_name;

    private Stage stage;
    private Parent root;

    @FXML
    public void initialize(){
        start.setDisable(true);
    }

    @FXML
    private void handleLogErs() {
        String username = player1tf.getText();
        String password = player2tf.getText();
        boolean validdata = username.isEmpty() || username.trim().isEmpty() || password.trim().isEmpty() || password.isEmpty();
        start.setDisable(validdata);
    }

    @FXML
    public void start_button_clicked(){


        player_one_name=player1tf.getText().trim();
        player_two_name=player2tf.getText().trim();

        MainController main=new MainController();
        main.setPlayer1_name(player_one_name);
        main.setPlayer2_name(player_two_name);

        stage = (Stage) start.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Maingame/mainView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
