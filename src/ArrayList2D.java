/**
 * Created by DanDan on 2016-04-05.
 */
import java.util.List;
import java.util.ArrayList;
public class ArrayList2D {
    Object[][] outer;

    public ArrayList2D (){
        outer = new Object[50][50];



    }

    public int length(){
        return outer.length;
    }

    public Object get(int x, int y){

        if (x< outer.length ) {
            if (y < outer[x].length) {
                if (outer[x][y] == null){
                    //System.out.println("null");
                    return null;
                }
                else{
                    //System.out.println("not null");
                    return outer[x][y];
                }

            }
        }
        //System.out.println("null");
        return null;

    }

    public void set(int x, int y, Object O){
       //System.out.println(O.toString());
       if (x< outer.length ){
           if (y < outer[x].length ){
               outer[x][y] = O;
           }
       }

    }




}
