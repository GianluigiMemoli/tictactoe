import java.util.ArrayList;

public class Player {

    Player(Board b) throws CloneNotSupportedException {
        minimax(b);

        initNumMoves = b.availables;
    }


    public int minimax(Board b) throws CloneNotSupportedException {

        String canMove = b.getRemaining();
        int nStates = canMove.length();
        if(nStates > 0) {
            ArrayList<Board> states = new ArrayList<>();
            int scores[] = new int[nStates];
            //Load ArrayList of snapshots
            for (int i = 0; i < nStates; i++) {
                Board bAdd = (Board) b.clone();
                states.add(bAdd);
            }
            //Load scores and launch recursive function
            for (int i = 0; i < nStates; i++)
                scores[i] = minimax(states.remove(i));

        }
        else{
            return b.STATE;
        }
    }


    int max;
    public int move = -1;
    private ArrayList<Integer> scores;
    private int initNumMoves;

}
