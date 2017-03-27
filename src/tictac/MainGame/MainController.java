package tictac.MainGame;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import tictac.Services.GetPlayers;
import tictac.Services.Player;

import java.util.ArrayList;

public class MainController {

    @FXML Label top_left;
    @FXML Label top_center;
    @FXML Label top_right;
    @FXML Label left;
    @FXML Label center;
    @FXML Label right;
    @FXML Label bottom_left;
    @FXML Label bottom_center;
    @FXML Label bottom_right;
    @FXML Label user_score_one;
    @FXML Label user_score_two;

    int score_one;
    int score_two;

    private Player player1;
    private Player player2;

    static String player1_name;
    static String player2_name;
    String name;
    String playerset;
    int player1plays=0;
    int player2plays=0;

    ArrayList<Label>list;

    public void setPlayer1_name(String player1_name) {
        this.player1_name = player1_name;
    }

    public void setPlayer2_name(String player2_name) {
        this.player2_name = player2_name;
    }

    @FXML
    public void initialize() {
        player1= GetPlayers.getInstance().player1();
        player2=GetPlayers.getInstance().player2();

        player1.setPlayername(player1_name);
        player2.setPlayername(player2_name);


        list=new ArrayList<>();
        list.add(top_left);
        list.add(top_center);
        list.add(top_right);
        list.add(left);
        list.add(center);
        list.add(right);
        list.add(bottom_left);
        list.add(bottom_center);
        list.add(bottom_right);
        for (Label l:list){
            setListener(l);
        }
    }


    public void setListener(Label label){
        String text=label.getText();
        label.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (!label.getText().isEmpty()){
                    System.out.println("Spot taken!");
                }
                else if (text.isEmpty()){
                        if(player1plays==0){
                            player1_turn();
                        }
                        else if (player1plays > player2plays) {
                            player2_turn();
                        } else if (player2plays > player1plays) {
                            player1_turn();
                        }
                        else if (player1plays==player2plays){
                            player1_turn();
                        }

                        setValue(label, playerset);
                        checkwinner(playerset,name);
//                    System.out.println(name);
                }
            }
        });
    }

    public void setValue(Label label, String playerset){
        label.setText(playerset);
    }


    public void player1_turn(){
        name=player1.getPlayername();
        playerset=player1.getPlayerset();
        player1plays+=1;
    }

    public void player2_turn(){
        name=player2.getPlayername();
        playerset=player2.getPlayerset();
        player2plays+=1;
    }


    public void checkwinner(String XorO, String name){
        if(top_left.getText().equals(XorO)&&top_center.getText().equals(XorO)&&top_right.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(left.getText().equals(XorO)&&center.getText().equals(XorO)&&right.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(bottom_left.getText().equals(XorO)&&bottom_center.getText().equals(XorO)&&bottom_right.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(top_left.getText().equals(XorO)&&left.getText().equals(XorO)&&bottom_left.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(top_center.getText().equals(XorO)&&center.getText().equals(XorO)&&bottom_center.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(top_right.getText().equals(XorO)&&right.getText().equals(XorO)&&bottom_right.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(top_left.getText().equals(XorO)&&center.getText().equals(XorO)&&bottom_right.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }
        if(top_right.getText().equals(XorO)&&center.getText().equals(XorO)&&bottom_left.getText().equals(XorO)){
            alertbox(name.toUpperCase()+" WINS!");
            checkplayer(name);
            newGame();
        }


    }

    public void setScores(String name, int score){
        user_score_one.setText(name+": "+String.valueOf(score));
    }

    public void checkplayer(String name){
        if (name.equals(player1.getPlayername())){
            score_one+=1;
            setScores(name,score_one);
        }
        else if (name.equals(player2.getPlayername())){
            score_two+=1;
            setScores(name,score_two);
        }
    }

    public void newGame(){
        for (Label l:list){
            l.setText("");
        }
    }

    public void alertbox(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TicTac");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();

    }



}
