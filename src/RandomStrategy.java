/**
 * Created by DanDan on 2016-04-07.
 */
import java.util.Random;
import java.util.ArrayList;

public class RandomStrategy implements ComputerStrategy{
    private GameBoard myGameBoard;
    private ComputerStrategy nextStrategy;
    private MoveCreator moveCreator = new MoveCreator2();
    private ArrayList<GameMove> possibleMoves = new ArrayList<GameMove>();

    @Override
    public void setNextChain(ComputerStrategy nextStrategyIn) {
        this.nextStrategy = nextStrategyIn;
    }

    @Override
    public GameBoard computeMove(GameBoard boardIn) {
        myGameBoard = boardIn;

        Random rand = new Random();
        int  n = rand.nextInt(2) ;
        for (int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                if (myGameBoard.checkPiece(i,j).getID()==0){
                    GameMove move = moveCreator.createMove(i,j);
                    possibleMoves.add(move);
                }
            }
        }
        n = rand.nextInt(possibleMoves.size()-1);
        GameMove move = possibleMoves.get(n);
        myGameBoard.setPeice(move);
        return myGameBoard;
    }
}
