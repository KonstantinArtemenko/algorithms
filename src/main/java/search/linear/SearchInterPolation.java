package search.linear;

public class SearchInterPolation extends CommonClass {
    @Override
    public void evaluate() throws Exception {
        Integer[] array = getArray();
        long startTime = System.currentTimeMillis();
        find(array, 0, 0, getTarget());
        System.out.println("time taken by SearchInterPolation=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected int find(Integer[] array, int startIndex, int endIndex, int target) throws Exception {
        int mid;
        if (startIndex==endIndex) {
          mid=startIndex;
        } else {
            mid = startIndex + (endIndex - startIndex) * (target - array[startIndex]) / (array[endIndex] - array[startIndex]);
        }
        if (array[mid]==target) {
            return 0;
        } else if (array[mid]>target) {
            find(array, startIndex, mid, target);
        } else if (startIndex==mid) {
            startIndex++;
        } else {
            find(array, mid, endIndex, target);
        }
        return -1;
    }
}
