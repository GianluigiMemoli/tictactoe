
public class Player {

    public static Score minimax(Board bIn, boolean isMax, int depth) throws CloneNotSupportedException {
        Score best;

        if(isMax)
             best = new Score(-10, depth, -1);
        else
             best = new Score(10, depth, -1);

        if(bIn.STATE != -1){
         //   System.out.println("Sono != -1");
            return new Score(evaluate(bIn.STATE, bIn.winner), depth, bIn.lastMove);
        }

        String remaining = bIn.getRemaining();
        Score moveScore ;
        for(int i=0; i < 9; i++){
            if(remaining.contains(i+"")){
                Board bInMoved = (Board) bIn.clone();
                bInMoved.insertMove(i);
                moveScore = minimax(bInMoved, !isMax, depth+1);
                if(isMax){
                    if(best.getScore() < moveScore.getScore()) {
                        best = moveScore;
                        best.setMove(i);
                    }
                } else {
                    if(best.getScore() > moveScore.getScore()) {
                        best = moveScore;
                        best.setMove(i);
                    }
                }
            }
        }




        return best;
    }

    private static int evaluate(int state, char player){
        if(state == 1) {
            if (player == 'O')
                return 10;
            else return -10;
        } else return state;

    }

    final char human = 'X';
    final char AI = 'O';
}
