package com.practice.xad;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-18.
 */
public class InOrderTraversal {

    public void inOrderTraversal(BinaryTreeNode root) {

        if(root!=null) {

            inOrderTraversal(root.llink);
            System.out.print(root.data+ " ");
            inOrderTraversal(root.rlink);
        }

    }

    public void inOrderTraversalNonRecursive(BinaryTreeNode root) {

        if(root==null)
            System.out.println("No elements in binary tree");

        else {

            BinaryTreeNode current = root;
            Stack<BinaryTreeNode> nodeStoreStack = new Stack<BinaryTreeNode>();

            while(!nodeStoreStack.isEmpty() || current!=null) {

                if(current!=null) {
                    nodeStoreStack.push(current);
                    current=current.llink;
                }

                else {

                   current = nodeStoreStack.pop();
                    System.out.print(current.data+ " ");
                    current=current.rlink;
                }

            }

        }
    }

    public static void main(String[] args) {

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        BinaryTreeNode root = new BinaryTreeNode(1);

        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        root.llink=node2;
        root.rlink=node3;
        node2.llink=node4;
        node2.rlink=node5;

        node3.llink=node6;
        node3.rlink=node7;

        node4.llink=node8;
        node4.rlink=node9;

        node5.llink=node10;
        node5.rlink=node11;

       inOrderTraversal.inOrderTraversal(root);
       System.out.println();
        inOrderTraversal.inOrderTraversalNonRecursive(root);

    }
}
