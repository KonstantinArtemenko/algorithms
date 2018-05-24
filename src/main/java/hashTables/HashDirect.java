package hashTables;

import java.util.Stack;

public class HashDirect extends CommonClass {
    @Override
    public void evaluate() {
        long startTime = System.currentTimeMillis();
        getHash(getArray(), getBLOCKS(), getDIVIDER());
        System.out.println("time taken by HashDirect=" + (System.currentTimeMillis() - startTime));

    }

    @Override
    protected void getHash(int[] array, int blocks, int divider) {
        Stack<Integer>[] stacks = new Stack[blocks];
        for (int i = 0; i < array.length; i++) {
            int hash = Math.floorMod(array[i], divider);
            if (stacks[hash] == null) {
                stacks[hash] = new Stack<>();
                stacks[hash].push(array[i]);
            } else {
                stacks[hash].push(array[i]);
            }
        }

        for (int i = 0; i < stacks.length; i++) {
            int stackSize = stacks[i].size();
            System.out.println(stackSize);
//            for (int j = 0; j < stackSize; j++) {
//                System.out.println(stacks[i].pop());
//            }
        }
    }


}
