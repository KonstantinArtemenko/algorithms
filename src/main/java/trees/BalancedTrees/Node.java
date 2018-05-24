package trees.BalancedTrees;

public class Node {

    public int value;
    public int height;
    public Node leftChild;
    public Node rightChild;

    public Node(int value) {
        this.value = value;
        height = 1;
    }
}