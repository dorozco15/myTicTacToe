/**
 * Created by DanDan on 2016-04-07.
 */
public abstract class StrategyFactory {
    public abstract ComputerStrategy createProduct();

    public static StrategyFactory getFactory(int index){
        switch (index){
            case 1 : return new WinStrategyFactory();
            case 2 : return new NoLoseStretegyFactory();
            case 3 : return new SmartStrategyFactory();
            case 4 : return new RandomStrategyFactory();
            default: return new RandomStrategyFactory();
        }
    }
}
