package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by uthota on 8/26/16.
 */
public class PathSumInBinaryTree {

    static class BinaryTreeNode {

        BinaryTreeNode llink;
        BinaryTreeNode rlink;
        int data;

        BinaryTreeNode(int data) {

            this.data=data;
            this.llink=null;
            this.rlink=null;
        }

    }

    public boolean sumPathExistsFromRootToLeaf(BinaryTreeNode root, int sumValue) {


        if(root==null)
            return false;

        else {

            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            Queue<Integer>nodeValueStore= new LinkedList<>();

            nodeStoreQueue.offer(root);
            nodeValueStore.offer(root.data);

            while (!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();
                Integer sumTillThatNode=nodeValueStore.poll();


                // Return true if the node is leaf node and the sum value of the node (leaf) is target value
                if(temp.llink==null && temp.rlink==null && sumTillThatNode==sumValue)
                    return true;

                if(temp.llink!=null) {
                    nodeStoreQueue.offer(temp.llink);
                    nodeValueStore.offer(temp.llink.data+sumTillThatNode);

                }

                if(temp.rlink!=null) {

                    nodeStoreQueue.offer(temp.rlink);
                    nodeValueStore.offer(temp.rlink.data+sumTillThatNode);

                }

            }

            return false;

        }


    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(11);
        BinaryTreeNode node7 = new BinaryTreeNode(13);
        BinaryTreeNode node8 = new BinaryTreeNode(4);
        BinaryTreeNode node9 = new BinaryTreeNode(7);
        BinaryTreeNode node10 = new BinaryTreeNode(2);
        BinaryTreeNode node11 = new BinaryTreeNode(1);

        root.llink = node4;
        root.rlink = node5;

        node4.llink = node6;
        node4.rlink=null;

        node5.llink=node7;
        node5.rlink=node8;

        node6.llink=node9;
        node6.rlink=node10;

        node8.llink=null;
        node8.rlink=node11;

        PathSumInBinaryTree pathSumInBinaryTree = new PathSumInBinaryTree();
        boolean doesPathExist=pathSumInBinaryTree.sumPathExistsFromRootToLeaf(root, 22);
        System.out.println("The given sum path from root to leaf exists in the tree: "+doesPathExist);

    }
}
