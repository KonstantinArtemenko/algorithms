package DecisionTrees;

public class HillClimbingSearch extends CommonClass {
    Node root;

    @Override
    public void evaluate() throws Exception {
        root = getTree();
        long startTime = System.currentTimeMillis();
        search(root);
        System.out.printf("time taken by HillClimbungSearch = %d ms \n", (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void search(Node node) throws Exception {
        System.out.println("final height = " + root.height);
        int result = climbHill(root, 0);
        System.out.printf("low limit = %d, result = %d, maxLimit = %d \n", lowLimit, result, maxLimit);
        System.out.printf("the deviation is = %d \n", Math.abs(result-target));
    }

    private int climbHill(Node node, int sumWeight) {
        sumWeight+=node.weight;
        int deviationLeft=average;
        int deviationRight = average;
        if (node.leftChild != null) {
            deviationLeft = Math.abs(node.leftChild.weight - average);
        }
        if (node.rightChild != null) {
            deviationRight = Math.abs(node.rightChild.weight - average);
        }
        int minDeviation = Math.min(deviationLeft, deviationRight);
        int path = ((Comparable) deviationLeft).compareTo(deviationRight);
        int notLeaf = ((Comparable) minDeviation).compareTo(average);

        if (path < 0 && notLeaf < 0) {
            sumWeight=climbHill(node.leftChild, sumWeight);
        } else if (path >= 0&&notLeaf<0) {
            sumWeight=climbHill(node.rightChild, sumWeight);
        } else {
            return sumWeight;
        }
        return sumWeight;
    }
}
