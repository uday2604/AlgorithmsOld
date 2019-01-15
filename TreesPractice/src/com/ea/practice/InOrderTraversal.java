package com.ea.practice;

import java.util.Stack;

/**
 * Created by uthota on 7/23/16.
 */
public class InOrderTraversal {

    static class BinaryTreeNode {

        BinaryTreeNode llink;
        BinaryTreeNode rlink;
        int data;

        public BinaryTreeNode(int data) {
            this.llink=null;
            this.rlink=null;
            this.data=data;

        }

    }

    public void inOrderTraversal(BinaryTreeNode rootNode) {

        if(rootNode!=null) {

            inOrderTraversal(rootNode.llink);
            System.out.print(rootNode.data + " ");
            inOrderTraversal(rootNode.rlink);
        }

    }

    public void inorderTraversalNonRecursive(BinaryTreeNode rootNode) {

        if(rootNode==null)
            System.out.println("No elements in the tree");

        else {
            Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
            BinaryTreeNode current=rootNode;
            nodeStoreStack.push(rootNode);

            while(!nodeStoreStack.isEmpty()) {

                if(current!=null) {
                    nodeStoreStack.push(current);
                    current=current.llink;

                }

                else {
                    current=nodeStoreStack.pop();
                    System.out.print(current.data+ " ");
                    current=current.rlink;
                }

            }



        }

    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2= new BinaryTreeNode(2);
        BinaryTreeNode node3= new BinaryTreeNode(3);
        BinaryTreeNode node4= new BinaryTreeNode(4);
        BinaryTreeNode node5= new BinaryTreeNode(5);
        BinaryTreeNode node6= new BinaryTreeNode(6);
        BinaryTreeNode node7= new BinaryTreeNode(7);

        root.llink=node2;
        root.rlink=node3;
        node2.llink=node4;
        node2.rlink=node5;
        node3.llink=node6;
        node3.rlink=node7;

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println("The in order traversal is ");
        inOrderTraversal.inOrderTraversal(root);

        System.out.println("\nPrinting in iterative way: ");
        inOrderTraversal.inorderTraversalNonRecursive(root);


    }



}
