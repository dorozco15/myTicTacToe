/**
 * Created by DanDan on 2016-04-04.
 */
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class GameView implements Observer{



    public GameView (){

    }

    @Override
    public void update(GameBoard boardIn) {
        this.displayGameBoard(boardIn);

    }
    public void displayGameBoard(GameBoard myGameBoard){
        for (int y = 0; y < 3; y++){
            for(int x = 0; x<3; x++){
                if(myGameBoard.checkPiece(x,y)!=null) {
                    if (myGameBoard.checkPiece(x,y).getID()== 1){
                        System.out.print("| X ");
                    }
                    else if (myGameBoard.checkPiece(x,y).getID()== 2){
                        System.out.print("| O ");
                    }
                    else{
                        System.out.print("|   ");
                    }
                }

            }
            System.out.print("\n");
        }
    }
    public void displayMessage(String message){
        System.out.println(message);
    }

}
