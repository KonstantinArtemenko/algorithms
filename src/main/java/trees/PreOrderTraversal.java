package trees;

public class PreOrderTraversal extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by PreOrderTraversal=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        preOrder(array, 0);
    }

    private int[] preOrder(int[] array, int i) {
//        System.out.println("current i=" + i);
        System.out.println("END="+i);
        if ((2 * i + 1) < (array.length)) {
//            System.out.println("go to=" + (2 * i + 1));
            preOrder(array, 2 * i + 1);
        }
        if ((2 * i + 2) < (array.length - 1)) {
//            System.out.println("go to=" + (2 * i + 2));
            preOrder(array, 2 * i + 2);
        }
//        System.out.println("go to =" + (i - 1) / 2);
        return array;
    }
}
