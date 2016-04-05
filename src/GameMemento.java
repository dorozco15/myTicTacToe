/**
 * Created by DanDan on 2016-04-05.
 */
public class GameMemento {
    private ArrayList2D board;

    public GameMemento (ArrayList2D boardIn){
        board = boardIn;
    }
    public ArrayList2D getState(){
        return board;
    }

}
