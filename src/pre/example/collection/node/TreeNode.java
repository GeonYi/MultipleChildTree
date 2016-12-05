package pre.example.collection.node;

import pre.example.collection.runner.NodeRunner;
import java.util.List;

@SuppressWarnings("unchecked")
public class TreeNode<T> extends Node implements pre.example.collection.runner.Runnable {

    private NodeRunner nodeRunner;

    public TreeNode(T data){
        super(data);
    }

    public TreeNode(Object data, Node parent) {
        super(data, parent);
    }

    public TreeNode(Object data, List<? extends Node<T>> children) {
        super(data, children);
    }

    public TreeNode(Object data, Node parent, List<? extends Node<T>> children) {
        super(data, parent, children);
    }

    public TreeNode(Object data, Node parent, List<? extends Node<T>> children, NodeRunner nodeRunner) {
        super(data, parent, children);
        this.nodeRunner = nodeRunner;
    }

    @Override
    public boolean run(Object... params) {
        //todo : impl
        System.out.println("running success" +  "!!!!");
        return true;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "nodeRunner=" + nodeRunner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        if (!super.equals(o)) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return nodeRunner != null ? nodeRunner.equals(treeNode.nodeRunner) : treeNode.nodeRunner == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nodeRunner != null ? nodeRunner.hashCode() : 0);
        return result;
    }
}
