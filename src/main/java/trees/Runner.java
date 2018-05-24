package trees;

import queue.algoritm.SortPiramidMy;
import trees.BalancedTrees.AVLTree;

public class Runner {
    public static void main(String[] args) throws Exception{
        Heap heap = new Heap();
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        InOrder inOrder = new InOrder();
        PostOrder postOrder = new PostOrder();
        LevelOrder levelOrder = new LevelOrder();
        AddNodeToTree addNodeToTree = new AddNodeToTree();
        FindNode findNode = new FindNode();
        DeleteNode deleteNode = new DeleteNode();
        NewDeletion newDeletion = new NewDeletion();
        SortPiramidMy sortPiramidMy = new SortPiramidMy();
        AVLTree avlTree = new AVLTree();
//        heap.evaluate();
//        preOrderTraversal.evaluate();
//        inOrder.evaluate();
//        postOrder.evaluate();
//        levelOrder.evaluate();
//        addNodeToTree.evaluate();
//        findNode.evaluate();
//        deleteNode.evaluate();
//        newDeletion.evaluate();
//        sortPiramidMy.evaluate();
        avlTree.evaluate();
        

    }
}
