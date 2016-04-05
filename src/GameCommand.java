/**
 * Created by DanDan on 2016-04-04.
 */
import java.util.ArrayList;
public class GameCommand implements Command{

    private GameLogic myGameLogic;
    private GameMemento savedGameBoard;

    public GameCommand(GameLogic gameLogicIn, GameMemento m){

        myGameLogic = gameLogicIn;
        savedGameBoard = m;
    }
    public void setMemento(GameMemento m){
        savedGameBoard = m;
    }

    public GameMemento getMemento(){
        return savedGameBoard;
    }
    @Override
    public void execute(GameMove move) {

    }

    @Override
    public void unexecute(GameMove move) {

    }

}
