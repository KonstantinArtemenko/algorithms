package queue.algoritm;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class SortQuick extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortQuick=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        array = quickSort(array, 0, array.length-1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }
    }

    private int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int initialStart = start;
        int initialEnd = end;

        int value = array[start];
        Queue<Integer> lessThen = new ArrayDeque<>();
        Queue<Integer> greaterThen = new ArrayDeque<>();
        for (int i = start + 1; i <=end; i++) {
            if (array[i] >= value) {
                greaterThen.add(array[i]);
            } else {
                lessThen.add(array[i]);
            }
        }
        int sizeLessThen = lessThen.size();
        int sizeGreaterThen = greaterThen.size();

        for (int i = start; i < sizeLessThen + start; i++) {
            array[i] = lessThen.poll();
        }
        int mid = start + sizeLessThen;
        array[mid] = value;

        for (int i = mid + 1; i < mid + sizeGreaterThen + 1; i++) {
            array[i] = greaterThen.poll();
        }

        array=quickSort(array, start, mid-1);
        if ((initialStart == mid) && (initialEnd == end)) {
            return array;

        } else {
            array=quickSort(array, mid+1, end);
        }
        return array;
    }


}



