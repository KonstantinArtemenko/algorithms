package trees;

public class NewDeletion extends CommonClass {

    public NewDeletion() {
        root = null;
    }

    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by NewDeletionNodeInTree=" + (System.currentTimeMillis() - startTime));
    }

    Node root;

    @Override
    protected void sort(int[] array) throws Exception {
//        int[] newArray = {60, 35, 76, 21, 42, 71, 89, 17, 24, 68, 11, 23, 63, 69};
//        for (int i = 0; i < newArray.length; i++) {
//            root = insertIntoTree(newArray[i], root);
//        }

        for (int i=0; i<array.length; i++) {
            root = insertIntoTree(array[i], root);
        }
        root = deleteNode(root, array[array.length-50000]);
        root = deleteNode(root, array[array.length-98000]);
        inOrder(root);

    }

    private Node insertIntoTree(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.leftChild = insertIntoTree(value, node.leftChild);
        } else {
            node.rightChild = insertIntoTree(value, node.rightChild);
        }
        return node;
    }

    private void inOrder(Node node) {
        if (node.leftChild != null) {
            inOrder(node.leftChild);
        }
       // System.out.print(node.value + ", ");
        if (node.rightChild != null) {
            inOrder(node.rightChild);
        }
    }

    private Node findNodeAndDelete(int target, Node node) {
        if ((node.value == target)&&(node.leftChild==null)) {
            node = null;
            return node;
        }
        if (target < node.value) {
            node.leftChild = findNodeAndDelete(target, node.leftChild);
        } else {
            node.rightChild = findNodeAndDelete(target, node.rightChild);
        }
        return node;
    }

    private Node deleteNode(Node node, int target) {
        if (target == node.value) {
            if ((node.leftChild == null) && (node.rightChild == null)) {
                node = null;
                return node;
            }
            if (node.rightChild == null) {
                node = node.leftChild;
                return node;
            }
            if (node.leftChild == null) {
                node = node.rightChild;
                return node;
            }
            node.value = minValue(node.rightChild);
            node = findNodeAndDelete(node.value, node);
            return node;
        }
        if (target < node.value) {
            node.leftChild = deleteNode(node.leftChild, target);
        } else {
            node.rightChild = deleteNode(node.rightChild, target);
        }
        return node;
    }

    private int minValue(Node node) {
        int minValue = node.value;
        while (node.leftChild != null) {
            minValue = node.leftChild.value;
            node = node.leftChild;
        }
        return minValue;
    }
}