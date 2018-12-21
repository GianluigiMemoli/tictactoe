import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JFrame implements ActionListener {
    BoardGUI(Board board){
        this.board = board;
        setLayout(new GridLayout(3,3));
        setSize(new Dimension(300, 300));
        buttonInit();
    }

    private void buttonInit(){
        /*The buttons are from 0 to 8*/

        JButton b[] = new JButton[9];
        for(int i=0; i < 9; i++) {
            b[i] = new JButton(""+i);
            //Making the text invisible
            b[i].setForeground(b[i].getBackground());
            b[i].addActionListener(this);
            add(b[i]);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Getting the move relative to the button
        JButton pressed = (JButton) e.getSource();

        System.out.println("BtnName: "+pressed.getText());
        //Parsing the move, for passing it as parameter to the Board obj
        int move = Integer.parseInt(pressed.getText());
        //Making the text visible
        pressed.setForeground(Color.BLACK);
        board.insertMove(move);
        pressed.setText(board.getPlayer()+"");

        if(board.STATE == 0)
            JOptionPane.showMessageDialog(null, "DRAW!");
        else if(board.STATE == 1)
            JOptionPane.showMessageDialog(null, board.getPlayer()+" WINS!");

        System.out.println("Original: "+ board.toString());

        try{
            System.out.println("Clone: "+ ((Board) board.clone()).toString());
        }catch (CloneNotSupportedException ec){
            ec.printStackTrace();
        }




    }

    private Board board;
}
