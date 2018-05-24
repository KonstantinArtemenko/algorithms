package queue.algoritm;

import javax.print.DocFlavor;
import java.util.HashMap;

public class SortBubleExpert extends CommonClass {
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortBubbleExpert=" + (System.currentTimeMillis() - startTime));
    }

    protected void sort(int[] array) throws Exception {
        boolean notSorted = true;
        boolean direction = true;
        int newMinRange = 0;
        int minValue = 1000;
        int maxValue = 0;
        int maxRange = array.length - 1;
        int minRange = 0;
        int NewMaxRange = maxRange;

        while (notSorted) {
            notSorted = false;
            if (direction) {
                for (int i = minRange + 1; i <= maxRange; i++) {
                    maxValue = 0;
                    if (array[i] < array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        notSorted = true;
                        if (temp >= maxValue) {
                            maxValue = temp;
                            NewMaxRange = i - 1;
                        }
                        if (temp <= minValue) {
                            minValue = temp;
                            newMinRange = (i - 1);
                        }
                    }
                }
                direction = false;
            } else {
                minValue = 1000;
                for (int i = maxRange; i > minRange; i--) {
                    if (array[i] < array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        notSorted = true;
                        if (temp <= minValue) {
                            minValue = temp;
                            newMinRange = (i - 1);
                        }
                        if (temp >= maxValue) {
                            maxValue = temp;
                            NewMaxRange = i - 1;
                        }
                    }
                }
                direction = true;
            }
            if ((array[NewMaxRange] > array[maxRange])) {
                array[NewMaxRange] = array[maxRange];
                array[maxRange] = maxValue;
                maxRange--;
            } else {
                maxRange--;
            }
            if (array[newMinRange] < array[minRange]) {
                array[newMinRange] = array[minRange];
                array[minRange] = minValue;
                minRange++;
            } else {
                minRange++;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }
    }
}

