/**
 * Created by DanDan on 2016-04-07.
 */
public class WinAlg {
    private int ID;
    private GameBoard myGameBoard;
    public WinAlg(int playerID, GameBoard boardIn){
        myGameBoard = boardIn;
        ID = playerID;
    }
    public boolean checkWin( int x, int y){


        boolean horizontalCheck = checkHorizontal(x,y);
        boolean verticalCheck = checkVertical(x,y);
        boolean crossCheck = checkCross(x,y);
        if (horizontalCheck == true || verticalCheck == true || crossCheck== true){
            return true;
        }
        return false;
    }
    private boolean checkHorizontal(int x, int y){
        if ( x== 0){
            if (myGameBoard.checkPiece(x+1, y).getID() ==ID && myGameBoard.checkPiece(x+2, y).getID() ==ID){
                //return new Coordinates(x,y);
                return true;
            }
        }
        if(x== 1){
            if (myGameBoard.checkPiece(x-1, y).getID()==ID && myGameBoard.checkPiece(x+1,y).getID()==ID){
                //return new Coordinates(x,y);
                return true;
            }
        }
        if (x==2){
            if (myGameBoard.checkPiece(x-1, y).getID()==ID && myGameBoard.checkPiece(x-2, y).getID()==ID){
                // return new Coordinates(x, y);
                return true;
            }
        }
        return false;
    }
    private boolean checkVertical(int x, int y){
        if ( y== 0){
            if (myGameBoard.checkPiece(x, y+1).getID() ==ID && myGameBoard.checkPiece(x, y+2).getID() ==ID){
                //return new Coordinates(x,y);
                return true;
            }
        }
        if(y== 1){
            if (myGameBoard.checkPiece(x, y-1).getID()==ID && myGameBoard.checkPiece(x,y+1).getID()==ID){
                //return new Coordinates(x,y);
                return true;
            }
        }
        if (y==2){
            if (myGameBoard.checkPiece(x, y-1).getID()==ID && myGameBoard.checkPiece(x, y-2).getID()==ID){
                // return new Coordinates(x, y);
                return true;
            }
        }
        return false;
    }
    private boolean checkCross(int x, int y){
        if (x== 1&& y ==1){
            if (myGameBoard.checkPiece(0,0 ).getID()==ID && myGameBoard.checkPiece(2,2).getID()==ID){
                return true;//left top to right bottom
            }
            if (myGameBoard.checkPiece(0,2 ).getID()==ID && myGameBoard.checkPiece(2,0).getID()==ID){
                return true;//left bottom to  right top
            }
            if (myGameBoard.checkPiece(2,0 ).getID()==ID && myGameBoard.checkPiece(0,2).getID()==ID){
                return true;//right top to left bottom
            }
            if (myGameBoard.checkPiece(2,2).getID()==ID && myGameBoard.checkPiece(0,0).getID()==ID){
                return true;// right bottom to left top
            }
        }
        if (x==0 && y==0){ // left top corner
            if (myGameBoard.checkPiece(1,1).getID()==ID && myGameBoard.checkPiece(2,2).getID()==ID){
                return true;
            }
        }
        if(x==0 && y ==2){// left bottom corner
            if (myGameBoard.checkPiece(1,1 ).getID()==ID && myGameBoard.checkPiece(2,0).getID()==ID){
                return true;
            }
        }
        if (x==2 && y==2){ // right bottom corner
            if (myGameBoard.checkPiece(1,1 ).getID()==ID && myGameBoard.checkPiece(0,0).getID()==ID){
                return true;
            }
        }
        if (x==2 && y==0){ // right top corner
            if (myGameBoard.checkPiece(1,1 ).getID()==ID && myGameBoard.checkPiece(0,2).getID()==ID){
                return true;
            }
        }
        return false;
    }
}
