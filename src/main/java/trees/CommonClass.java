package trees;

import java.util.Random;

public abstract class CommonClass  {
    private static final int QTY = 100_000;
    private static final int RANGE = 2_000_000;
    private int[] arrayForSort = new int[QTY];

    public abstract void evaluate () throws Exception;

    protected abstract void sort(int [] array) throws Exception;

    private void calculateArray() {
        Random random = new Random();
        for (int i = 0; i < arrayForSort.length; i++) {
            arrayForSort[i] = random.nextInt(RANGE);
        }
    }

    public int[] getArray() {
        calculateArray();
        return arrayForSort;
    }

    public void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
