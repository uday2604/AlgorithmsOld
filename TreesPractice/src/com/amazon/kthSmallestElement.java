package com.amazon;

import java.util.Stack;

/**
 * Created by uthota on 8/25/16.
 */
public class kthSmallestElement {

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


    // In-Order Traversal : kth smallest element is the corresponding element in the in-order traversal
    public int findKthSmallestElement(BinaryTreeNode root, int kthSmallest) {

        if (root == null)
            return -1;


        else {
            int result = 0;
            Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
            BinaryTreeNode current = root;
            nodeStoreStack.push(current);

            while (!nodeStoreStack.isEmpty()) {

                if (current != null) {
                    nodeStoreStack.push(current);
                    current = current.llink;
                } else {

                    BinaryTreeNode temp = nodeStoreStack.pop();
                    kthSmallest--;
                    if (kthSmallest == 0)
                        result = temp.data;

                    current = temp.rlink;


                }

            }
            return result;


        }


    }


    public static void main(String[] args) {


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

        node2.llink = node5;
        node2.rlink = node6;

        kthSmallestElement kthSmallestElement = new kthSmallestElement();
        int output = kthSmallestElement.findKthSmallestElement(root, 3);
        System.out.println("The kth smallest element is " + output);

    }


}
