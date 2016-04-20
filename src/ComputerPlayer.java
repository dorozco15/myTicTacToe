/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.ArrayList;

import java.util.List;
public class ComputerPlayer {
    GameBoard myGameBoard;
    ComputerStrategy strategy;

    List<GameMove> computerMoves = new ArrayList<GameMove>();

    //constructor
    public ComputerPlayer (GameBoard gameBoardIn){
        myGameBoard = gameBoardIn;
        setStrategyChain();
        strategy = StrategyFactory.getFactory(1).createProduct();

    }
    public GameBoard makeComputerMove(){
        System.out.println("strategy.computeMove(myGameBoard)");
        return strategy.computeMove(myGameBoard);
    }

    //this method simpply assigns the nextStrategy for each of the Strategy Objects
    private void setStrategyChain(){
        for (int i=1; i <5; i++){
            strategy = StrategyFactory.getFactory(i).createProduct();
            strategy.setNextChain(StrategyFactory.getFactory(i+1).createProduct());
        }
    }
}
