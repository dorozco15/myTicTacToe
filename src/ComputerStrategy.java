/**
 * Created by DanDan on 2016-04-05.
 */
public interface ComputerStrategy {

    public void setNextChain(ComputerStrategy nextStrategyIn);
    public GameBoard computeMove(GameBoard myGameBoard);
}
