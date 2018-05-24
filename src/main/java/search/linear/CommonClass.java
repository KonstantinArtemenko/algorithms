package search.linear;

import java.util.*;

public abstract class CommonClass{
    private static final int QTY = 5_000_000;
    private static final int RANGE = 2000_000_000;

    private int[] arrayForSort = new int[QTY];
    private Integer[] sortedArray = new Integer[QTY];

    private int target;

    public int getTarget() {
        return sortedArray[sortedArray.length-1];
    }

    public abstract void evaluate () throws Exception;

    protected abstract int find(Integer [] array, int startIndex, int endIndex, int target) throws Exception;

    private void calculateArray() {
        Random random = new Random();
        for (int i = 0; i < arrayForSort.length; i++) {
            arrayForSort[i] = random.nextInt(RANGE);
        }
    }

    public Integer[] getArray() throws Exception {
        calculateArray();
        sort();
        return sortedArray;
    }


   private void sort() throws Exception {
        Map<Integer, Stack> hashMap = new HashMap<Integer, Stack>();
        for (int i = 0; i < arrayForSort.length; i++) {
            if (hashMap.get(arrayForSort[i]) == null) {
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(arrayForSort[i]);
                hashMap.put(arrayForSort[i], stack);
            } else {
                Stack stack = hashMap.get(arrayForSort[i]);
                stack.push(arrayForSort[i]);
                hashMap.put(arrayForSort[i], stack);
            }
        }

        int count = 0;
        Set<Integer> set = new HashSet();
        set=hashMap.keySet();
        List lists = new ArrayList();
        for (Integer key:set) {
            lists.add(key);
        }
        Collections.sort(lists);

        for (int i=0; i<lists.size(); i++ ) {
            while (hashMap.get(lists.get(i)).size() > 0) {
                sortedArray[count] = (Integer) hashMap.get(lists.get(i)).pop();
                count++;
            }
        }
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] < sortedArray[i - 1]) {
                throw new Exception();
            }
        }
    }
}
