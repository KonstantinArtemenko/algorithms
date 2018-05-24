package search.linear;

public class SearchBinary extends CommonClass{
    @Override
    public void evaluate() throws Exception {
        Integer[] array = getArray();
        long startTime = System.currentTimeMillis();
        find(array, 0, 0, getTarget());
        System.out.println("time taken by SearchBinary=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected int find(Integer[] array, int startIndex, int endIndex, int target) throws Exception {
        int min = 0;
        int max = array.length-1;
        while (min<=max) {
            int mid = (min+max)/2;
            if (array[mid]==target) {
                return 0;
            } if (array[mid]>target) {
                max=mid;
            } else if (min==mid){
                min++;
            } else {
                min=mid;
            }
        }
        return -1;
    }
}
