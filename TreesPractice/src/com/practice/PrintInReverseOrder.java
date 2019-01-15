package com.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Uday on 2016-04-26.
 */
public class PrintInReverseOrder {

    public Stack<BinaryTreeNode> printElementsInReverseOrder(BinaryTreeNode root) {
        if(root==null)
            return null;

        Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
        Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();

        nodeStoreQueue.offer(root);

        while(!nodeStoreQueue.isEmpty()) {

            BinaryTreeNode temp = nodeStoreQueue.poll();
            if(temp.llink!=null)
                nodeStoreQueue.offer(temp.llink);
            if(temp.rlink!=null)
                nodeStoreQueue.offer(temp.rlink);

            nodeStoreStack.push(temp);
        }
        return nodeStoreStack;
    }

    public static void main(String[] args) {

        PrintInReverseOrder printInReverseOrderInstance = new PrintInReverseOrder();

        // Create the binary tree and print it
        BinaryTreeNode root = InOrderTraversal.createBinaryTree();
        new LevelOrderTraversal().levelOrderTraversal(root);

        Stack<BinaryTreeNode> outputStack = printInReverseOrderInstance.printElementsInReverseOrder(root);

        // Print the output stack
        System.out.println("\nThe binary tree elements in reverse order are: ");

        while(!outputStack.isEmpty()) {

            BinaryTreeNode nodeValue= outputStack.pop();
            System.out.print(nodeValue.data + " ");
        }

    }
}
