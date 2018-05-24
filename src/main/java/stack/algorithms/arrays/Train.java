package stack.algorithms.arrays;

import java.util.Random;
import java.util.Stack;

public class Train {
    public static void main(String[] args) {
        final int TYPES_TRAINS = 7;
        final int QTY = 150;
        Train train = new Train();
        Stack<Integer> stack = new Stack<Integer>();
        stack = train.insertIntoStack(train.getArray(QTY, TYPES_TRAINS));

        System.out.println(stack.size());

        train.printStack(train.pushToStacks(stack, TYPES_TRAINS));


    }

    private int[] getArray(int length, int qty) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(qty);
        }
        return array;
    }

    private Stack<Integer> insertIntoStack(int[] array) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        System.out.println(stack);
        return stack;
    }

    private Stack<Integer>[] pushToStacks(Stack<Integer> stack, int qty) {
        Stack<Integer>[] arrayStacks = new Stack[qty];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            arrayStacks = findStack(arrayStacks, stack.pop());
        }
        return arrayStacks;
    }
    static int ccount=0;

    private Stack<Integer>[] findStack(Stack<Integer>[] arrayStacks, int number) {
        if (arrayStacks[number] == null) {
            arrayStacks[number] = new Stack<Integer>();
            arrayStacks[number].push(number);
            ccount++;
        } else {
            (arrayStacks[number]).push(number);
            ccount++;
        }
        return arrayStacks;
    }

    private void printStack(Stack<Integer>[] stacks) {
        Stack finalStack = new Stack();
        for (Stack<Integer> stack : stacks) {
            int size=stack.size();
           for (int i=0; i<size; i++) {
               finalStack.push(stack.pop());
           }
        }
        System.out.println(finalStack);
    }
}
