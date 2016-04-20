import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Created by DanDan on 2016-04-09.
 */
public class TicTacToe extends JFrame implements Observer {
    private JPanel rootPanel;
    private JButton reset;
    private JButton undo;
    private JButton computerStart;
    private JButton redo;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel messageBanner;
    private ArrayList2D buttonGrid = new ArrayList2D();
    private ImageIcon xIcon;
    private ImageIcon oIcon;


    public TicTacToe() {
        pack();
        if (getClass().getResource("XIcon.png")!=null){
            xIcon = new ImageIcon(getClass().getResource("XIcon.png"));

        }
        if (getClass().getResource("OIcon.png")!= null){
            oIcon= new ImageIcon(getClass().getResource("OIcon.png"));
        }


        this.setSize(800,800);
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        this.setVisible(true);

    }
    public JPanel getRootPanel(){
        return rootPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public void addMoveListener(ActionListener listener){
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button8.addActionListener(listener);
        button3.addActionListener(listener);
        buttonGrid.set(0,0,new Button(0,0,button1));
        buttonGrid.set(1,0,new Button(1,0,button2));
        buttonGrid.set(2,0, new Button(2,0,button3));
        buttonGrid.set(0,1,new Button(0,1,button4));
        buttonGrid.set(1,1,new Button (1,1,button5));
        buttonGrid.set(2,1,new Button(2,1,button6));
        buttonGrid.set(0,2,new Button(0,2,button7));
        buttonGrid.set(1,2,new Button(1,2,button8));
        buttonGrid.set(2,2,new Button(2,2,button9));
    }
    public void displayMessage(String message){
        messageBanner.setText(message);
    }

    public void addResetListener(ActionListener listener){
        reset.addActionListener(listener);
    }
    public void addUndoListener(ActionListener listener){
        undo.addActionListener(listener);
    }
    public void addRedoListener(ActionListener listener){
        redo.addActionListener(listener);
    }
    public void addComputerStartListener(ActionListener listener){
        computerStart.addActionListener(listener);
    }
    public ArrayList2D getButtonGrid(){
        return buttonGrid;
    }
    public void setData(TicTacToe data) {
    }

    public void getData(TicTacToe data) {
    }

    public boolean isModified(TicTacToe data) {
        return false;
    }

    @Override
    public void update(GameBoard boardIn) {
        displayGameBoard(boardIn);
    }

    private void displayGameBoard(GameBoard myGameBoard) {


        for (int i = 0; i < 3; i++){
            for(int j = 0; j <3; j++){
                if(myGameBoard.checkPiece(i,j)!=null) {
                    GameMove move = myGameBoard.checkPiece(i, j);
                    Button button = (Button)buttonGrid.get(i,j);
                    button.setPressed(true);
                    if(move.getID()==1){
                        button.getButton().setIcon(xIcon);

                    }
                    else {
                        button.getButton().setIcon(oIcon);
                    }
                }
                else{
                    Button button = (Button)buttonGrid.get(i,j);

                }
            }
        }
    }
}
