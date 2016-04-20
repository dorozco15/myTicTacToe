/**
 * Created by DanDan on 2016-04-04.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Stack;
import javax.swing.*;
import java.util.Scanner;

public class GameController implements Observer{

    private GameLogic myGameLogic;
    private GameView myGameView ;
    boolean restart = false;
    boolean start ;
    boolean gameOver = false;
    int nextMove = 0;
    private Stack<Command> undoStack = new Stack<Command>();
    private Stack<Command> redoStack = new Stack<Command>();
    private GameMemento resetState;
    private Scanner scanner;

    public GameController(){
        myGameLogic = new GameLogic();
        myGameView = new GameView();
        start = true;

        myGameLogic.register(myGameView);
        myGameLogic.register(this);

        resetState = myGameLogic.getGameBoardMemento();
        scanner = new Scanner(System.in);

    }
    public void doWork(){

        if (start==true){
            myGameView.update(myGameLogic.getGameBoard());
            System.out.print("Welcome! please enter 1 to start or 2 for computer to start:");
            if (scanner.nextInt()==1){
                nextMove = 2;
                getPlayerMove();
            }
            else {
                nextMove = 1;
                myGameLogic.getComputerMove();
            }
            start = false;
        }

    }

    @Override
    public void update(GameBoard boardIn) {
        getUserInput();

    }
    private void getUserInput(){
        myGameView.displayMessage("Enter U to undo move, Enter R to redo move, Enter S to restart game: ");
        String input = scanner.next();
        if (input.equals("U")|| input.equals("u")){
            this.undo();

        }
        if (input.equals("r")|| input.equals("R")){
            this.redo();

        }
        if (input.equals("S")|| input.equals("s")){
            this.resetGame();
            return;
        }

        myGameView.update(myGameLogic.getGameBoard());
        if (nextMove == 1) {
            getPlayerMove();
        }
        if(nextMove == 2){
            getComputerMove();
        }
    }
    private void getPlayerMove(){
        //getUserInput();
        checkGameOver();
        if (restart == false) {
            GameStatus gameStatus = myGameLogic.getGameStatus();
            nextMove = 2;
            if (gameOver == false) {

                myGameView.displayMessage("\nplayer move coordinate is indicated by x,y \n(x goes fro left to right & y goes from top to bottom)");
                myGameView.displayMessage("please enter move coordinate: ");
                //String input = scanner.nextLine();
                scanner.useDelimiter(",");
                int x = 0;
                int y = 0;
                //try {

                    x  = Integer.valueOf(scanner.next());

                    y = scanner.nextInt();
                //}
                //catch (InputMismatchException e){
                //    System.out.print(e.getCause());
                //}
                scanner.useDelimiter("");
                Command command = new MoveCommand(myGameLogic.getGameBoardMemento());

                myGameLogic.handlePlayerMove(command.execute(x, y));
                undoStack.push(command);
                //getComputerMove();
            } else {
                myGameView.displayMessage("Game Over");
                getGameResult(gameStatus);
            }
        }
    }
    private void getComputerMove(){
        //getUserInput();
        checkGameOver();
        nextMove = 1;
        GameStatus gameStatus = myGameLogic.getGameStatus();
        if (gameOver ==false){
            myGameLogic.getComputerMove();
        }
        else{
            myGameView.displayMessage("Game Over");
            getGameResult(gameStatus);
        }
    }
    private void checkGameOver(){
        GameStatus gameStatus = myGameLogic.getGameStatus();
        if (gameStatus.getComputerWon()==true && gameStatus.getPlayerWon()==true && gameStatus.getTie()==true) {
            gameOver = true;
        }
        else  {
            gameOver = false;
        }
    }
    private void getGameResult(GameStatus gameStatus){
        if (gameStatus.getPlayerWon()==true){
            myGameView.displayMessage("Player Won");
        }
        else if (gameStatus.getComputerWon()==true){
            myGameView.displayMessage("Computer Won");
        }
        else {
            myGameView.displayMessage("It's a Tie");
        }
    }

    private void resetGame(){
            start = true;
            gameOver = false;
            myGameLogic.setGameBoardState(resetState);
            undoStack = new Stack<Command>();
            redoStack = new Stack<Command>();
            this.doWork();
    }
    private void undo(){

        if (undoStack.isEmpty()!= true) {
            Command command = undoStack.pop();
            myGameLogic.setGameBoardState(command.unexecute());
            redoStack.push(command);
        }
        else {
            myGameView.displayMessage( "undo not allowed");
        }
    }
    private void redo() {

            if (redoStack.isEmpty()!= true) {
                Command command = redoStack.pop();
                myGameLogic.setGameBoardState(command.unexecute());
                undoStack.push(command);
            }
            else {
                myGameView.displayMessage( "redo not allowed");
            }
    }

}
