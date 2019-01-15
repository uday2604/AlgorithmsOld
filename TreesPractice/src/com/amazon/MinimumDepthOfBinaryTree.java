package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by uthota on 8/27/16.
 */
public class MinimumDepthOfBinaryTree {

    public int minimumDepthOfBinaryTree(BinaryTreeNode root) {

        if(root==null)
            return 0;


        Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();

        // This queue always store 2 values (except for the root nodes), first value for count of left tree nodes and other for count of right tree nodes
        Queue<Integer> nodeValueCount = new LinkedList<>();

        nodeStoreQueue.offer(root);
        nodeValueCount.offer(1);

        while(!nodeStoreQueue.isEmpty()) {

            BinaryTreeNode temp = nodeStoreQueue.poll();
            Integer count = nodeValueCount.poll();

            if(temp.llink==null || temp.rlink==null)
                return count;

            if(temp.llink!=null) {
                nodeStoreQueue.offer(temp.llink);
                nodeValueCount.offer(count+1);
            }

            if(temp.rlink!=null) {
                nodeStoreQueue.offer(temp.rlink);
                nodeValueCount.offer(count+1);
            }


        }


        return nodeValueCount.poll();


    }

    public  static  void main(String[] args) {

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(7);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(9);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(10);

        root.llink = node1;
        root.rlink = node2;

        node1.llink = node3;
        node1.rlink = node4;

        node2.llink=node5;
        node2.rlink=node6;


        int minimumDepth = minimumDepthOfBinaryTree.minimumDepthOfBinaryTree(root);
        System.out.println("The minimum depth of the tree is "+minimumDepth);


    }




}
