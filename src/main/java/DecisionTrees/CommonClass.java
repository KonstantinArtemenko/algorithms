package DecisionTrees;

import java.util.Random;

public abstract class CommonClass {
    private final int QTY = 1000_000;
    private final int RANGE = 1000;
    protected int lowLimit;
    protected int maxLimit;
    protected int target;
    private int percent = 2;
    protected int increasePercent = getRANGE()*1/100;
    protected int average = RANGE/2;


    public int getQTY() {
        return QTY;
    }

    public int getRANGE() {
        return RANGE;
    }

    private int[] arrayForSort = new int[QTY];
    //private int[] arrayForSort = {41,12,51,2,25,43,66,1,7,13,32,41,47,55,67,0,45,52,65,87};

    private Node root;

    public abstract void evaluate() throws Exception;

    protected abstract void search(Node node) throws Exception;

    private void calculateArray() {
        Random random = new Random();
        for (int i = 0; i < arrayForSort.length; i++) {
            arrayForSort[i] = random.nextInt(RANGE);
        }
    }

    public Node getTree() {
        calculateArray();
        root = new Node(arrayForSort[0]);
        for (int i = 1; i < arrayForSort.length; i++) {
            root = makeTree(root, arrayForSort[i]);
        }
        getPrecision();
        return root;
    }


    private Node makeTree(Node node, int weight) {
        if (weight < node.weight) {
            if (node.leftChild == null) {
                node.leftChild = new Node(weight);
            } else {
                node.leftChild = makeTree(node.leftChild, weight);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node(weight);
            } else {
                node.rightChild = makeTree(node.rightChild, weight);
            }
        }
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        int balance = calculateBalance(node);
        if (balance < -1) {
            if (calculateBalance(node.rightChild) > 0) {
                node.rightChild = rightRotate(node.rightChild);
                return leftRotate(node);
            } else {
                return leftRotate(node);
            }
        } else if (balance > 1) {
            if (calculateBalance(node.leftChild) < 0) {
                node.leftChild = leftRotate(node.leftChild);
                return rightRotate(node);
            } else {
                return rightRotate(node);
            }
        }

        return node;
    }

    private int calculateBalance(Node node) {

        return height(node.leftChild) - height(node.rightChild);
    }


    private Node leftRotate(Node node) {
        Node r = node.rightChild;
        node.rightChild = r.leftChild;
        r.leftChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
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

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void getPrecision() {
        target = root.height * getRANGE() / 2;
        lowLimit = target * (100-percent) / 100;
        maxLimit = target * (100+percent) / 100;
    }
}
