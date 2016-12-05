package pre.example.collection.node;

import java.util.List;

interface NodeDefaultBehavior {

    // get childes of node
    List<? extends Node> getChildes();

    // get childes of node
    <T extends Node> T getParent();
}
