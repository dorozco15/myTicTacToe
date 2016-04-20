/**
 * Created by DanDan on 2016-04-07.
 */
public class MoveCreator1 extends MoveCreator {
    @Override
    public GameMove createMove(int x, int y) {
        return new GameMove(1,x,y);
    }
}
