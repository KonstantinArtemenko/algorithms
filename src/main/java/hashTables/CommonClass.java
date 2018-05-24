package hashTables;

import java.util.Random;

public abstract class CommonClass {
    private static final int QTY = 250;
    private static final int RANGE = 100;
    private int[] arrayForSort = new int[QTY];
    private int BLOCKS=10;
    private int DIVIDER =10;


    public int getDIVIDER() {
        return DIVIDER;
    }

    public abstract void evaluate ();

    protected abstract void getHash(int [] array, int blocks, int divider);

    public int getBLOCKS() {
        return BLOCKS;
    }

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
    }
}
