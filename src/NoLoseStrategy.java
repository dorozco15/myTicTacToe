/**
 * Created by DanDan on 2016-04-07.
 */
public class NoLoseStrategy implements ComputerStrategy {

    private ComputerStrategy nextStrategy;
    private GameBoard myGameBoard;
    private MoveCreator moveCreator = new MoveCreator2();
    private WinAlg winAlg;

    @Override
    public void setNextChain(ComputerStrategy nextStrategyIn) {
        this.nextStrategy = nextStrategyIn;
    }

    @Override
    public GameBoard computeMove(GameBoard boardIn) {
        myGameBoard = boardIn;
        winAlg = new WinAlg(1, myGameBoard);
        if (myGameBoard.getPlayerMoveCount() <2){
            if(nextStrategy!= null) {
                return nextStrategy.computeMove(myGameBoard);
            }
            return myGameBoard;

        }
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; i < 3; i++) {
                    if (myGameBoard.checkPiece(i, j).getID()==0) {
                        boolean checkPlayerWin = winAlg.checkWin(i, j);
                        if (checkPlayerWin == true) {
                            myGameBoard.setPeice(moveCreator.create(i, j));
                            return myGameBoard;
                        }
                    }
                }
            }
            if(nextStrategy!= null) {
                return nextStrategy.computeMove(myGameBoard);
            }
            return myGameBoard;
        }

    }
}
