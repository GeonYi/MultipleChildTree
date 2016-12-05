package pre.example.collection.node;

import java.util.ArrayList;
import java.util.List;

public abstract class Node<T> implements NodeDefaultBehavior, pre.example.collection.runner.Runnable {

    private T data;
    private Node<T> parent;
    private List<Node<T>> children = new ArrayList<>();

    public Node(){
        //empty param constructor
    }

    public Node(T data){
        this.data = data;
    }

    public Node(T data, List<Node<T>> children) {
        this.data = data;
        this.children = children;
    }

    public Node(T data, Node<T> parent){
        this.data = data;
        this.parent = parent;
    }

    public Node(T data, Node<T> parent, List<Node<T>> children){
        this.data = data;
        this.parent = parent;
        this.children = children;
    }

    public T getData() {
        return data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Node getParent() {
        return this.parent;
    }

    public List<Node<T>> getChildren() {return children; }

    // setter
    protected void setData(T data) {
        this.data = data;
    }

    protected void setParent(Node<T> parent) {
        this.parent = parent;
    }

    protected void setChildren(List<Node<T>> childrens) {
        this.children = childrens;
    }

    public void addChildren(Node<T> children) {
        this.children.add(children);
    }

    @Override
    public List<? extends Node> getChildes() {
        return this.children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node<?> node = (Node<?>) o;

        return getData().equals(node.getData())
                && getParent().equals(node.getParent())
                && children.equals(node.children);
    }

    @Override
    public int hashCode() {
        int result = getData().hashCode();
        result = 31 * result + getParent().hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }
}
