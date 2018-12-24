import java.util.ArrayList;

public class Player {

    Player(Board b) throws CloneNotSupportedException {
        max = b.getPlayer();
        minimax(b);
        initNumMoves = b.availables;
    }


    private int minimax(Board b) throws CloneNotSupportedException {
      if(b.STATE == -1) {
          ArrayList<Board> states = new ArrayList<Board>();
          String remaining = b.getRemaining();
          ArrayList<Integer> scores = new ArrayList<Integer>();
          //Loading states ArrayList with all the possible move that player can do
          for (int i = 0; i < 9; i++) {
              if (remaining.contains(i + "")) {
                  Board clone = (Board) b.clone();
                  clone.insertMove(i);
                  states.add(clone);
              }
          }
          //Lunching recursion on every state, getting from each one the score
          for (int i = 0; i < states.size(); i++) {
              scores.add(minimax(states.get(i)));
          }
          int maxInd = 0;


          //Chosing the best move to take
          for(int i=0; i < scores.size(); i++){
              if(scores.get(i) > scores.get(maxInd))
                  maxInd=i;
          }
          move = states.get(maxInd).lastMove;
          statesTmp = states;
          scoresTmp  = scores;
          return scores.get(maxInd);
      }
      else{
          return getScore(b.STATE);
      }
    }

    public void log(){
        System.out.println("Every possible move");
        int i=0;
        for(Board b : statesTmp) {
            System.out.println("Board#"+ ++i);
            System.out.println(b.getTable());
            System.out.println(b.lastMove);
            System.out.println("Availables:"+b.availables);
            System.out.println("State:"+b.STATE);

        }
        System.out.println("The move taken\n"+move);
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

    private int getScore(int state){
        if(state == -1)
            return -10;
        if(state == 1){
            return 10;

        }
        return state;
    }

    char max;
    public int move = -1;
    private int initNumMoves;
    public Board boardz;
    private ArrayList<Board> statesTmp;
    private ArrayList<Integer> scoresTmp;

}
