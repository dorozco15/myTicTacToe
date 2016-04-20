/**
 * Created by DanDan on 2016-04-05.
 */
public class GameMove {
    private int X, Y;
    private int playerID;
    private Coordinates up, down, left, right, upLeft, upRight, downLeft, downRight ;
    //constructor
    public GameMove(int iDIn, int x, int y){
        playerID = iDIn;
        this.X = x;
        this.Y = y;

    }

    public void setMoveLocation(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public void setPlayerID (int id){
        playerID = id;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public int getID(){
        return playerID;
    }

}
