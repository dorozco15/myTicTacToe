/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.List;
import java.util.ArrayList;
public class ArrayList2D {
    List outer;

    public ArrayList2D (){
        outer = new ArrayList<ArrayList<Object>>();

    }

    public int length(){
        return outer.size();
    }
    public Object get(int x, int y){
        return ((ArrayList<ArrayList<Object>>)outer.get(x)).get(y);

    }

    public void set(int x, int y, Object O){
       // ArrayList<Object> temp = new ArrayList<Object>();
       // temp.set(y, O);
        outer.set(x, (new ArrayList<Object>()).set(y, O));
    }




}
