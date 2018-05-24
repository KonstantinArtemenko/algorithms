package queue.algoritm;

public class SortBubbleAdvanced extends CommonClass {

    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortBubbleAdvanced=" + (System.currentTimeMillis() - startTime));
    }

    protected void sort(int[] array) throws Exception {
        boolean notSorted = true;
        boolean direction = true;

        while (notSorted) {
            notSorted = false;
            if (direction) {
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        notSorted = true;
                    }
                }
                direction = false;
            } else {
                for (int i = array.length-1; i > 0; i--) {
                    if (array[i] < array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        notSorted = true;
                    }
                }
                direction = true;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }
    }
}
