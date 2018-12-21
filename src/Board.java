public class Board implements Cloneable{
    Board(){
        table = new char[9];
        for(int i=0; i < 9; i++)
            table[i] = ' ';
        player = '-';
        availables = 9;
        STATE = -2;
        lastMove = -1;
    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    //switches from X to O & viceversa
    private void switchPlayer(){
        switch (player){
            case X:
                player = O;
                break;

            case O:
                player = X;
                break;

            case '-':
                player = X;
                break;
        }
    }


    public void insertMove(int move){
        //If player is not initialized, it will be init as X
        switchPlayer();
        if(table[move] != ' '){
            switchPlayer();
            return;
        }
        table[move] = player;
        availables--;
        lastMove = move;
        evalueate();
    }

    public String getRemaining(){
        //This function will return the remaining
        String s ="";
        for(int i=0; i < 9; i++) {
            if(table[i] == ' ')
                s+=""+i;
        }
        return s;
    }

    public void evalueate(){
        //retVal will be -1 for no win no draw, 1 for win, 0 for draw
        int retVal = -1;
        //check the horizontal lines
        if(table[0] == player && table[1] == player && table[2] == player)
            retVal = 1;
        else if(table[3] == player && table[4] == player && table[5] == player)
            retVal = 1;
        else if(table[6] == player && table[7] == player && table[8] == player)
            retVal = 1;
        //now check the vertical lines
        else if(table[0] == player && table[3] == player && table[6] == player)
            retVal = 1;
        else if(table[1] == player && table[4] == player && table[7] == player)
            retVal = 1;
        else if(table[2] == player && table[5] == player && table[8] == player)
            retVal = 1;
        //now the diagonals
        else if(table[0] == player && table[4] == player && table[8] == player)
            retVal = 1;
        else if(table[2] == player && table[4] == player && table[6] == player)
            retVal = 1;
        else if(availables == 0)
            retVal = 0;

        STATE = retVal;

    }




    public char getPlayer(){
        return player;
    }

    public String toString(){
        return getRemaining();
    }

    private final char X = 'X';
    private final char O = 'O';
    private char[] table;
    private char   player;
    public int STATE;
    public int availables;
    public int lastMove;
}
