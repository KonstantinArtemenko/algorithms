package DecisionTrees;

public class ExhaustiveSearch extends CommonClass {
    private Node root;


    @Override
    public void evaluate() throws Exception {
        root = getTree();
        long startTime = System.currentTimeMillis();
        search(root);
        System.out.printf("time taken by ExhaustiveSearch = %d ms \n", (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void search(Node node) throws Exception {
        System.out.println("final height = " + root.height);
        int weight = 0;
        weight = calculateWeight(root, weight, 0);
        System.out.printf("low limit = %d, result = %d, maxLimit = %d \n",lowLimit, weight, maxLimit);
        System.out.printf("the deviation is = %d \n", Math.abs(target-weight));
    }

    private int calculateWeight(Node node, int sumWeight, int startValue) {
        boolean founded = check(sumWeight);
        if (founded) {
            return sumWeight;
        }
        boolean leftExist = false;
        boolean rightExist = false;
        if (node.leftChild != null) {
            leftExist = true;
        }

        if (node.rightChild != null) {
            rightExist = true;
        }
        sumWeight += node.weight;
        if (rightExist || leftExist) {
            if (leftExist && startValue < node.leftChild.weight) {
                sumWeight = calculateWeight(node.leftChild, sumWeight, startValue);
            }
            founded=check(sumWeight);
            if (founded) {
                return sumWeight;
            }
            if (rightExist && startValue < node.rightChild.weight) {
                sumWeight = calculateWeight(node.rightChild, sumWeight, startValue);
            }
        }

        founded = check(sumWeight);
        if (!founded) {
            sumWeight=calculateWeight(root, 0, startValue+increasePercent);
        }
        return sumWeight;

    }

    private boolean check(int sumWeight) {
        if (sumWeight > lowLimit&& sumWeight < maxLimit) {
            return true;
        }
        return false;
    }

}
