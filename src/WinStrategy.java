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
    public GameMove computeMove(GameBoard myGameBoardIn) {
        myGameBoard = myGameBoardIn;
        winAlg = new WinAlg(2, myGameBoardIn);

        if(myGameBoardIn.getComputerMoves() < 2){
            if (nextStrategy!= null) {
                System.out.println("next strategy: no lose");
                return nextStrategy.computeMove(myGameBoardIn);
            }
            return null;
        }
        else{
            for (int i = 0; i <3 ; i++){
                for (int j = 0; j<3; j++){
                    if (myGameBoardIn.checkPiece(i,j).getID()==0){
                        boolean checkWin = winAlg.checkWin(i,j, myGameBoardIn);
                        if (checkWin == true){
                            //myGameBoardIn.setPeice(moveCreator.create(i,j));
                            return moveCreator.create(i,j);
                        }
                    }
                }
            }
            if (nextStrategy!= null) {
                System.out.println("next strategy: no lose");
                return nextStrategy.computeMove(myGameBoardIn);
            }
            return null;
        }
    }


}
