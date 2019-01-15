package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-04-26.
 */
public class HeightOfBinaryTree {

    public int heightOfBinaryTree(BinaryTreeNode root) {

        // Height of the binary tree with a root node null is not defined and with single root node is 0
        // Height of binary tree is max number of EDGES from root to farthest leaf node
        // Depth of binary tree is max number of NODES from root to farthest leaf node
        if(root==null)
            return -1;

        int leftMax = heightOfBinaryTree(root.llink);
        int rightMax = heightOfBinaryTree(root.rlink);

        return leftMax>rightMax ? leftMax+1 : rightMax+1;


    }

    public int heightOfBinaryTreeIterative(BinaryTreeNode root) {

        int height=-1;

        if(root==null)
            return height;

        Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
        nodeStoreQueue.offer(root);
        int currentLevelNodeCount=1;
        int nextLevelNodeCount=0;


        while(!nodeStoreQueue.isEmpty()) {

            BinaryTreeNode temp = nodeStoreQueue.poll();
            currentLevelNodeCount--;

            if(temp.llink!=null) {
                nodeStoreQueue.offer(temp.llink);
                nextLevelNodeCount++;
            }

            if(temp.rlink!=null) {
                nodeStoreQueue.offer(temp.rlink);
                nextLevelNodeCount++;
            }

            if(currentLevelNodeCount==0) {
                height++;
                currentLevelNodeCount=nextLevelNodeCount;
                nextLevelNodeCount=0;
            }

        }
        return height;

    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        root.llink=node4;
        root.rlink=node5;
        node4.llink=node6;
        node4.rlink=node7;
        node5.llink=null;
        node5.rlink=node8;
        node6.llink=node9;

        HeightOfBinaryTree heightOfBinaryTreeInstance = new HeightOfBinaryTree();

        int height=heightOfBinaryTreeInstance.heightOfBinaryTree(root);
        System.out.println("The height of binary tree is "+ height);

        int heightOfBinaryTree=heightOfBinaryTreeInstance.heightOfBinaryTreeIterative(root);
        System.out.println("The height of binary tree through iterative approach is is "+heightOfBinaryTree);
    }
}
