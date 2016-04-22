/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.ArrayList;

import java.util.List;
public class ComputerPlayer {
    GameBoard myGameBoard;
    ComputerStrategy winStrategy, noLoseStrategy, smartStrategy, randomStrategy;

    List<GameMove> computerMoves = new ArrayList<GameMove>();

    //constructor
    public ComputerPlayer (GameBoard gameBoardIn){
        myGameBoard = gameBoardIn;

        winStrategy = StrategyFactory.getFactory(1).createProduct();
        noLoseStrategy = StrategyFactory.getFactory(2).createProduct();
        smartStrategy = StrategyFactory.getFactory(3).createProduct();
        randomStrategy = StrategyFactory.getFactory(4).createProduct();
        winStrategy.setNextChain(noLoseStrategy);
        noLoseStrategy.setNextChain(smartStrategy);
        smartStrategy.setNextChain(randomStrategy);
        //setStrategyChain();

    }
    public GameMove makeComputerMove(){
        System.out.println("strategy.computeMove(myGameBoard)");
        return winStrategy.computeMove(myGameBoard);

    }


}
