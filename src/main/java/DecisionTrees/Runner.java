package DecisionTrees;

public class Runner {
    public static void main(String[] args) throws Exception {
        ExhaustiveSearch exhaustiveSearch = new ExhaustiveSearch();
        HeuristicsSearch heuristicsSearch = new HeuristicsSearch();
        HillClimbingSearch hillClimbingSearch =new HillClimbingSearch();
        HillClimbingSearchAdvanced hillClimbingSearchAdvanced = new HillClimbingSearchAdvanced();
        exhaustiveSearch.evaluate();
        heuristicsSearch.evaluate();
        hillClimbingSearch.evaluate();
        hillClimbingSearchAdvanced.evaluate();
    }
}
