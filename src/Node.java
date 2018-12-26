/*
*   This is an implementation of a Generic K-ARY Tree
*
* */


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Node<T> {

    public Node(T data){
        this.data = data;
        children = new ArrayList<Node<T>>();
        parent = null;
    }

    public Node(Node parent, T data){
        this.parent = parent;
        this.data = data;
        children = new ArrayList<Node<T>>();

    }

    public void addChild(T data){
        this.children.add(new Node<T>(this, data));
    }

    public List getChildren(){
        return this.children;
    }

    public Node getParent(){
        return this.parent;
    }

    public boolean isLeaf(){
        return this.children.size() == 0;
    }

    public boolean isRoot(){
        return this.parent == null;
    }

    public T getData(){
        return this.data;
    }

    public int getDepth() throws IOException {
        if(lock)
            throw new IOException("preOrder() never called");
        return depth;
    }

    public void preOrder(ArrayList<Node<T>> visit, int h) {
        lock = false;
        if(this.isRoot()) {
            visit.add(this);
        }
        depth=h;
        for(Node n : children)
            visit.add(n);

        for(Node n : children)
            n.preOrder(visit, depth+1);

    }


    private boolean lock = true;
    private int depth=0;
    T data;
    Node<T> parent;
    List<Node<T>> children;

}
