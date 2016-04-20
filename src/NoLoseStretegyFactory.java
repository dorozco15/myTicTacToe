/**
 * Created by DanDan on 2016-04-07.
 */
public class NoLoseStretegyFactory extends StrategyFactory {

    @Override
    public ComputerStrategy createProduct() {
        return new NoLoseStrategy();
    }
}
