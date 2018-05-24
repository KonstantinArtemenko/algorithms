package queue.algoritm;

import java.util.*;

public class SortCount extends CommonClass {
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortCount=" + (System.currentTimeMillis() - startTime));
    }

    protected void sort(int[] array) throws Exception {
        Map<Integer, Stack> hashMap = new HashMap<Integer, Stack>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(array[i]) == null) {
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(array[i]);
                hashMap.put(array[i], stack);
            } else {
                Stack stack = hashMap.get(array[i]);
                stack.push(array[i]);
                hashMap.put(array[i], stack);
            }
        }

        Integer[] sortedArray = new Integer[array.length];
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
