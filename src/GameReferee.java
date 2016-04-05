/**
 * Created by DanDan on 2016-04-05.
 */
public class GameReferee {

    GameBoard myGameBoard;

    //constructor
    public GameReferee(GameBoard gameBoardIn){
        myGameBoard = gameBoardIn;

    }
    public void checkGameStatus(){


    }
    public boolean checkLegalMove(GameMove move){
        GameMove tempMove = myGameBoard.checkPiece(move.getX(), move.getY());
        if (tempMove == null){
            return true;
        }
        else{
            return false;
        }
    }
}
