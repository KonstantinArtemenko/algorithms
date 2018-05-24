package DecisionTrees;

public class Node {
    int weight;
    Node leftChild;
    Node rightChild;
    int height;

    public Node(int weight) {
        this.weight = weight;
        leftChild=null;
        rightChild =null;
        this.height=1;
    }
}
