package trees;

public class InOrder extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by InOrderTraversal=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        inOrderTraversal(array, 0);
    }

    private void inOrderTraversal(int[] array, int i) {
//        System.out.println("current i="+i);
        if ((2*i+1)<(array.length)) {
//            System.out.println("go to i="+(2*i+1));
            inOrderTraversal(array, (2*i+1));
        }
        System.out.println("END i="+i);
        if ((2*i+2)<array.length) {
//            System.out.println("go to i="+(2*i+2));
            inOrderTraversal(array, (2*i+2));
        }
//        System.out.println("go to parent="+(i-1)/2);
    }
}
