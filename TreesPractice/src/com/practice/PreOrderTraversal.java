package com.practice;

import java.util.Stack;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by Uday on 2016-04-24.
 */

public class PreOrderTraversal {

    public void preOrderTraversal(BinaryTreeNode root) {

        if(root!=null){
            System.out.print(root.data + " ");
            preOrderTraversal(root.llink);
            preOrderTraversal(root.rlink);
        }
    }


    // See Amazon Package for efficient and simple solution
    public void iterativePreOrderTraversal(BinaryTreeNode root) {

        if(root==null)
            System.out.println("No elements in the binary tree");

        else {
            BinaryTreeNode current=root;
            Stack<BinaryTreeNode> nodeStoreStack = new Stack<BinaryTreeNode>();

            nodeStoreStack.push(current);

            while(!nodeStoreStack.isEmpty()) {

                if(current!=null) {

                    System.out.print(current.data + " ");
                    nodeStoreStack.push(current);
                    current=current.llink;
                }
                else {
                    current=nodeStoreStack.pop();
                    current=current.rlink;
                }
            }

        }

    }

    public static void main(String[] args) {

        PreOrderTraversal preOrderTraversalInstance = new PreOrderTraversal();

        // Create Binary tree method used from in order traversal
        BinaryTreeNode root =InOrderTraversal.createBinaryTree();

        System.out.println("Printing pre order traversal through recursive function: ");
        preOrderTraversalInstance.preOrderTraversal(root);

        System.out.println("\nPrinting pre order traversal through iterative function: ");
        preOrderTraversalInstance.iterativePreOrderTraversal(root);

    }

}
