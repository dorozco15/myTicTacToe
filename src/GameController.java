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
    private Stack<GameMemento> undoStack = new Stack<GameMemento>();
    private Stack<GameMemento> undosSaved = new Stack<GameMemento>();
    private Stack<GameMemento> redoStack = new Stack<GameMemento>();
    private Stack<GameMemento> redosSaved = new Stack<GameMemento>();
    private GameMemento resetState;
    private Scanner scanner;
    private Scanner scanner2;
    public GameController(){
        myGameLogic = new GameLogic();
        myGameView = new GameView();
        start = true;

        myGameLogic.register(myGameView);
        myGameLogic.register(this);

        resetState = myGameLogic.getGameBoardMemento();
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);

    }
    public void doWork(){
        if (gameOver == true){
            System.exit(0);
        }
        if (start==true){
            myGameView.update(nextMove, myGameLogic.getGameBoard());
            System.out.print("Welcome! please enter 1 to start or 2 for computer to start:");
            if (scanner.nextInt()==1){
                //nextMove = 2;
                getPlayerMove();
            }
            else {
                //nextMove = 1;
                myGameLogic.getComputerMove();
            }
            start = false;
        }

    }

    @Override
    public void update(int nextMoveIn, GameBoard boardIn) {
        GameMemento memento = boardIn.storeInMemento();
        redoStack.push(memento);

        GameStatus gameStatus = myGameLogic.getGameStatus();
        if (nextMoveIn==nextMove){
            myGameView.displayMessage("Invalid Move try Again:");
        }
        //nextMove = nextMoveIn;
        checkGameOver();
        if(gameOver==true){
            myGameView.displayMessage("Game Over");
            getGameResult(gameStatus);
            this.doWork();
            return;
        }
        getUserInput(nextMoveIn);

    }
    private void getUserInput(int nextMoveIn){
        /**if (nextMoveIn==nextMove){
            if (nextMove == 1) {
                getPlayerMove();
            }
            if (nextMove == 2) {
                getComputerMove();
            }
            return;
        }**/
        nextMove = nextMoveIn;
        if (nextMove==2){
            getComputerMove();
        }
        else {
            myGameView.displayMessage("Enter N for next move, U to undo move, R to redo move, S to restart game: ");
            String input = scanner.next();
            if (input.equals("U") || input.equals("u")) {
                this.undo();
                return;
            }
            if (input.equals("r") || input.equals("R")) {
                this.redo();
                return;
            }
            if (input.equals("S") || input.equals("s")) {
                this.resetGame();
                return;
            }
            if (input.equals("N") || input.equals("n")) {
                if (nextMove == 1) {
                    getPlayerMove();
                }
                if (nextMove == 2) {
                    getComputerMove();
                }
                return;
            }

            //myGameView.update(myGameLogic.getGameBoard());
            if (nextMove == 1) {
                getPlayerMove();
            }
            if (nextMove == 2) {
                getComputerMove();
            }
        }//else
    }
    private void getPlayerMove(){
        //getUserInput();
        checkGameOver();
        if (restart == false) {
            GameStatus gameStatus = myGameLogic.getGameStatus();
            //nextMove = 2;
            if (gameOver == false) {
                int x = 0;
                int y = 0;
                //scanner.useDelimiter(",");
                myGameView.displayMessage("\nplayer move coordinate is indicated by x,y \n(x goes fro left to right & y goes from top to bottom)");
                myGameView.displayMessage("please enter move coordinate: ");

                String input = scanner2.next();

                String parts[] = input.split(",");
                if (parts.length>1) {
                    String part1 = parts[0];
                    String part2 = parts[1];
                    x = Integer.valueOf(part1);
                    System.out.println(x);

                    y = Integer.valueOf(part2);
                    System.out.println(y);
                }

                Command command = new MoveCommand(myGameLogic.getGameBoardMemento());
                undoStack.push(myGameLogic.getGameBoardMemento());
                myGameLogic.handlePlayerMove(command.execute(x, y));

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
        //nextMove = 1;
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
        if (gameStatus.getComputerWon()==true || gameStatus.getPlayerWon()==true || gameStatus.getTie()==true) {
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
            undoStack = new Stack<>();
            redoStack = new Stack<>();
            this.doWork();
    }
    private void undo(){

        if (undoStack.isEmpty()== false) {
            GameMemento memento = undoStack.pop();
            myGameLogic.setGameBoardState(memento);
            undosSaved.push(memento);
            if (redosSaved.isEmpty()==false) {
                redoStack.push(redosSaved.pop());
            }
            myGameView.update(nextMove, memento.getState());
            this.getUserInput(nextMove);
        }
        else {
            myGameView.displayMessage( "undo not allowed");
        }
    }
    private void redo() {

            if (redoStack.isEmpty()!= true) {
                GameMemento memento = redoStack.pop();
                myGameLogic.setGameBoardState(memento);
                redosSaved.push(memento);
                if(undosSaved.isEmpty()==false) {
                    undoStack.push(undosSaved.pop());
                }
                myGameView.update(nextMove, myGameLogic.getGameBoard());
                this.getUserInput(nextMove);
            }
            else {
                myGameView.displayMessage( "redo not allowed");
            }
    }

}
