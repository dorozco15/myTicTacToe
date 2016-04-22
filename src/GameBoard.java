/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.Stack;
public class GameBoard {
    protected ArrayList2D board ;
    protected int computerMoveCount ;
    protected int playerMoveCount ;
    protected int numberOfTurns ;
    private MoveCreator ccc;
    protected Stack<GameMove> playerMoves = new Stack<GameMove>();
    private GameMove s1,s2,s3,s4,s5,s6,s7,s8,s9;

    //constructor
    public GameBoard (){
        board = new ArrayList2D();
        computerMoveCount =0;
        playerMoveCount = 0;
        numberOfTurns = 0;
        ccc = new MoveCreator0();
        s1 = ccc.createMove(0,0);
        s2 = ccc.createMove(1,0);
        s3 = ccc.createMove(2,0);
        s4 = ccc.createMove(0,1);
        s5 = ccc.createMove(1,1);
        s6 = ccc.createMove(2,1);
        s7 = ccc.createMove(0,2);
        s8 = ccc.createMove(1,2);
        s9 = ccc.createMove(2,2);
        setPeice(s1);
        setPeice(s2);
        setPeice(s3);
        setPeice(s4);
        setPeice(s5);
        setPeice(s6);
        setPeice(s7);
        setPeice(s8);
        setPeice(s9);

    }
    public void setPeice(GameMove move){
        //System.out.println("set move: " + move.getX()+ " "+ move.getY());
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
        GameMove move = (GameMove) board.get(x,y);
        //System.out.println(move.getID());
        return move;

    }
    public Integer getplayerID (int x, int y){
        if (checkPiece(x,y)!= null) {
            return checkPiece(x, y).getID();
        }
        else {
            return null;
        }
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
        GameBoard savedBoard = new GameBoard();
        for (int y= 0; y<3;y++){
            for(int x=0;x<3;x++){
                savedBoard.board.set(x,y,this.checkPiece(x,y));
            }
        }
        savedBoard.playerMoveCount = this.playerMoveCount;
        savedBoard.computerMoveCount = this.computerMoveCount;
        savedBoard.numberOfTurns = this.numberOfTurns;
        savedBoard.playerMoves = this.playerMoves;
        return new GameMemento(savedBoard);
    }
}
