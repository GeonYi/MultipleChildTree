package pre.example.collection;

import pre.example.collection.exception.AlreadyExistRootException;
import pre.example.collection.exception.NotExistRootException;
import pre.example.collection.node.Node;
import pre.example.collection.tree.Tree;
import pre.example.collection.node.TreeNode;

import java.util.List;

@SuppressWarnings("unchecked")
class MultiChildTree<T> implements Tree {

    private int totalNodeCnt = 0;
    private Node<T> root = null;
    private Boolean autoSync;

    MultiChildTree() {
        this.autoSync = true;
    }

    // auto sync is default use!! - 20161201
    @Deprecated
    MultiChildTree(Boolean autoSync) {
        this.autoSync = autoSync;
    }

    // <<< getter >>>
    public int getTotalNodeCnt() { return totalNodeCnt; }
    public Node<T> getRoot() { return root; }

    /**
     *  add new node in tree.
     *
     * @param data      data for insert
     * @param parent    parent node
     * @return TreeNode object
     * @throws NotExistRootException if root is not exist then throws exception
     * */
    @Override
    public Node addNode(Object data, Node parent) throws NotExistRootException {

        if(this.root == null){
            throw new NotExistRootException("not exist root... please call addRoot API before call addNode");
        }

        TreeNode<T> tn = new TreeNode<>(data, parent);

        if(this.autoSync){
            setChildByAutoSync(parent, tn);
        }

        plusNodeCount(1);

        return tn;
    }

    /**
     *  add new node in tree with child node.
     *
     * @param data          data for insert
     * @param parent        parent node
     * @param childNodes    child nodes
     * @return key value of node as java.util.UUID
     * */
    public List addNode(Object data, TreeNode<T> parent, List<TreeNode<T>> childNodes) {
        //todo : impliment
        return null;
    }

    @Override
    public TreeNode<T> addRoot(Object o) throws AlreadyExistRootException {

        if(this.root != null){
            throw new AlreadyExistRootException("already exist root");
        }

        TreeNode<T> tn = new TreeNode(o);
        this.root = tn;
        plusNodeCount(1);
        return tn;
    }

    private void setChildByAutoSync(Node parentNode, Node newNode){
        parentNode.addChildren(newNode);
    }

    private void plusNodeCount(int cntNum){
        this.totalNodeCnt += cntNum;
    }

    @Override
    public String toString() {
        return "MultiChildTree{" +
                "root=" + root +
                ", autoSync=" + autoSync +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiChildTree)) return false;

        MultiChildTree<?> that = (MultiChildTree<?>) o;

        return root.equals(that.root)
                && autoSync.equals(that.autoSync);
    }

    @Override
    public int hashCode() {
        int result = root.hashCode();
        result = 31 * result + autoSync.hashCode();
        return result;
    }
}
