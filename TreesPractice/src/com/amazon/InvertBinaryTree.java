package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by udaypersonal on 9/5/16.
 * Invert Binary Tree: Recursive and Iterative approaches
 */
public class InvertBinaryTree {

    // Recursive approach
    private BinaryTreeNode invertBinaryTree(BinaryTreeNode root) {
        if (root != null)
            invertTreeHelper(root);
        return root;
    }

    // Recursive approach : helper
    private void invertTreeHelper(BinaryTreeNode root) {
        BinaryTreeNode temp = root.rlink;
        root.rlink = root.llink;
        root.llink = temp;
        if (root.llink != null) {
            invertTreeHelper(root.llink);
        }
        if (root.rlink != null)
            invertTreeHelper(root.rlink);
    }

    // Iterative approach
    private BinaryTreeNode invertBinaryTreeIterative(BinaryTreeNode root) {
        if (root == null) return null;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // swap the nodes
            BinaryTreeNode current = queue.poll();
            BinaryTreeNode temp = current.llink;
            current.llink = current.rlink;
            current.rlink = temp;
            // add the children (when they exist) to the queue
            if (current.llink != null) {
                queue.offer(current.llink);
            }
            if (current.rlink != null) {
                queue.offer(current.rlink);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        // BinaryTreeNode node7 = new BinaryTreeNode(10);
        root.llink = node1;
        root.rlink = node2;
        node1.llink = node3;
        node1.rlink = node4;
        node2.llink = node5;
        node2.rlink = node6;
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        // invert the tree for the first time
        BinaryTreeNode headAfterInverting = invertBinaryTree.invertBinaryTree(root);
        System.out.println("Printing through recursive approach:");
        LevelOrderTraversal.printLevelOrderTraversal(headAfterInverting);
        System.out.println("\n");

        // this should give us back the original tree as we are inverting an already inverted tree
        BinaryTreeNode headAfterInvertingIterative = invertBinaryTree.invertBinaryTreeIterative(root);
        System.out.println("Printing through iterative approach:");
        LevelOrderTraversal.printLevelOrderTraversal(headAfterInvertingIterative);
    }
}
