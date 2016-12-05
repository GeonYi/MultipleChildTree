package pre.example.collection;

import pre.example.collection.node.Node;

import java.util.UUID;

@SuppressWarnings("unchecked")
public class TestSolution {

    public static void main(String[] args) throws Exception {

        MultiChildTree<String> tree = new MultiChildTree<>();

        Node<String> tn1 = tree.addRoot("root");
        Node tn2 = tree.addNode("sec", tn1);

        System.out.println("root :" + tree.getRoot().getData());
        System.out.println("sec  :" + tn2.getData());
        System.out.println("parent of sec:" + tn2.getParent().getData());

        MultiChildTreeHelper th = new MultiChildTreeHelper(new MultiChildTree<>());

        UUID rootId = th.addRoot("root");
        UUID secId  = th.addNode("sec", rootId);

        System.out.println("root / uuid:" + rootId + ", data:" + th.findByKey(rootId).getData());
        System.out.println("sec  / uuid:" + secId  + ", data:" + th.findByKey(secId).getData());
    }
}
