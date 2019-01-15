package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by uthota on 8/27/16.
 */
public class ConstructTreeFromInOrderFullBinaryTree {

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

    // If the binary tree is perfect binary tree (all nodes except leaf nodes have left and right links and height of left and right links are same)
   // Then only Inorder traversal is required to construct the tree as middle element of the given array would be the root and
    // left elements to the root goes to llink and right elements to root goes to rlink

    // For constructing BST, only inorder traversal is needed as in BST middle node is always the root and left and right links are corresponding nodes to root

    public static BinaryTreeNode constructBinaryTree(int[] inOrderArray) {

        if(inOrderArray==null)
            return null;

        return  constructTreeFromInOrderHelper(inOrderArray, 0, inOrderArray.length-1);

    }

    public static BinaryTreeNode constructTreeFromInOrderHelper(int[] inOrderArray, int inOrderStartIndex, int inOrderLastIndex) {


        if(inOrderStartIndex>inOrderLastIndex)
            return null;

        int inOrderMidIndex= (inOrderStartIndex+inOrderLastIndex)/2;
        int rootElementValue=inOrderArray[inOrderMidIndex];
        BinaryTreeNode root= new BinaryTreeNode(rootElementValue);

        root.llink=constructTreeFromInOrderHelper(inOrderArray, inOrderStartIndex, inOrderMidIndex-1);
        root.rlink=constructTreeFromInOrderHelper(inOrderArray, inOrderMidIndex+1, inOrderLastIndex);

        return root;

    }

    public static void levelOrderTraversal(BinaryTreeNode root) {

        if(root==null)
            System.out.println("No elements in the tree");

        else {

            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();
                System.out.print(temp.data+" ");

                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);

                if(temp.rlink!=null)
                    nodeStoreQueue.offer(temp.rlink);

            }

        }


    }


    public static void main(String[] args) {

        ConstructBinaryTreeFromInAndPostOrder constructBinaryTreeFromInAndPostOrder = new ConstructBinaryTreeFromInAndPostOrder();

        int[] inOrderArray = {6, 8, 4, 3, 1 , 2, 9};

        BinaryTreeNode newRoot = ConstructTreeFromInOrderFullBinaryTree.constructBinaryTree(inOrderArray);
        ConstructTreeFromInOrderFullBinaryTree.levelOrderTraversal(newRoot);


    }



}
