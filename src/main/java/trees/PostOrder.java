package trees;

public class PostOrder extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by Post order Traversal=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        postOrderTraversal(array, 0);
    }

    private void postOrderTraversal (int[] array, int i) {
//        System.out.println("current i="+i);
        if ((2*i+1)<array.length) {
//            System.out.println("go to="+(2*i+1));
            postOrderTraversal(array, 2*i+1);
        }

        if ((2*i+2)<array.length) {
//            System.out.println("go to="+(2*i+2));
            postOrderTraversal(array, (2*i+2));
        }
        System.out.println("END ="+i);

//        System.out.println("go to parent="+(i-1)/2);

    }
}
