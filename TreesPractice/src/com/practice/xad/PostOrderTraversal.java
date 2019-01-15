package com.practice.xad;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Uday on 2016-05-18.
 */
public class PostOrderTraversal {

    public void postOrderTraversal(BinaryTreeNode root) {

        if(root==null)
            System.out.println("No elements in the tree");

        else {

            Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
            nodeStoreStack.push(root);

            while(!nodeStoreStack.isEmpty()) {

                BinaryTreeNode temp = nodeStoreStack.peek();
                if(temp.llink==null && temp.rlink==null) {
                    temp= nodeStoreStack.pop();
                    System.out.print(temp.data+ " ");
                }

                else {

                    if(temp.rlink!=null) {
                        nodeStoreStack.push(temp.rlink);
                        temp.rlink=null;
                    }

                    if(temp.llink!=null) {
                        nodeStoreStack.push(temp.llink);
                        temp.llink=null;
                    }
                }

            }

        }

    }

    public static void main(String[] args) {

       PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
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
       postOrderTraversal.postOrderTraversal(root);



    }
}
