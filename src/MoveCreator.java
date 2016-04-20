/**
 * Created by DanDan on 2016-04-07.
 */
public abstract class MoveCreator {
    public abstract GameMove createMove(int x, int y);
    public GameMove create(int x, int y){
        return createMove(x, y);
    }
}
