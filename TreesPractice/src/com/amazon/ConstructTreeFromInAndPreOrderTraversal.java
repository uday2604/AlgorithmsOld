package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by uthota on 8/27/16.
 */
public class ConstructTreeFromInAndPreOrderTraversal {

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


    public BinaryTreeNode constructTreeFromInOrderAndPreOrder(int[] inOrder, int[] preOrder) {

        int inStartIndex = 0;
        int preStartIndex=0;
        int inEndIndex=inOrder.length-1;
        int preEndIndex = preOrder.length-1;

        return constructTreeHelper(inOrder, inStartIndex, inEndIndex, preOrder, preStartIndex, preEndIndex);

    }

    public BinaryTreeNode constructTreeHelper(int[] inOrder, int inOrderStart, int inOrderEnd, int[] preOrder, int preOrderStart, int preOrderEnd) {


        if(inOrderStart>inOrderEnd || preOrderStart>preOrderEnd)
            return null;

        int rootElementValue = preOrder[preOrderStart];
        BinaryTreeNode root = new BinaryTreeNode(rootElementValue);

        int k=0;
        for(int i=0; i<inOrder.length;i++) {

            if (inOrder[i] == rootElementValue) {
                k = i;
                break;
            }
        }

        root.llink=constructTreeHelper(inOrder, inOrderStart, k-1, preOrder, preOrderStart+1, preOrderStart+(k-inOrderStart));
        root.rlink=constructTreeHelper(inOrder, k+1, inOrderEnd, preOrder, preOrderStart+(k-inOrderStart)+1, preOrderEnd);
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

        ConstructTreeFromInAndPreOrderTraversal constructTreeFromInAndPreOrderTraversal = new ConstructTreeFromInAndPreOrderTraversal();

        int[] inOrderElements = {7, 11, 2, 4, 5, 13, 8, 6, 1};
        int[] preOrderElements = {5, 4, 11, 7, 2, 8, 13, 6, 1};

        BinaryTreeNode newTreeRoot = constructTreeFromInAndPreOrderTraversal.constructTreeFromInOrderAndPreOrder(inOrderElements, preOrderElements);
        levelOrderTraversal(newTreeRoot);
    }
}
