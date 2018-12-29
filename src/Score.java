public class Score {
    Score(int score, int depth,int move){
        this.score = score;
        this.depth = depth;
        this.move = move;
    }

    public int getScore(){return score;}
    public int getDepth(){return depth;}
    public int getMove(){return move;}
    public void setMove(int move){
        this.move = move;
    }
    private int move;
    private int score;
    private int depth;
}
