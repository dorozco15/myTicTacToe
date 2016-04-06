/**
 * Created by DanDan on 2016-04-06.
 */
public class GameStatus {

    private boolean playerWon;
    private boolean computerWon;
    private boolean tie;
    private static GameStatus singleton = null;

    private GameStatus (){

    }

    public static GameStatus getInstance(){
        if (singleton == null){
            singleton = new GameStatus();
        }
        return singleton;
    }

    public void setPlayerWon(boolean in){
        playerWon = in;
    }
    public void setComputerWon(boolean in){
        computerWon = in;
    }
    public void setTie(boolean in){
        tie = in;
    }
    public boolean getPlayerWon(){
        return playerWon;
    }
    public boolean getComputerWon(){
        return computerWon;
    }
    public boolean getTie(){
        return tie;
    }

}
