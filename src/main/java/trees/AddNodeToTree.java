package trees;

import java.util.ArrayList;

public class AddNodeToTree extends CommonClass {

    @Override
    public void evaluate() throws Exception {
        int[] array = getArray();
        long startTime = System.currentTimeMillis();
        printArray(array);
        sort(array);
        System.out.println("time taken by AddNodeToTree=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void sort(int[] array) throws Exception {
       Integer[] sortedArray = new Integer[100];
        for (int i = 0; i < array.length; i++) {
            sortedArray = buildRightTree(sortedArray, array[i], 0);
        }
        for (int i=0; i<sortedArray.length; i++) {
            System.out.println("a["+i+"]="+sortedArray[i]);
        }
    }
    static int last=0;

    private Integer[] buildRightTree(Integer[] sortedArray, int value, int i) {
        if (sortedArray[0] == null) {
            sortedArray[0]=value;
            return sortedArray;
        }


        if (value < sortedArray[i]) {
            if (sortedArray[2*i+1]==null) {
                sortedArray[2*i+1]=value;

            } else {
                buildRightTree(sortedArray, value, 2*i+1);
            }
        }
            else{
            if (sortedArray[2*i+2]==null) {
                sortedArray[2*i+2]=value;
            } else {
                buildRightTree(sortedArray, value, 2*i+2);
            }
        }
        return sortedArray;
    }
}
