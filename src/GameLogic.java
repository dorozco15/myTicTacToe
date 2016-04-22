/**
 * Created by DanDan on 2016-04-04.
 */

import java.util.ArrayList;

class GameLogic implements Subject {
    private ArrayList<Observer> observers;
    private GameReferee gameReferee;
    private ComputerPlayer computerPlayer;
    private GameBoard myGameBoard;
    private int nextMove =0;
    //private ComputerStrategy myStrategy;
    //private boolean gameOver

    public GameLogic(){
        myGameBoard = new GameBoard();
        gameReferee = new GameReferee(myGameBoard);
        computerPlayer = new ComputerPlayer(myGameBoard);
        observers = new ArrayList<Observer>();


    }
    protected GameStatus getGameStatus(){
        return gameReferee.checkGameStatus();

    }
    protected GameBoard getGameBoard(){
        return myGameBoard;
    }
    protected GameMemento getGameBoardMemento(){
        return myGameBoard.storeInMemento();
    }
    protected void setGameBoardState(GameMemento m){
            myGameBoard = m.getState();
            gameReferee = new GameReferee(m.getState());
            computerPlayer = new ComputerPlayer(m.getState());

    }
    protected void getComputerMove(){
        System.out.println("computerPlayer.makeComputerMove()");
        //GameBoard board = computerPlayer.makeComputerMove();
        GameMove computerMove = computerPlayer.makeComputerMove();
        if (computerMove != null) {
            myGameBoard.setPeice(computerMove);
            System.out.println("computer Move: "+computerMove.getX()+ " "+computerMove.getY());
        }
        for (int y = 0; y < 3; y++){
            for(int x = 0; x<3; x++){
                if(myGameBoard.checkPiece(x,y)!=null) {
                    if (myGameBoard.checkPiece(x,y).getID()== 1){
                        System.out.print("| X ");
                    }
                    else if (myGameBoard.checkPiece(x,y).getID()== 2){
                        System.out.print("| O ");
                    }
                    else{
                        System.out.print("|   ");
                    }
                }

            }
            System.out.print("\n");
        }


        //if (board != null){
        //    myGameBoard = board;
       // }
        nextMove =1;
        notifyObserver(nextMove,myGameBoard);

    }
    protected void handlePlayerMove(GameMove moveIn){
        System.out.println("checking legal move...");
            boolean valid = gameReferee.checkLegalMove(moveIn);
            if (valid == true) {
                myGameBoard.setPeice(moveIn);
                nextMove = 2;
                notifyObserver(nextMove, myGameBoard);
            }
            else{
                nextMove =1;
                //System.out.println("Invalid Move");
                notifyObserver(nextMove, myGameBoard);

            }
    }


    //push updates to all observers
    public void notifyObserver(int nextMove, GameBoard boardIn) {
        if (boardIn != null) {
            for (Observer o : observers) {
                o.update(nextMove, boardIn);

            }
        }
    }
   // public void notifyObserver(){

    //}


    //add a new observer to the list
    public void register(Observer o) {
        observers.add(o);
        //System.out.println("new observer at index"+ observers.indexOf(o));
    }


    //delete an observer from the list
    public void unRegister(Observer o) {
        int index = observers.indexOf(o);
        //System.out.println("observer removed at index: "+ index);
        observers.remove(index);
    }
}
