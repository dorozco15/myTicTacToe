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
    public GameMove computeMove(GameBoard boardIn) {
        myGameBoard = boardIn;
        winAlg = new WinAlg(1, boardIn);
        if (boardIn.getPlayerMoveCount() <2 && nextStrategy != null){
            System.out.println("next strategy: smart strategy 1");

            return nextStrategy.computeMove(myGameBoard);



        }
        else {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (boardIn.checkPiece(x, y).getID()==0) {
                        boolean checkPlayerWin = winAlg.checkWin(x, y, boardIn);
                        if (checkPlayerWin == true) {
                            //myGameBoard.setPeice(moveCreator.create(i, j));
                            return moveCreator.create(x,y);
                        }
                    }
                }
            }
            if(nextStrategy!= null) {
                System.out.println("next strategy: smart strategy 2");
                return nextStrategy.computeMove(boardIn);
            }
            return null;
        }

    }
}
