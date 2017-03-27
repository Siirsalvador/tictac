package tictac.Services;

/**
 * Created by siirsalvador on 3/24/2017.
 */
public class Player {

    String playername;
    String playerset;

    protected Player(String playerset) {
        this.playerset = playerset;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayername() {
        return playername;
    }

    public String getPlayerset() {
        return playerset;
    }
}
