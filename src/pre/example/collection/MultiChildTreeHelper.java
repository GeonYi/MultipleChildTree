package pre.example.collection;

import com.sun.istack.internal.NotNull;
import pre.example.collection.exception.NotExistRootException;
import pre.example.collection.node.Node;
import pre.example.collection.tree.Tree;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MultiChildTreeHelper<T> {

    private Tree tree;
    private Map<UUID, Node<?>> findMap = new ConcurrentHashMap<>();

    public MultiChildTreeHelper(Tree t) {
        this.tree = t;
    }

    /**
     *  find node by key as UUID type.
     *
     * @param key UUID type key
     * @return node
     * */
    public Node findByKey(UUID key) throws Exception {
        // todo : may be more smart... for example, binary search and so on....
        return this.findMap.get(key);
    }

    /**
     *
     *
     * */
    public UUID addRoot(T root) throws Exception {

        UUID uid = this.getUUID();
        Node node = tree.addRoot(root);
        this.addHash(uid, node);
        return uid;
    }


    public UUID addNode(T o, UUID parentId) throws NotExistRootException {
        Node n = tree.addNode(o, this.findMap.get(parentId));
        UUID uid = this.getUUID();
        this.addHash(uid, n);
        return uid;
    }

    @NotNull
    private Boolean addHash(UUID key, Node node) {
        try{
            this.findMap.put(key, node);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private UUID getUUID(){
        return UUID.randomUUID();
    }
}
