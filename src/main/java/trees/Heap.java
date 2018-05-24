package trees;

public class Heap extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by makening heap =" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
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

        for (int i = 0; (2 * i + 2) < array.length; i++) {
            if ((array[2 * i + 1] > array[i]) || (array[2 * i + 2] > array[i])) {
             throw new Exception();
            }
        }

    }


}
