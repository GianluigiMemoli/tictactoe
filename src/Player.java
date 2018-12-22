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

          //System.out.println("Remaining: " + remaining);
          //System.out.println("InitTable="+b.getTable());
          for (int i = 0; i < 9; i++) {
              if (remaining.contains(i + "")) {

                  Board clone = (Board) b.clone();
                  clone.insertMove(i);
             /*   //System.out.println("Pre-Table #"+i);
                //System.out.println(clone.getTable()+"\n");
                //System.out.println("B-Table #"+i);
                //System.out.println(b.getTable()+"\n");*/
                  states.add(clone);
              }
          }
          //System.out.println("|States| = "+states.size());
          for (int i = 0; i < states.size(); i++) {
              //System.out.println("Table #" + i);
              //System.out.println(states.get(i).getTable() + "\n");
              scores.add(minimax(states.get(i)));
              //System.out.println("AddingScores");
          }
          int maxInd = 0;
          for(int i=0; i < scores.size(); i++){
              if(scores.get(i) > scores.get(maxInd))
                  maxInd=i;
          }
          move = states.get(maxInd).lastMove;
          //System.out.println("move:"+move);
          return scores.get(maxInd);
      }
      else{
          //System.out.println("ELSETABLE="+b.getTable());
          return getScore(b.STATE, b.getPlayer());
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

    char max;
    public int move = -1;
    private int initNumMoves;
    public Board boardz;

}
/*
* X0-
* -X0
* X0X
*
* */