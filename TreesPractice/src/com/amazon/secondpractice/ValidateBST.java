package com.amazon.secondpractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by udaypersonal on 9/8/16.
 */
public class ValidateBST {

    static class Wrapper {

        int left;
        int right;
        BinaryTreeNode node;

        Wrapper(BinaryTreeNode node, int left, int right) {

            this.node=node;
            this.left=left;
            this.right=right;

        }


    }

    // Iterative Method (Used Level Order Traversal)
    public static boolean isValidBSTIterative (BinaryTreeNode root) {

            if(root==null)
                return true;

            else {

                Queue<Wrapper> nodeStoreQueue = new LinkedList<>();

                nodeStoreQueue.offer(new Wrapper(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

                while(!nodeStoreQueue.isEmpty()) {

                    Wrapper temp = nodeStoreQueue.poll();

                    if(temp.node.data<temp.left || temp.node.data>temp.right)
                        return false;

                    if(temp.node.llink!=null)
                        nodeStoreQueue.offer(new Wrapper(temp.node.llink, temp.left, temp.node.data));

                    if(temp.node.rlink!=null)
                        nodeStoreQueue.offer(new Wrapper(temp.node.rlink, temp.node.data, temp.right ));


                }

                return true;

            }

    }


    // Recursive Approach
    public static boolean isGivenTreeValidBST(BinaryTreeNode root) {

        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);


    }

    public static boolean isValidBSTHelper (BinaryTreeNode root, int min, int max) {

        if(root==null)
            return true;

        if(root.data<min || root.data>max)
            return false;

        return isValidBSTHelper(root.llink, min, root.data) && isValidBSTHelper(root.rlink, root.data, max);

    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(7);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(9);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(10);
        BinaryTreeNode node7 = new BinaryTreeNode(5);

        root.llink = node1;
        root.rlink = node2;

        node1.llink = node3;
        node1.rlink = node4;

        node2.llink = node5;
        node2.rlink=node6;

        node4.llink=node7;


        boolean isValid =isGivenTreeValidBST(root);
        System.out.println("Valid BST or not: "+isValid);

        boolean isValidIterative = isValidBSTIterative(root);
        System.out.println("Valid BST or not iterative: "+isValidIterative);



    }


}
