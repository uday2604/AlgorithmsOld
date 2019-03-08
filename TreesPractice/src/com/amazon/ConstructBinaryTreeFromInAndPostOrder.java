package com.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by uthota on 8/27/16.
 */
public class ConstructBinaryTreeFromInAndPostOrder {

    static class BinaryTreeNode {

        BinaryTreeNode llink;
        BinaryTreeNode rlink;
        int data;

        BinaryTreeNode(int data) {

            this.data = data;
            this.llink = null;
            this.rlink = null;
        }

    }


    public BinaryTreeNode constructTreeFromInOrderAndPostOrder(int[] inOrder, int[] postOrder) {


        return constructTreeHelper(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);

    }

    public BinaryTreeNode constructTreeHelper(int[] inOrder, int[] postOrder, int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {


        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd)
            return null;

        int rootElementValue = postOrder[postOrderEnd];
        BinaryTreeNode root = new BinaryTreeNode(rootElementValue);

        int rootPositionFromInOrder = 0;
        for (int i = 0; i < inOrder.length; i++) {

            if (inOrder[i] == rootElementValue) {
                rootPositionFromInOrder = i;
                break;
            }
        }

        root.llink = constructTreeHelper(inOrder, postOrder, inOrderStart, rootPositionFromInOrder - 1, postOrderStart, postOrderStart + rootPositionFromInOrder - (inOrderStart + 1));//postOrderStart+rootPositionFromInOrder-(inOrderStart+1)
        root.rlink = constructTreeHelper(inOrder, postOrder, rootPositionFromInOrder + 1, inOrderEnd, postOrderStart + rootPositionFromInOrder - inOrderStart, postOrderEnd - 1);

        return root;

    }


    public static void levelOrderTraversal(BinaryTreeNode root) {

        if (root == null)
            System.out.println("No elements in the tree");

        else {

            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);

            while (!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();
                System.out.print(temp.data + " ");

                if (temp.llink != null)
                    nodeStoreQueue.offer(temp.llink);

                if (temp.rlink != null)
                    nodeStoreQueue.offer(temp.rlink);

            }

        }


    }


    public static void main(String[] args) {

        ConstructBinaryTreeFromInAndPostOrder constructBinaryTreeFromInAndPostOrder = new ConstructBinaryTreeFromInAndPostOrder();

        int[] inOrderElements = {7, 11, 2, 4, 5, 13, 8, 6, 1};
        int[] postOrderElements = {7, 2, 11, 4, 13, 1, 6, 8, 5};

        BinaryTreeNode newTreeRoot = constructBinaryTreeFromInAndPostOrder.constructTreeFromInOrderAndPostOrder(inOrderElements, postOrderElements);
        //  BinaryTreeNode newTreeRoot = constructBinaryTreeFromInAndPostOrder.buildTree(inOrderElements, postOrderElements);

        levelOrderTraversal(newTreeRoot);


    }


}
