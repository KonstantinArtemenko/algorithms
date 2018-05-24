package hashTables;

import java.util.LinkedList;

public class HashDirectLinkedList extends CommonClass {
    @Override
    public void evaluate() {
        long startTime = System.currentTimeMillis();
        getHash(getArray(), getBLOCKS(), getDIVIDER());
        System.out.println("time taken by HashDirectLinkedList=" + (System.currentTimeMillis() - startTime));

    }

    @Override
    protected void getHash(int[] array, int blocks, int divider) {
        LinkedList<Integer>[] lists = new LinkedList[blocks];
        for (int i = 0; i < array.length; i++) {
            int hash = Math.floorMod(array[i], divider);
            if (lists[hash] == null) {
                lists[hash] = new LinkedList<>();
                lists[hash] = addValueAndSort(array[i], lists[hash]);
            } else {
                lists[hash] = addValueAndSort(array[i], lists[hash]);
            }
        }
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            int listSize;
            if (lists[i]==null) {
                listSize=0;
            } else {
                listSize = lists[i].size();
            }
            count+=listSize;
            System.out.println("size hash i= " + i + " equals to = " + listSize);
//            for (int j = 0; j < listSize; j++) {
//                System.out.println(lists[i].get(j));
//            }
        }
        System.out.println("count="+count);
        System.out.println("length average="+count/blocks);
    }

    private LinkedList<Integer> addValueAndSort(int value, LinkedList<Integer> list) {
        if (list.size() == 0) {
            list.add(value);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (value < list.get(i)) {

                    list.add(i, value);
                    break;
                }
                if (i==(list.size()-1)) {
                    list.add(value);
                    break;
                }
            }
        }
        return list;
    }
}

