package DecisionTrees;

import java.util.ArrayList;

public class HillClimbingSearchAdvanced extends CommonClass {
    Node root;

    @Override
    public void evaluate() throws Exception {
        root = getTree();
        long startTime = System.currentTimeMillis();
        search(root);
        System.out.printf("time taken by HillClimbungSearchAdvanced = %d ms", (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void search(Node node) throws Exception {
        System.out.println("final height = " + root.height);
        ArrayList<Integer> reverseOrder = new ArrayList<>();
        reverseOrder = getReverseOrder(root, reverseOrder);
        int result = calculateValue(reverseOrder);
        System.out.printf("low limit = %d, result = %d, maxLimit = %d \n", lowLimit, result, maxLimit);
        System.out.printf("the deviation is = %d \n", Math.abs(result - target));

    }

    private ArrayList<Integer> getReverseOrder(Node node, ArrayList<Integer> reverseOrder) {
        if (node.rightChild != null) {
            if (node.weight < node.rightChild.weight) {
                reverseOrder = getReverseOrder(node.rightChild, reverseOrder);
            }
        }
        reverseOrder.add(node.weight);
        if (node.leftChild != null) {
            reverseOrder = getReverseOrder(node.leftChild, reverseOrder);
        }
        return reverseOrder;
    }

    private int calculateValue(ArrayList<Integer> reverseOrder) {
        int value = 0;
        int deviation = target;
        for (Integer currentValue : reverseOrder) {
            if ((value + currentValue) > target) {
                break;
            } else {
                value += currentValue;
            }
        }


        while (deviation > 0) {
            deviation = target - value;
            if (reverseOrder.contains(deviation)) {
                value += reverseOrder.get(reverseOrder.indexOf(deviation));
                reverseOrder.remove((Object) deviation);
            } else {
                deviation--;
            }
        }

        return value;

    }
}
