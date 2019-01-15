package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-04-26.
 */
public class SearchAnElement {

    // Recursive Approach to search al element in the binary tree
    public boolean isElementInBinaryTree(BinaryTreeNode root, int number) {

        if(root==null)
            return false;

        if(root.data==number)
            return true;

        return isElementInBinaryTree(root.llink, number) || isElementInBinaryTree(root.rlink, number);
    }


    // Iterative approach to the same problem
    public boolean isElementInBinaryTreeIterative(BinaryTreeNode root, int number) {

        if(root==null)
            return false;

        Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
        nodeStoreQueue.offer(root);

        while(!nodeStoreQueue.isEmpty()) {

            BinaryTreeNode temp = nodeStoreQueue.poll();
            if(temp.data==number)
                return true;

            if(temp!=null) {

                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);

                if(temp.rlink!=null)
                    nodeStoreQueue.offer(temp.rlink);
            }
        }
            return false;
    }

    public static void main (String[] args) {

        SearchAnElement searchAnElementInstance = new SearchAnElement();
        InOrderTraversal inOrderTraversalInstance = new InOrderTraversal();
        BinaryTreeNode root=inOrderTraversalInstance.createBinaryTree();

        boolean isElementPresent=searchAnElementInstance.isElementInBinaryTree(root, 70);
        boolean isElementPresentIterative=searchAnElementInstance.isElementInBinaryTreeIterative(root, 70);

        System.out.println(isElementPresent);
        System.out.println(isElementPresentIterative);


    }
}
