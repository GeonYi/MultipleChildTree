package pre.example.collection.tree;

import pre.example.collection.exception.AlreadyExistRootException;
import pre.example.collection.exception.NotExistRootException;
import pre.example.collection.node.Node;

public interface Tree<T> {
    <T extends Node> T addRoot(Object o) throws AlreadyExistRootException;
    <T extends Node> T addNode(Object data, Node<T> parent) throws NotExistRootException;
}
