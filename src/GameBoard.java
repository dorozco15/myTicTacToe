/**
 * Created by DanDan on 2016-04-05.
 */
public class GameBoard {
    ArrayList2D board ;


    //constructor
    public GameBoard (){
        board = new ArrayList2D();

    }
    public void setPeice(GameMove move){
        board.set(move.getX(), move.getY(), move);
    }
    public GameMove checkPiece(int x, int y ){
        return (GameMove)board.get(x,y);
    }
    public int getplayerID (int x, int y){
        return checkPiece(x,y).getID();
    }

    public GameMemento storeInMemento(){
        //print saving to memento
        return new GameMemento(this);
    }
}
