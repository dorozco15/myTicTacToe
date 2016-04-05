/**
 * Created by DanDan on 2016-04-04.
 */
import java.util.ArrayList;

public class GameLogic implements Subject {
    private ArrayList<Observer> observers;
    private GameReferee gameReferee;
    private ComputerPlayer computerPlayer;
    private GameBoard myGameBoard;
    private ComputerStrategy myStrategy;

    public GameLogic(ComputerStrategy strategyIn){
        myGameBoard = new GameBoard();
        myStrategy = strategyIn;
        gameReferee = new GameReferee(myGameBoard);
        computerPlayer = new ComputerPlayer(myGameBoard, myStrategy);


    }
    private void getGameStatus(){

    }
    protected GameMemento getGameBoard(){
        return myGameBoard.storeInMemento();
    }
    private void getGameBoardMemento(){

    }
    private void setGameBoardState(GameMemento m){
           // myGameBoard = m.getState();
    }
    private void handlePlayerMove(){

    }

    @Override
    //push updates to all observers
    public void notifyObserver() {
        for (Observer o : observers){
            o.update();
        }
    }

    @Override
    //add a new observer to the list
    public void register(Observer o) {
        observers.add(o);
        System.out.println("new observer at index"+ observers.indexOf(o));
    }

    @Override
    //delete an observer from the list
    public void unRegister(Observer o) {
        int index = observers.indexOf(o);
        System.out.println("observer removed at index: "+ index);
        observers.remove(index);
    }
}
