/**
 * Created by DanDan on 2016-04-08.
 */
public class MoveCommand implements Command {

    private GameMemento savedGameBoard;
    private GameMove gameMove;

    public MoveCommand( GameMemento memento){
        savedGameBoard = memento;
    }

    public GameMove execute(int x, int y){
        MoveCreator creator = new MoveCreator1();
        GameMove move = creator.create(x,y);
        gameMove = move;
        return move;
    }


    public GameMemento unexecute( ) {
        return getMemento();
    }

    @Override
    public void setMemento(GameMemento m) {
        savedGameBoard = m;
    }

    @Override
    public GameMemento getMemento() {
        return savedGameBoard;
    }
    public GameMove getMove(){
        return gameMove;
    }
}
