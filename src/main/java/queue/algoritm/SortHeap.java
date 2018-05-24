package queue.algoritm;

public class SortHeap extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortHeap=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        array = makeHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            array = heapify(array, i, 0);

        }


        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }


    }

    private int[] makeHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (array[parent] < array[index]) {
                    int temp = array[index];
                    array[index] = array[parent];
                    array[parent] = temp;
                }
                index = parent;
            }

        }
        return array;
    }

    private int[] heapify(int array[], int n, int i) {
        int max, child;
        child = 2 * i + 1;
        max = i;
        if (child < n)
            if (array[child] > array[max])
                max = child;
        if (child + 1 < n)
            if (array[child + 1] > array[max])
                max = child + 1;
        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, n, max);
        }
        return array;
    }
}
