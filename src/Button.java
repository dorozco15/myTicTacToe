/**
 * Created by DanDan on 2016-04-08.
 */
import javax.swing.*;
public class Button extends JButton {
    int X, Y;
    JButton button;
    boolean isPressed;
    public  Button(JButton buttonIn){
        button = buttonIn;

    }
    public  Button(int x, int y, JButton buttonIn){
        button = buttonIn;
        this.X = x;
        this.Y = y;

    }
    public void setX(int x){
        this.X = x;
    }
    public void setY(int y){
        this.Y = y;
    }
    public void setPressed(boolean in){
        isPressed = in;
    }
    public boolean isPressed(){
        return isPressed;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public JButton getButton(){
        return button;
    }
}
