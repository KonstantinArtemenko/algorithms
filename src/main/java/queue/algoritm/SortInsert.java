package queue.algoritm;

import java.util.Random;

public class SortInsert extends CommonClass {

    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortInsert=" + (System.currentTimeMillis() - startTime));
    }


    protected void sort(int[] array) throws Exception {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if ((j > i) && (array[j] < array[i])) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }

    }
}
