package com.practice;

import java.util.Stack;

/**
 * Created by Uday on 2016-04-24.
 */
public class PostOrderTraversal {

    public void postOrderTraversal(BinaryTreeNode root) {

        if(root!=null) {
            postOrderTraversal(root.llink);
            postOrderTraversal(root.rlink);
            System.out.print(root.data + " ");
        }

    }

    public void iterativePostOrderTraversal(BinaryTreeNode root) {

        if(root==null)
            System.out.println("No elements in the tree");

        else {
            int value=0;
            BinaryTreeNode current =root;
            Stack nodeStoreStack = new Stack();

            nodeStoreStack.push(current);
            nodeStoreStack.push(1);

            while (!nodeStoreStack.isEmpty()) {

                if(current!=null && value==0) {


                }
                else {


                }

            }

        }

    }

    public static void main(String[] args) {

        PostOrderTraversal postOrderTraversalInstance = new PostOrderTraversal();
        BinaryTreeNode root =InOrderTraversal.createBinaryTree();

        postOrderTraversalInstance.postOrderTraversal(root);
    }

}
