package trees;

public class Node {
    Node leftChild;
    Node rightChild;
    int value;

    public Node (int value) {
        this.value=value;
        leftChild=null;
        rightChild=null;
    }
}
