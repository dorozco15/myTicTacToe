/**
 * Created by DanDan on 2016-04-07.
 */
public class SmartStrategyFactory extends StrategyFactory {

    @Override
    public ComputerStrategy createProduct() {
        return new SmartStrategy();
    }
}
