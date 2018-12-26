import java.util.ArrayList;

public class Player {

    Player(Board b) throws CloneNotSupportedException {

    }

    public ArrayList<Node<Board>> fillTree(Board b) throws CloneNotSupportedException {
        Node<Board> tree = new Node<Board>(b);
        minimax(tree);
        ArrayList<Node<Board>> fromTree = new ArrayList<>();
        tree.preOrder(fromTree);
        return fromTree;
    }

    public int getMove(Board b) throws CloneNotSupportedException {
        max = b.getPlayer();

        ArrayList<Node<Board>> states = fillTree(b);
        ArrayList<Node<Board>> toFilter = new ArrayList<>();

        for(Node n : states){
            Board curr = (Board) n.getData();
            if(getScore(curr.STATE, curr.getPlayer()) >= 0){
                toFilter.add(n);
            }
        }

        int max = 0;
        Board cmp1, cmp2;
        for(int i=0; i < toFilter.size(); i++){
            System.out.print("Cerco\n");
            cmp1 = toFilter.get(max).getData();
            cmp2 = toFilter.get(i).getData();
            if(cmp1.availables < cmp2.availables){
                max = i;
            }
        }

        Node tmp = toFilter.get(max);
        while(tmp.getParent() != null &&!(tmp.getParent()).isRoot())
            tmp = tmp.getParent();
        return ((Board) tmp.getData()).lastMove;


    }

    public void minimax(Node<Board> tree, ArrayList<>) throws CloneNotSupportedException {
        Board fromNode = tree.getData();
        String remaining = fromNode.getRemaining();
        /*Loading states*/
        for(int i=0; i < 9; i++){
            if(remaining.contains(i+"")) {
                Board cloned =(Board) fromNode.clone();
                cloned.insertMove(i);
                tree.addChild(cloned);
            }
        }
        //Recursive on
        ArrayList<Node> states = (ArrayList<Node>) tree.getChildren();
        for(Node n : states){
            if(( (Board) n.getData() ).STATE == -1 ){
                minimax(n);
            }
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
   // private Node<Board> tree;

}
