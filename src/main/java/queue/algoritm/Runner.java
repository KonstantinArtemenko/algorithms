package queue.algoritm;

import trees.BalancedTrees.AVLTree;

public class Runner {

    public static void main(String[] args) throws Exception {

        SortChoiseMin sortChoiseMin = new SortChoiseMin();
        SortInsert sortInsert = new SortInsert();
        SortBubble sortBubble = new SortBubble();
        SortBubbleAdvanced sortBubbleAdvanced = new SortBubbleAdvanced();
        SortBubleExpert sortBubleExpert = new SortBubleExpert();
        SortHeap sortHeap = new SortHeap();
        SortCount sortCount = new SortCount();
        SortQuick sortQuick = new SortQuick();
        SortPiramidMy sortPiramidMy = new SortPiramidMy();
//        AVLTree avlTree = new AVLTree();
//        sortInsert.evaluate();   //works
//        sortBubble.evaluate();  //works
//        sortChoiseMin.evaluate();  //works
//        sortBubbleAdvanced.evaluate(); //works
//        sortCount.evaluate();
//        sortHeap.evaluate();
        sortQuick.evaluate();
//        sortPiramidMy.evaluate();
//        avlTree.evaluate();
    }
}
