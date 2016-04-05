/**
 * Created by DanDan on 2016-04-04.
 */
public interface Command {
    public void execute(GameMove move);
    public void unexecute(GameMove move);
}
