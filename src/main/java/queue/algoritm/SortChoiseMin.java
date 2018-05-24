package queue.algoritm;

public class SortChoiseMin extends CommonClass {
    public void evaluate() throws Exception {
        long startTime = System.currentTimeMillis();
        sort(getArray());
        System.out.println("time taken by SortChoiseMin=" + (System.currentTimeMillis() - startTime));

    }

    protected void sort (int [] array) throws Exception{
        for (int i=0; i<array.length; i++) {
            int min = array[i];
            for (int j=i; j<array.length; j++) {

                if (array[j]<min) {
                    min =array[j];
                    array[j]=array[i];
                    array[i]=min;
                }
            }
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new Exception();
            }
        }
    }
}

