package trees;

import java.util.HashMap;
import java.util.Map;

public class FindNode extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by FindNodeInTree=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        HashMap<Integer, Integer> sortedMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            sortedMap = getSortedMap(sortedMap, array[i], 0);
        }
        findValue(array[array.length - 1], 0, sortedMap);
    }

    private HashMap<Integer, Integer> getSortedMap(HashMap<Integer, Integer> sortedMap, int value, int index) {
        if (sortedMap.get(0) == null) {
            sortedMap.put(0, value);
        }
        if (value < sortedMap.get(index)) {
            if (sortedMap.get(2 * index + 1) == null) {
                sortedMap.put(2 * index + 1, value);
            } else {
                getSortedMap(sortedMap, value, 2 * index + 1);
            }
            if (sortedMap.get(2 * index + 2) == null) {
                sortedMap.put(2 * index + 2, value);
            } else {
                getSortedMap(sortedMap, value, 2 * index + 2);
            }
        }

        return sortedMap;
    }

    private void findValue(int target, int currentNode, HashMap<Integer, Integer> hashMap) {
        if (hashMap.get(currentNode)==target) {
            System.out.println("search has finished successful");
            return;
        }
        if (hashMap.get(currentNode)>target) {
            if (hashMap.get(2*currentNode+1)==null) {
                System.out.println("Search has finished unsuccessfully");
                return;
            } else {
                findValue(target, 2*currentNode+1, hashMap);
            }
            if (hashMap.get(2*currentNode+2)==null) {
                System.out.println("Search has finished unsuccessfully");
                return;
            }  else {
                findValue(target, 2*currentNode+2, hashMap);
            }
        }
    }
}
