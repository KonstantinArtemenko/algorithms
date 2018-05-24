package search.linear;

public class Runner {
    public static void main(String[] args) throws Exception {
        SearchLinear searchLinear = new SearchLinear();
        SearchLinearRecursion searchLinearRecursion = new SearchLinearRecursion();
        SearchBinary searchBinary = new SearchBinary();
        SearchBinaryRecursive searchBinaryRecursive = new SearchBinaryRecursive();
        SearchInterPolation searchInterPolation = new SearchInterPolation();
        searchLinear.evaluate();
        //searchLinearRecursion.evaluate(); //bad case
        searchBinary.evaluate();
        searchBinaryRecursive.evaluate();
        searchInterPolation.evaluate();
    }

}
