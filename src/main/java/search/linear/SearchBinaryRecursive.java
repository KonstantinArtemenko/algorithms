package search.linear;

public class SearchBinaryRecursive extends CommonClass {

    @Override
    public void evaluate() throws Exception {
        Integer[] array = getArray();
        long startTime = System.currentTimeMillis();
        find(array, 0, 0, getTarget());
        System.out.println("time taken by SearchBinaryRecursive=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected int find(Integer[] array, int startIndex, int endIndex, int target) throws Exception {
        int mid = (startIndex+endIndex)/2;
        if (array[mid]==target) {
            return 0;
        } else if (array[mid]>target) {
            find(array, startIndex, mid, target);
        } else if (mid==startIndex) {
            startIndex++;
        } else {
            find(array, mid, endIndex, target);
        }
        return -1;
    }
}
