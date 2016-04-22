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
    public GameMove computeMove(GameBoard boardIn) {
        boardIn = boardIn;
        if (boardIn.getPlayerMoveCount() == 0 && boardIn.getComputerMoves() ==0){//if i go first
             //boardIn.setPeice(moveCreator.createMove(2,2));
            return moveCreator.createMove(2,2);
        }
        else if (boardIn.getPlayerMoveCount() == 1 && boardIn.getComputerMoves()==0){//if i go second
            GameMove firstMove = (GameMove) boardIn.getPlayerMoves().peek();
            boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            int nextX;
            int nextY;
            if (isCorner == true){
                //pick another corner
                //boardIn.setPeice(moveCreator.createMove(1,1));
                return moveCreator.create(1,1);
            }
            else {
               // boardIn.setPeice(moveCreator.createMove(2,2));//pick a corner
                return moveCreator.create(2,2);
            }
        }
        else if (boardIn.getComputerMoves()==1 && boardIn.getPlayerMoveCount()==1){//second time I go
            GameMove firstMove = (GameMove) boardIn.getPlayerMoves().peek();
            //boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            if (firstMove.getX()!=2 && firstMove.getY()!=0){
                //boardIn.setPeice(moveCreator.createMove(2,0));
                return moveCreator.create(2,0);
            }
            else{
                //boardIn.setPeice(moveCreator.createMove(0,2));
                return moveCreator.create(0,2);
            }
        }
        else if (boardIn.getComputerMoves()==1 && boardIn.getPlayerMoveCount()==2){
            GameMove secondMove = (GameMove) boardIn.getPlayerMoves().get(0);
            GameMove firstMove = (GameMove) boardIn.getPlayerMoves().get(1);

            //boolean isCorner = checkCorners(firstMove.getX(), firstMove.getY());
            if ((firstMove.getX()!=0 && firstMove.getY()!=2)|| (secondMove.getX()!=0 && secondMove.getY()!=2)){
               // boardIn.setPeice(moveCreator.createMove(0,2));
                return moveCreator.create(0,2);
            }
            else if ((firstMove.getX()!=2 && firstMove.getY()!=0)||(secondMove.getX()!=2 && secondMove.getY()!=0)){
                //boardIn.setPeice(moveCreator.createMove(2,0));
                return moveCreator.create(2,0);
            }
            else{
                //boardIn.setPeice(moveCreator.createMove(0,0));
                return moveCreator.create(0,0);
            }
        }
        else{

            if(nextStrategy!= null) {
                System.out.println("next strategy: random strategy");
                return nextStrategy.computeMove(boardIn);
            }
            return null;
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
