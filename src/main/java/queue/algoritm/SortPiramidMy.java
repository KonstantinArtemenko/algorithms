package queue.algoritm;

import java.util.ArrayList;
import java.util.HashMap;

public class SortPiramidMy extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortPyramidMy=" + (System.currentTimeMillis() - startTime));
    }

    Node root;

    @Override
    protected void sort(int[] array) throws Exception {
        ArrayList<Integer> sortedList = new ArrayList<>();
        root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            root = makeTree(root, array[i]);
        }

        sortedList = getSortedList(root, sortedList);

        for (int i = 1; i < array.length; i++) {
            if (sortedList.get(i) < sortedList.get(i - 1)) {
                throw new Exception();
            }
        }

        System.out.println("height UNsorted tree="+(Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild))+1));

    }

    int maxDepth(Node node) {
        if (node == null) {
            return (-1); // an empty tree  has height −1
        } else {
            // compute the depth of each subtree
            int leftDepth = maxDepth(node.leftChild);
            int rightDepth = maxDepth(node.rightChild);
            // use the larger one
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    private Node makeTree(Node node, int value) {

        if (value < node.value){
            if (node.leftChild == null) {
                node.leftChild = new Node(value);
                return node;
            } else {
                makeTree(node.leftChild, value);
            }
        } else{
            if (node.rightChild == null) {
                node.rightChild = new Node(value);
                return node;
            } else {
                makeTree(node.rightChild, value);
            }
        }
        return node;
    }

    private ArrayList<Integer> getSortedList(Node node, ArrayList<Integer> sortedList) {
        if (node.leftChild != null) {
            sortedList = getSortedList(node.leftChild, sortedList);
        }
        sortedList.add(node.value);

        if (node.rightChild != null) {
            sortedList = getSortedList(node.rightChild, sortedList);
        }
        return sortedList;
    }

}
