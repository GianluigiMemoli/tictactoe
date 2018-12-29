public class StarterPCvHu {
    public static void main(String[] args){
        Board board = new Board();
        try {
            BoardGUI bgui = new BoardGUI(board);
            bgui.setVisible(true);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
