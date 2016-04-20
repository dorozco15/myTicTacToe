/**
 * Created by DanDan on 2016-04-06.
 */
public class WinStrategy implements ComputerStrategy{

    private ComputerStrategy nextStrategy;
    private GameBoard myGameBoard;
    private MoveCreator moveCreator = new MoveCreator2();
    private WinAlg winAlg;
    @Override
    public void setNextChain(ComputerStrategy nextStrategyIn) {
        this.nextStrategy = nextStrategyIn;

    }

    @Override
    public GameBoard computeMove(GameBoard myGameBoardIn) {
        myGameBoard = myGameBoardIn;
        winAlg = new WinAlg(2, myGameBoard);

        if(myGameBoard.getComputerMoves() < 2){
            if (nextStrategy!= null) {
                return nextStrategy.computeMove(myGameBoard);
            }
            return null;
        }
        else{
            for (int i = 0; i <3 ; i++){
                for (int j = 0; j<3; j++){
                    if (myGameBoard.checkPiece(i,j).getID()==0){
                        boolean checkWin = winAlg.checkWin(i,j);
                        if (checkWin == true){
                            myGameBoardIn.setPeice(moveCreator.create(i,j));
                            return myGameBoard;
                        }
                    }
                }
            }
            if (nextStrategy!= null) {
                return nextStrategy.computeMove(myGameBoard);
            }
            return myGameBoardIn;
        }
    }


}
