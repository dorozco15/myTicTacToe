/**
 * Created by DanDan on 2016-04-04.
 */
public interface Command {
    public GameMove execute( int x, int y);
    public GameMemento unexecute();
    public void setMemento(GameMemento m);
    public GameMemento getMemento();
}
