package DecisionTrees;

import java.util.*;

public class HeuristicsSearch extends CommonClass {
    private Node root;
    private int qty = getQTY() / 100;
    private int rightQty;

    @Override
    public void evaluate() throws Exception {
        root = getTree();
        long startTime = System.currentTimeMillis();
        search(root);
        System.out.printf("time taken by HeuristicsSearch = %d ms \n", (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void search(Node node) throws Exception {
        System.out.println("final height = " + root.height);
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            arrayList.add(calculateWeight(root, 0, random.nextInt(getQTY()), random));
        }
//        sortedList = sortCollection(arrayList, 0, arrayList.size());
        sortedList = arrayList;
        System.out.printf("the deviation is = %d \n", checkDeviation(sortedList));
        System.out.printf("low limit = %d, right values found = %d, maxLimit = %d \n", lowLimit, rightQty, maxLimit);
    }

    private int calculateWeight(Node node, int sumWeight, int startValue, Random random) {
        boolean leftDirection = random.nextBoolean();

        boolean leftChild = false;
        boolean rightChild = false;
        if (node.leftChild != null) {
            leftChild = true;
        }
        if (node.rightChild != null) {
            rightChild = true;
        }
        sumWeight += node.weight;
        if (leftChild && rightChild) {
            if (leftDirection) {
                sumWeight = calculateWeight(node.leftChild, sumWeight, startValue, random);
            } else {
                sumWeight = calculateWeight(node.rightChild, sumWeight, startValue, random);
            }
        }

        if (leftChild ^ rightChild) {
            if (leftChild) {
                sumWeight = calculateWeight(node.leftChild, sumWeight, startValue, random);
            } else {
                sumWeight = calculateWeight(node.rightChild, sumWeight, startValue, random);
            }
        }
        return sumWeight;
    }

    private ArrayList sortCollection(ArrayList<Integer> unSortedList, int start, int end) {
        if (start == end) {
            return unSortedList;
        }
        int initialStart = start;
        int initialEnd = end;
        Queue<Integer> lessThen = new ArrayDeque<>();
        Queue<Integer> greaterThen = new ArrayDeque<>();
        int result;
        int comparableValue = unSortedList.get(start);
        for (int i = start + 1; i < end; i++) {
            result = ((Comparable) unSortedList.get(i)).compareTo(comparableValue);
            if (result < 0) {
                lessThen.add(unSortedList.get(i));
            } else {
                greaterThen.add(unSortedList.get(i));
            }
        }
        int lessThenSize = lessThen.size();
        for (int i = start; i < lessThenSize; i++) {
            unSortedList.set(i, lessThen.poll());
        }
        unSortedList.set(start + lessThenSize, comparableValue);


        for (int i = start + lessThenSize + 1; i < end; i++) {
            unSortedList.set(i, greaterThen.poll());
        }
        int middle = (start + end) / 2 + 1;
        if (initialEnd != middle | initialStart != start) {
            unSortedList = sortCollection(unSortedList, start, middle);
        }

        unSortedList = sortCollection(unSortedList, middle, end);

        return unSortedList;
    }

    private int checkDeviation(ArrayList<Integer> sortedList) {
        int deviation = getRANGE();
        int maxDifference = target - lowLimit;
        for (Integer value : sortedList) {
            int difference = Math.abs(value - target);
            if (difference < deviation) {
                deviation = difference;
            }
            if (difference < maxDifference) {
                rightQty++;
            }
        }
        return deviation;

    }

}

