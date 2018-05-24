package trees.BalancedTrees;

import trees.CommonClass;

import java.util.ArrayList;

public class AVLTree extends CommonClass {

    private Node root;

    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by AVLTree=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        ArrayList<Integer> sortedList = new ArrayList<>();
        root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            root = insert(root, array[i]);
        }
        sortedList = inOrder(root, sortedList);
        checkTree(sortedList, array.length);
        System.out.println("height sorted  AVL tree="+(Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild))+1));
    }

    private void checkTree(ArrayList<Integer> sortedList, int length) throws Exception {
        if (sortedList.size() != length) {
            System.out.println("sorted size=" + sortedList.size() + " arraySize=" + length);
            System.out.println("Wrong size");
            throw new Exception();
        }

        for (int i = 1; i < length; i++) {
            if (sortedList.get(i) < sortedList.get(i - 1)) {
                throw new Exception();
            }
        }
    }

    private ArrayList<Integer> inOrder(Node node, ArrayList<Integer> sortedList) {
        if (node.leftChild != null) {
            inOrder(node.leftChild, sortedList);
        }
        sortedList.add(node.value);
        if (node.rightChild != null) {
            inOrder(node.rightChild, sortedList);
        }

        return sortedList;

    }


    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        } else {
            int k = ((Comparable) node.value).compareTo(value);
            if (k > 0) {
                node.leftChild = insert(node.leftChild, value);
            } else {
                node.rightChild = insert(node.rightChild, value);
            }
            node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
            int heightDiff = heightDiff(node);
            if (heightDiff < -1) {
                if (heightDiff(node.rightChild) > 0) {
                    node.rightChild = rightRotate(node.rightChild);
                    return leftRotate(node);
                } else {
                    return leftRotate(node);
                }
            } else if (heightDiff > 1) {
                if (heightDiff(node.leftChild) < 0) {
                    node.leftChild = leftRotate(node.leftChild);
                    return rightRotate(node);
                } else {
                    return rightRotate(node);
                }
            } else;

        }
        return node;
    }

    private Node leftRotate(Node n) {
        Node r = n.rightChild;
        n.rightChild = r.leftChild;
        r.leftChild = n;
        n.height = Math.max(height(n.leftChild), height(n.rightChild)) + 1;
        r.height = Math.max(height(r.leftChild), height(r.rightChild)) + 1;
        return r;
    }

    private Node rightRotate(Node n) {
        Node r = n.leftChild;
        n.leftChild = r.rightChild;
        r.rightChild = n;
        n.height = Math.max(height(n.leftChild), height(n.rightChild)) + 1;
        r.height = Math.max(height(r.leftChild), height(r.rightChild)) + 1;
        return r;
    }

    private int heightDiff(Node a) {
        if (a == null) {
            return 0;
        }
        return height(a.leftChild) - height(a.rightChild);
    }

    private int height(Node a) {
        if (a == null) {
            return 0;
        }
        return a.height;
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

}