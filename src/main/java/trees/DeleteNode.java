package trees;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.LinkedList;

public class DeleteNode extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by deletionNodeInTree=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            hashMap = getSortedHashMap(hashMap, array[i], 0);
//        }

        Integer[] newArray = {60,35,76,21,42,71,89,17,24,null,null,68,null,null,null,11,null,23, null, null, null, null, null, 63,69};
        for (int i = 0; i < newArray.length; i++) {
            hashMap.put(i, newArray[i]);
        }


        Integer key = findNode(hashMap, newArray[5], 0);
        System.out.printf("key=%,8d value=%,8d%n", key, hashMap.get(key));

        hashMap=deleteNode(hashMap, key);
        System.out.println(hashMap.get(11));
        System.out.println(hashMap.get(12));

        if (hashMap.get(key) == null) {
            System.out.println("deletion successful");
        } else {
            System.out.println("ALARM");
        }

    }

    private HashMap<Integer, Integer> getSortedHashMap(HashMap<Integer, Integer> hashMap, int value, int index) {
        if (hashMap.get(0) == null) {
            hashMap.put(0, value);
        }
        if (hashMap.get(index) > value) {
            if (hashMap.get(2 * index + 1) == null) {
                hashMap.put(2 * index + 1, value);
            } else {
                getSortedHashMap(hashMap, value, 2 * index + 1);
            }
        } else {
            if (hashMap.get(2 * index + 2) == null) {
                hashMap.put(2 * index + 2, value);
            } else {
                getSortedHashMap(hashMap, value, 2 * index + 2);
            }
        }
        return hashMap;
    }

    private Integer findNode(HashMap<Integer, Integer> hashMap, int target, int index) {
        if (hashMap.get(index) == target) {
            System.out.print("Search finished, ");
            System.out.printf("target=%,8d result=%,8d%n", target, hashMap.get(index));

//            System.out.println("Search finished, target="+target+" current="+hashMap.get(index));
            return index;
        }

        if (hashMap.get(index) > target) {
            if (hashMap.get(2 * index + 1) == null) {
                System.out.println("Search finished, object not found");
                return -1;
            } else {
                index = findNode(hashMap, target, 2 * index + 1);
            }
        } else {
            if (hashMap.get(2 * index + 2) == null) {
                System.out.println("Search finished, object not found");
                return -1;
            } else {
                index = findNode(hashMap, target, 2 * index + 2);
            }
        }
        return index;
    }

    private HashMap<Integer, Integer> deleteNode(HashMap<Integer, Integer> hashMap, int index) {
        boolean leftChild = false;
        boolean rightChild = false;

        if (hashMap.get(2 * index + 1) != null) {
            leftChild = true;
        }
        if (hashMap.get(2 * index + 2) != null) {
            rightChild = true;
        }


        if ((!leftChild) && (!rightChild)) {
            hashMap.put(index, null);
            return hashMap;
        }


        if (leftChild ^ rightChild) {
            System.out.println("iha-ha");
            hashMap=recursiveDeletionOneChild(hashMap, index);
            return hashMap;
        }
        return hashMap;

    }

    private HashMap<Integer, Integer> recursiveDeletionOneChild(HashMap<Integer, Integer> hashMap, int index) {
        if (hashMap.get(2 * index + 1) != null) {
            hashMap.put(index, hashMap.get(2 * index + 1));
            hashMap=recursiveDeletionOneChild(hashMap, 2 * index + 1);
        } else {
            hashMap.put(index, null);
            return hashMap;
        }
        if (hashMap.get(2 * index + 2) != null) {
            hashMap.put(index+1, hashMap.get(2 * index + 2));
            hashMap=recursiveDeletionOneChild(hashMap, 2 * index + 2);
        } else {
            hashMap.put(index, null);
            return hashMap;
        }
        return hashMap;

    }


}
