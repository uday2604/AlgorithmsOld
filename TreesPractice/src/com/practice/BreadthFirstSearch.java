package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-05-09.
 */
public class BreadthFirstSearch {

    //Similar to a level order traversal
    public boolean breadthFirstSearch(BinaryTreeNode root, int searchElement) {

        if(root==null)
            return false;

        else {
            boolean isElementPresent=false;
            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp=nodeStoreQueue.poll();
                if(temp.data==searchElement)
                    isElementPresent=true;

                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);

                if(temp.rlink!=null)
                    nodeStoreQueue.offer(temp.rlink);
            }

            return isElementPresent;

        }
    }

    public static void main(String[] args) {

        BreadthFirstSearch breadthFirstSearchInstance = new BreadthFirstSearch();

        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        root.llink = node4;
        root.rlink = node5;
        node4.llink = node6;
        node4.rlink = node7;
        node5.llink = null;
        node5.rlink = node8;
        node6.llink = node9;

        boolean isElementPresent=breadthFirstSearchInstance.breadthFirstSearch(root, 9);
        System.out.println("The given element is present in tree: "+isElementPresent);
    }
}
