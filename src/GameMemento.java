/**
 * Created by DanDan on 2016-04-05.
 */
public class GameMemento {
   // private ArrayList2D board;
    private GameBoard gameBoard;
    public GameMemento (GameBoard boardIn){
        gameBoard = boardIn;
    }
    public GameBoard getState(){
        return gameBoard;
    }

}
