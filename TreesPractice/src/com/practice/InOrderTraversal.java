package com.practice;

import java.util.Stack;

/**
 * Created by Uday on 2016-04-24.
 */
public class InOrderTraversal {

    public void inOrderTraversal(BinaryTreeNode root) {
        if(root!=null) {

            inOrderTraversal(root.llink);
            System.out.print(root.data + " ");
            inOrderTraversal(root.rlink);
        }

    }


   // See xAD package In Order Traversal code
    public void iterativeInOrderTraversal(BinaryTreeNode root) {

        if(root==null) {
            System.out.println("No elements in the given tree");
        }

        else {
            BinaryTreeNode current=root;
            Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
            while(current!=null || (!nodeStack.isEmpty())) {

                if(current!=null) {
                    nodeStack.push(current);
                    current=current.llink;
                }

                else {
                    current=nodeStack.pop();
                    System.out.print(current.data + " ");
                    current=current.rlink;
                }

            }
        }
    }

    public static BinaryTreeNode createBinaryTree() {
        BinaryTreeNode rootNode = new BinaryTreeNode(60);
        BinaryTreeNode node2 = new BinaryTreeNode(50);
        BinaryTreeNode node3 = new BinaryTreeNode(70);
        BinaryTreeNode node4 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(58);
        BinaryTreeNode node6 = new BinaryTreeNode(80);
        BinaryTreeNode node7 = new BinaryTreeNode(46);
        BinaryTreeNode node8 = new BinaryTreeNode(77);

        rootNode.llink=node2;
        rootNode.rlink=node3;
        node2.llink=node4;
        node2.rlink=node5;
        node3.llink=null;
        node3.rlink=node6;
        node4.llink=null;
        node4.rlink=node7;
        node6.llink=node8;
        node6.rlink=null;

        return rootNode;
    }

    public static void main(String[] args) {

        InOrderTraversal inOrderTraversalInstance = new InOrderTraversal();
        BinaryTreeNode root = InOrderTraversal.createBinaryTree();

        System.out.println("Printing the inorder traversal using recursive function is: ");
        inOrderTraversalInstance.inOrderTraversal(root);

        System.out.println("\nPrinting the inorder traversal using iterative function is: ");
        inOrderTraversalInstance.iterativeInOrderTraversal(root);

    }
}
