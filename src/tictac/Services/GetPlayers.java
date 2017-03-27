package tictac.Services;

/**
 * Created by siirsalvador on 3/24/2017.
 */
public class GetPlayers {
    private Player player1;
    private Player player2;
    private static GetPlayers ourInstance = new GetPlayers();

    public static GetPlayers getInstance() {
        return ourInstance;
    }

    private GetPlayers() {
    }


    public Player player1(){
        player1=new Player("X");
        return player1;
    }

    public Player player2(){
        player2=new Player("O");
        return player2;
    }

}
