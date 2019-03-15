package com.amazon.secondpractice;

/**
 * Created by udaypersonal on 9/5/16.
 */
public class ValidateBinarySearchTree {


    private boolean validateBST (BinaryTreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(BinaryTreeNode root, int min, int max) {

        if(root==null)
            return true;

        if(root.data<min || root.data>max)
                return false;

        return isValidBSTHelper(root.llink, min,root.data) && isValidBSTHelper(root.rlink, root.data, max);
    }



    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(7);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(9);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(10);

        root.llink = node1;
        root.rlink = node2;

        node1.llink = node3;
        node1.rlink = node4;

        node2.llink = node5;
        node2.rlink=node6;

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean isTreeValidBST = validateBinarySearchTree.validateBST(root);
        System.out.println("The tree is valid BST: "+isTreeValidBST);
    }
}
