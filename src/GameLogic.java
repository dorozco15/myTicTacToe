/**
 * Created by DanDan on 2016-04-04.
 */

import java.util.ArrayList;

class GameLogic implements Subject {
    private ArrayList<Observer> observers;
    private GameReferee gameReferee;
    private ComputerPlayer computerPlayer;
    private GameBoard myGameBoard;
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
        GameBoard board = computerPlayer.makeComputerMove();
        if (board != null){
            myGameBoard = board;
        }
        notifyObserver(myGameBoard);

    }
    protected void handlePlayerMove(GameMove moveIn){
            boolean valid = gameReferee.checkLegalMove(moveIn);
            if (valid == true) {
                myGameBoard.setPeice(moveIn);
                notifyObserver(myGameBoard);
            }
            else{

            }
    }


    //push updates to all observers
    public void notifyObserver(GameBoard boardIn) {
        if (boardIn != null) {
            for (Observer o : observers) {
                o.update(boardIn);

            }
        }
    }
    public void notifyObserver(){

    }


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
