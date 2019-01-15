package com.amazon;

/**
 * Created by uthota on 8/25/16.
 */
public class ValidateBinarySearchTree {

    static class BinaryTreeNode {

        BinaryTreeNode llink;
        BinaryTreeNode rlink;
        int data;

        BinaryTreeNode(int data) {

            this.data=data;
            this.llink=null;
            this.rlink=null;
        }

    }

    public boolean validateBinarySearchTree(BinaryTreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public boolean isValidBST(BinaryTreeNode root, int min, int max) {


        if(root==null)
            return true;

        if(root.data<=min || root.data>=max)
            return false;

        return isValidBST(root.llink, min, root.data) && isValidBST(root.rlink, root.data, max);

    }


    // Doing and inorder traversal. Storing the previous node info and comparing with the current node info. If previous info > current info return false
    public boolean isValidBSTMethod2(BinaryTreeNode root) {

        BinaryTreeNode previous = null;


        if(root!=null) {

            if(!isValidBSTMethod2(root.llink))
                return false;

            if(previous !=null && previous.data>=root.data)
                return false;

            previous=root;

             return isValidBSTMethod2(root.rlink);

        }

        return true;

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
        boolean isGivenTreeBST=validateBinarySearchTree.validateBinarySearchTree(root);
        System.out.println("The given tree is valid BST or not : "+isGivenTreeBST);

        boolean isGivenTreeBSTMethod2 = validateBinarySearchTree.isValidBSTMethod2(root);
        System.out.println("BST or not Method 2: "+isGivenTreeBSTMethod2);

    }


}
