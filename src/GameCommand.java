/**
 * Created by DanDan on 2016-04-04.
 */
public class GameCommand implements Command{

    private GameLogic myGameLogic;

    public GameCommand(GameLogic gameLogicIn){
        myGameLogic = gameLogicIn;
    }

    @Override
    public void execute(GameMove move) {

    }

    @Override
    public void unexecute(GameMove move) {

    }

}
