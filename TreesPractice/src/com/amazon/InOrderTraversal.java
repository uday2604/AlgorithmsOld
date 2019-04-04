package com.amazon;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by uthota on 8/22/16.
 * Inorder traversal: Recursive and Iterative
 */
public class InOrderTraversal {

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


    private void inOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.llink);
            System.out.print(root.data + " ");
            inOrderTraversal(root.rlink);
        }
    }

    private ArrayList<Integer> inOrderTraversalIterative(BinaryTreeNode root) {
        if (root == null)
            return null;
        else {
            ArrayList<Integer> outputArrayList = new ArrayList<>();
            Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
            BinaryTreeNode current = root;
            while (!nodeStoreStack.isEmpty() || current != null) {
                if (current != null) {
                    nodeStoreStack.push(current);
                    current = current.llink;
                } else {
                    current = nodeStoreStack.pop();
                    outputArrayList.add(current.data);
                    current = current.rlink;
                }
            }
            return outputArrayList;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        root.llink = node1;
        root.rlink = node2;
        node1.llink = node3;
        node1.rlink = node4;
        node2.llink = node5;
        node2.rlink = node6;
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrderTraversal(root);
        ArrayList<Integer> outputList = inOrderTraversal.inOrderTraversalIterative(root);
        System.out.println("\n" + outputList);
    }
}
