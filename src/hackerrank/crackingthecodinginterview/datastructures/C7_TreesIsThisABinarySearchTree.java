package hackerrank.crackingthecodinginterview.datastructures;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C7_TreesIsThisABinarySearchTree {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return checkRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkRecursive(Node root, int min, int max) {
        return root == null ||
                (!(root.data <= min || root.data >= max)
                && checkRecursive(root.left, min, root.data)
                && checkRecursive(root.right, root.data, max));
    }

}
