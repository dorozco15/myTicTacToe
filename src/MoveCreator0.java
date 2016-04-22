/**
 * Created by DanDan on 2016-04-18.
 */
public class MoveCreator0 extends MoveCreator {
    @Override
    public  GameMove createMove(int x, int y) {
        return new GameMove(0, x,y);
    }
}
