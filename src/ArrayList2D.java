/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.List;
import java.util.ArrayList;
public class ArrayList2D {
    ArrayList<ArrayList<Object>> outer;

    public ArrayList2D (){
        outer = new ArrayList<ArrayList<Object>>(50);

        for (int i = 0; i< 50; i++){
            outer.add( new ArrayList<>(50));
        }

    }

    public int length(){
        return outer.size();
    }

    public Object get(int x, int y){
        if (x< outer.size() ) {
            if (y < outer.get(x).size()) {
                if (outer.get(x).get(y) == null){
                    return null;
                }
                else{
                    return outer.get(x).get(y);
                }

            }
        }
        return null;

    }

    public void set(int x, int y, Object O){
       if (x< outer.size() ){
           if (y < outer.get(x).size() ){
               outer.get(x).set(y,O);
           }
       }

    }




}
