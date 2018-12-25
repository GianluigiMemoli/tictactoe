/*
*   This is an implementation of a Generic K-ARY Tree
*
* */


import java.util.ArrayList;
import java.util.List;

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

    public void preOrder(ArrayList<Node<T>> visit) {
        if(this.isRoot()) {
            visit.add(this);
        }

        for(Node n : children)
            visit.add(n);

        for(Node n : children)
            n.preOrder(visit);

    }




    T data;
    Node<T> parent;
    List<Node<T>> children;

}
