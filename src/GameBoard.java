/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.Stack;
public class GameBoard {
    private ArrayList2D board ;
    private int computerMoveCount ;
    private int playerMoveCount ;
    private int numberOfTurns ;
    private MoveCreator ccc;
    private Stack<GameMove> playerMoves = new Stack<GameMove>();

    //constructor
    public GameBoard (){
        board = new ArrayList2D();
        computerMoveCount =0;
        playerMoveCount = 0;
        numberOfTurns = 0;
        ccc = new MoveCreator0();

        for (int y = 0; y<3 ; y++){
            for (int x=0; x<3; x++){
                board.set(x,y, ccc.create(x,y));
                System.out.print(ccc.create(x,y).getID());
            }
        }
    }
    public void setPeice(GameMove move){
        board.set(move.getX(), move.getY(), move);
        if (move.getID()== 1){
            playerMoveCount++;
            playerMoves.push(move);
        }
        if (move.getID()==2){
            computerMoveCount++;
        }
        numberOfTurns++;

    }
    public GameMove checkPiece(int x, int y ){
        if (board.get(x,y)!= null) {
            return (GameMove) board.get(x, y);
        }
        return null;
    }
    public Integer getplayerID (int x, int y){
        if (checkPiece(x,y)!= null) {
            return checkPiece(x, y).getID();
        }
        return null;
    }
    public int getPlayerMoveCount(){
        return playerMoveCount;
    }
    public int getComputerMoves(){
        return computerMoveCount;
    }
    public Stack getPlayerMoves(){
        return playerMoves;
    }
    public int getNumberOfTurns(){
        return numberOfTurns;
    }
    public GameMemento storeInMemento(){
        //print saving to memento
        return new GameMemento(this);
    }
}
