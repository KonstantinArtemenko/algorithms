package trees;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LevelOrder extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println("time taken by Level-order Traversal=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            list.add(array[i]);
        }
        levelOrderTraversal(list, 0);

    }

    private void levelOrderTraversal(ArrayList<Integer> list, int i) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(list.get(0));

        while (queue.size()>0) {
            int value = queue.poll();
            int node=list.indexOf(value);
            System.out.println("END="+node);
            if ((2*node+1)<list.size()) {
                queue.add(list.get(2*node+1));
            }
            if ((2*node+2)<list.size()) {
                queue.add(list.get(2*node+2));
            }
        }
    }
}
