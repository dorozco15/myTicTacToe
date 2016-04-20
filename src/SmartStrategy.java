/**
 * Created by DanDan on 2016-04-07.
 */
public class SmartStrategy implements ComputerStrategy {

    private ComputerStrategy nextStrategy;
    private GameBoard myGameBoard;
    private MoveCreator moveCreator = new MoveCreator2();


    @Override
    public void setNextChain(ComputerStrategy nextStrategyIn) {
        this.nextStrategy = nextStrategyIn;
    }

    @Override
    public GameBoard computeMove(GameBoard boardIn) {
        myGameBoard = boardIn;
        if (myGameBoard.getPlayerMoveCount() == 0 && myGameBoard.getNumberOfTurns() ==0){//if i go first
             myGameBoard.setPeice(moveCreator.createMove(2,2));
            return boardIn;
        }
        else if (myGameBoard.getPlayerMoveCount() == 1 && myGameBoard.getComputerMoves()==0){//if i go second
            GameMove firstMove = (GameMove) myGameBoard.getPlayerMoves().peek();
            boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            int nextX;
            int nextY;
            if (isCorner == true){
                //pick another corner
                myGameBoard.setPeice(moveCreator.createMove(1,1));
                return boardIn;
            }
            else {
                myGameBoard.setPeice(moveCreator.createMove(2,2));//pick a corner
                return myGameBoard;
            }
        }
        else if (myGameBoard.getComputerMoves()==1 && myGameBoard.getPlayerMoveCount()==1){//second time I go
            GameMove firstMove = (GameMove) myGameBoard.getPlayerMoves().peek();
            //boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            if (firstMove.getX()!=2 && firstMove.getY()!=0){
                myGameBoard.setPeice(moveCreator.createMove(2,0));
                return myGameBoard;
            }
            else{
                myGameBoard.setPeice(moveCreator.createMove(0,2));
                return myGameBoard;
            }
        }
        else if (myGameBoard.getComputerMoves()==1 && myGameBoard.getPlayerMoveCount()==2){
            GameMove secondMove = (GameMove) myGameBoard.getPlayerMoves().get(0);
            GameMove firstMove = (GameMove) myGameBoard.getPlayerMoves().get(1);

            //boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            if ((firstMove.getX()!=0 && firstMove.getY()!=2)&& (secondMove.getX()!=0 && secondMove.getY()!=2)){
                myGameBoard.setPeice(moveCreator.createMove(0,2));
                return myGameBoard;
            }
            else if ((firstMove.getX()!=2 && firstMove.getY()!=0)&&(secondMove.getX()!=2 && secondMove.getY()!=0)){
                myGameBoard.setPeice(moveCreator.createMove(2,0));
                return myGameBoard;
            }
            else{
                myGameBoard.setPeice(moveCreator.createMove(0,0));
                return myGameBoard;
            }
        }
        else{

            if(nextStrategy!= null) {
                return nextStrategy.computeMove(myGameBoard);
            }
            return myGameBoard;
        }
    }
    private boolean checkCorners(int x, int y){
        if (x== 0 && y ==0){
            return true;
        }
        if(x== 0 && y==2){
            return true;
        }
        if (x==2 && y == 0){
            return true;
        }
        if(x==2 && y==2){
            return true;
        }
        return false;
    }

}
