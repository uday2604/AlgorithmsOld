package com.practice;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-09.
 */
public class DepthFirstSearch {

    // Similar to pre order traversal of the tree
    // The main idea of DFS is to go deep; visiting children before siblings for any given node
    public boolean depthFirstSearch(BinaryTreeNode root, int searchElement) {

        if(root==null)
            return false;

        Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
        nodeStoreStack.push(root);
        boolean isElementPresent=false;

        while(!nodeStoreStack.isEmpty()) {

            BinaryTreeNode temp=nodeStoreStack.pop();
            if(temp.data==searchElement)
                isElementPresent=true;

            if(temp.llink!=null)
                nodeStoreStack.push(temp.llink);

            if(temp.rlink!=null)
                nodeStoreStack.push(temp.rlink);
        }

        return isElementPresent;
    }


    public static void main(String[] args) {

        DepthFirstSearch depthFirstSearchInstance = new DepthFirstSearch();

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

        boolean isElementPresent=depthFirstSearchInstance.depthFirstSearch(root, 19);
        System.out.println("The given element is present in tree: "+isElementPresent);
    }
}
