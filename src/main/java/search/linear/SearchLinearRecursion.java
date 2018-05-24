package search.linear;

public class SearchLinearRecursion extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        Integer[] array = getArray();
        long startTime = System.currentTimeMillis();
        find(array, 0, 0, getTarget());
        System.out.println("time taken by SearchLinearRecusrion=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected int find(Integer[] array, int startIndex, int endIndex, int target) throws Exception {
        if (array[startIndex]==target) {
            return 0;
        }
        if ((startIndex+1)==array.length) {
            System.out.println("nothing found");
        }
        startIndex++;
        find(array, startIndex, endIndex, target);

        return 0;
    }
}
