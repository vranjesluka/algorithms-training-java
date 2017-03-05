package hackerrank.crackingthecodinginterview.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C4_LinkedListsDetectACycle {
    private class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Node currentNode = head;
        Set<Node> nodeHashes = new HashSet<>();
        while (currentNode != null) {
            nodeHashes.add(currentNode);
            currentNode = currentNode.next;
            if (nodeHashes.contains(currentNode)) {
                return true;
            }
        }
        return false;
    }
}
