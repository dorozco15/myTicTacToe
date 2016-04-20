/**
 * Created by DanDan on 2016-04-05.
 */
public class GameReferee {

    GameBoard myGameBoard;
    boolean gameStarted = false;
    boolean gameOver = true;
    boolean win, tie, loss = false;
    //constructor
    public GameReferee(GameBoard gameBoardIn){
        myGameBoard = gameBoardIn;

    }
    public GameStatus checkGameStatus(){
        int[][] positions = this.getGamePositions();
        boolean playerWon = this.playerWon(positions);
        boolean computerWon = this.computerWon(positions);
        boolean checkTie = this.checkTie();
        GameStatus gameStatus = GameStatus.getInstance();
        gameStatus.setPlayerWon(playerWon);
        gameStatus.setComputerWon(computerWon);
        gameStatus.setTie(checkTie);

        return gameStatus;
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
    private int[][] getGamePositions(){
        int[][] positions = new int[3][3];


        for (int i = 0; i < 3; i++){
            for (int j = 0; j <3; j++){
                if (myGameBoard.getplayerID(i,j)!= null) {
                    positions[i][j] = myGameBoard.getplayerID(i, j);
                }
                else {
                    positions[i][j]= 0;
                }
            }
        }
        return positions;
    }
    private boolean playerWon(int[][] positions){
        if (checkVerticals(positions, 1)== true || checkHorizontals(positions, 1)==true || checkCrosses(positions, 1)==true){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean computerWon(int[][] positions){
        if (checkVerticals(positions, 2)== true || checkHorizontals(positions, 2)==true || checkCrosses(positions, 2)==true){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean checkVerticals(int[][] positions, int id){
        if (positions[0][0]== id && positions[1][0]== id && positions[2][0] == id){
            return true;
        }
        else if (positions[0][2]== id && positions[1][2]== id && positions[2][2] ==id  ){
            return true;
        }
        else if (positions[0][1]== id && positions[1][1]== id && positions[2][1] ==id ){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean checkHorizontals(int[][] positions, int id){
        if (positions[0][0]== id && positions[0][1]== id && positions[0][2] == id){
            return true;
        }
        else if (positions[2][0]== id && positions[2][1]== id && positions[2][2] ==id  ){
            return true;
        }
        else if (positions[1][0]== id && positions[1][1]== id && positions[1][2] ==id ){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean checkCrosses(int[][] positions, int id){
        if (positions[0][0]== id && positions[1][1]== id && positions[2][2] == id){
            return true;
        }
        else if (positions[0][2]== id && positions[1][1]== id && positions[2][0] ==id  ){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean checkTie(){
        boolean tie = false;
        int count = 0;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j <3; j++){
                if (myGameBoard.checkPiece(i,j)!= null) {
                    count ++;
                }
            }
        }
        if (count == 9 ){
            return true;
        }
        else{
            return false;
        }

    }
}
