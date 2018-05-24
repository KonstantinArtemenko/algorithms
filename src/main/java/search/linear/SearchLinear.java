package search.linear;

public class SearchLinear extends CommonClass {


    @Override
    public void evaluate() throws Exception {
        Integer[] array = getArray();
        long startTime = System.currentTimeMillis();
        find(array, 0,  0, getTarget());
        System.out.println("time taken by easy SearchLinear=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected int find(Integer[] array, int startIndex, int endIndex, int target) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return array[i];
            }
            if (array[i] > target) {
                System.out.println("Nothing matching");
                return -1;
            }
        }
        return -1;
    }
}
