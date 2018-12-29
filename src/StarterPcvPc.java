import static java.lang.Thread.sleep;

public class StarterPcvPc {
    public static void main(String[] args) throws InterruptedException {
        Board b = new Board();
        try {
            BoardGUI BGUI = new BoardGUI(b);
            BGUI.setVisible(true);
            Score x;
            boolean max = true;
            while(b.STATE == -1) {
                Thread.sleep(1000);

                x = Player.minimax(b, max, 0);
                b.insertMove(x.getMove());
                max = !max;
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
