package recursion;

import java.util.Stack;

public class Hanoi {
    private static final int QTY = 3;
    private static final int START_POSITION = 0;
    private static final int TARGET_POSITION = 1;
    private static final int OTHER_POSITION = 2;

    Stack[] stacks = new Stack[QTY];

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.fillStartRow();
        hanoi.resort(START_POSITION, TARGET_POSITION, OTHER_POSITION, QTY);
        hanoi.printStack();
    }

    private void fillStartRow() {
        int disk = QTY-1;
        for (int i = 0; i < QTY; i++) {
            if (i == 0) {
                stacks[START_POSITION] = new Stack();
                stacks[START_POSITION].push(disk);
                disk--;
            } else {
                stacks[START_POSITION].push(disk);
                disk--;
            }
        }
    }

    private void resort(int from, int to, int other, int n) {
        if (n > 1) {
            if (stacks[other]==null) {
                stacks[other] = new Stack();
            }
            if (stacks[to]==null) {
                stacks[to] = new Stack();
            }
            stacks[other].push(stacks[START_POSITION].pop());
            resort(from, other, to, n - 1);
        }
        if (n > 1) {
            stacks[to].push(stacks[other].pop());
            resort(other, to, from, n - 1);
        }
    }



    private void printStack() {
        int stackSize;
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i] == null) {
                stackSize = 0;
            } else {
                stackSize = stacks[i].size();
            }
            for (int j = stackSize; stackSize > 0; stackSize--) {
                System.out.println("Current stack=" + (i) + " position in stack= " + stackSize + " equal to=" + stacks[i].pop());
            }
        }
    }

}
