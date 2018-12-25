import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JFrame implements ActionListener {
    BoardGUI(Board board) throws CloneNotSupportedException {
        this.board = board;
        setLayout(new GridLayout(3,3));
        setSize(new Dimension(300, 300));
        buttonInit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Player(board);
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

    private  void setTable(){
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

        System.out.println("BtnName: "+pressed.getText());
        //Parsing the move, for passing it as parameter to the Board obj
        int move = Integer.parseInt(pressed.getText());
        //Making the text visible
       // pressed.setForeground(Color.BLACK);
        board.insertMove(move);
        setTable();
        if(board.availables > 0) {
            try {
                move = p.getMove(board);
                if (move != -1) {
                    board.insertMove(move);
                    setTable();
                }
            } catch (CloneNotSupportedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("Avail: "+board.availables);

        String table = board.getTable();
        System.out.println(table);

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
    private Player p;
    private Board board;
}
