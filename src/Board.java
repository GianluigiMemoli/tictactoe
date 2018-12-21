public class BoardManager {
    BoardManager(){
        table = new char[9];
        for(int i=0; i < 9; i++)
            table[i] = ' ';
        player = '-';
        availables = 9;
        STATE = -2;
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
        evalueate();
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

    private final char X = 'X';
    private final char O = 'O';
    private char[] table;
    private char   player;
    public int STATE;
    int availables;
}
