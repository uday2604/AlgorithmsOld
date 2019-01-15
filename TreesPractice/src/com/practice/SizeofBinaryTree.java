package com.practice;

/**
 * Created by Uday on 2016-04-26.
 */
public class SizeofBinaryTree {

    public int sizeOfBinaryTree(BinaryTreeNode root) {

        /*int leftTreeCount=root.llink==null ? 0:sizeOfBinaryTree(root.llink);
        int rightTreeCount=root.rlink==null ? 0:sizeOfBinaryTree(root.rlink);

        return leftTreeCount+rightTreeCount+1;*/

        if(root==null)
            return 0;

        else
            return 1+sizeOfBinaryTree(root.llink)+sizeOfBinaryTree(root.rlink);

    }

    public static void main(String[] args) {

        BinaryTreeNode root = InOrderTraversal.createBinaryTree();
        SizeofBinaryTree sizeofBinaryTree = new SizeofBinaryTree();
        int size=sizeofBinaryTree.sizeOfBinaryTree(root);
        System.out.println("The size of the tree is "+ size);
    }
}
