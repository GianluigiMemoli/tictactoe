import java.util.ArrayList;

public class Player {

    Player(Board b) throws CloneNotSupportedException {
        max = b.getPlayer();
        minimax(b);

        initNumMoves = b.availables;
    }

/*
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
*/

    public void minimax(Board b) throws CloneNotSupportedException {
        scores = new ArrayList<Integer>();
        snapShots = new ArrayList<Board>();
        if (b.STATE == -1) {
            String left = b.getRemaining();
            for (int i = 0; i < b.getRemaining().length(); i++) {
                left = b.getRemaining();
                if (left.contains(i + "")) {
                    Board clone = (Board) b.clone();
                    clone.insertMove(i);
                    minimax(clone);
                    if (clone.STATE != -1) {
                        scores.add(getScore(b.STATE, b.getPlayer()));
                        snapShots.add(clone);
                    }
                }

                }
            System.out.println("Score: " + scores.size());
            System.out.println("Snapshots: " + snapShots.size());
            int max = 0;
            for(int i=0; i < scores.size(); i++){
                if(scores.get(i) > scores.get(max)) {
                    max = i;
                    move = b.lastMove;
                }
            }

        } else {
            System.out.println("move: "+move);
        }
    }

    private int getScore(int state, char player){
        if(state == -1)
            return state;
        if(state == 1){
            if(max == player)
                return 10;
            else
                return -10;
        }
        return state;
    }

    int max;
    public int move = -1;
    private ArrayList<Integer> scores;
    private ArrayList<Board> snapShots;
    private int initNumMoves;

}
