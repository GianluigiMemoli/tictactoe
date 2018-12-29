import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JFrame implements ActionListener, MoveListener {
    BoardGUI(Board board) throws CloneNotSupportedException {
        this.board = board;
        this.board.addListener(this);
        setLayout(new GridLayout(3,3));
        setSize(new Dimension(300, 300));
        buttonInit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buttonInit(){
        /*The buttons are from 0 to 8*/

        b = new JButton[9];
        for(int i=0; i < 9; i++) {
            b[i] = new JButton(""+i);
            //Making the text invisible
            b[i].setForeground(b[i].getBackground());
            b[i].addActionListener(this);
            add(b[i]);
        }
    }

    private void setTable(){
        String s = board.getTable();
        for(int i=0; i < 9; i++) {
            b[i].setText(s.charAt(i)+"");
            if(Character.isDigit(s.charAt(i)))
                b[i].setForeground(b[i].getBackground());
            else
                b[i].setForeground(Color.BLACK);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Getting the move relative to the button
        JButton pressed = (JButton) e.getSource();

        //Parsing the move, for passing it as parameter to the Board obj
        int move = Integer.parseInt(pressed.getText());

        board.insertMove(move);
      //  setTable();
        if(board.availables > 0) {
            try {
                Score x = Player.minimax(board, true, 0);
                move = x.getMove();
                if (move != -1) {
                    board.insertMove(move);
                    //setTable();
                }
            } catch (CloneNotSupportedException e1) {
                e1.printStackTrace();
            }
        }

        String table = board.getTable();

        if(board.STATE == 0) {
            JOptionPane.showMessageDialog(null, "DRAW!");
            System.exit(0);
        }
        else if(board.STATE == 1) {
            JOptionPane.showMessageDialog(null, board.getPlayer() + " WINS!");
            System.exit(0);
        }



    }
    private JButton b[];
    private Board board;

    @Override
    public void onBoardUpdated() {
        setTable();
    }
}
