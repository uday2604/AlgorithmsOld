package com.practice;

/**
 * Created by Uday on 2016-04-25.
 */
public class MaxElementInBinaryTree {

    public int findMaxElementInBinaryTree(BinaryTreeNode root) {

        int maxValueInTree= Integer.MIN_VALUE;

        if(root!=null) {
            int leftMax=findMaxElementInBinaryTree(root.llink);
            int rightMax=findMaxElementInBinaryTree(root.rlink);

            if(leftMax>rightMax)
                maxValueInTree=leftMax;
            else
                maxValueInTree=rightMax;

            if(root.data>maxValueInTree)
                maxValueInTree=root.data;

        }

        return maxValueInTree;

    }

    public static void main(String[] args) {

        MaxElementInBinaryTree maxElementInBinaryTreeInstance = new MaxElementInBinaryTree();
        BinaryTreeNode root=InOrderTraversal.createBinaryTree();

        int maxValue= maxElementInBinaryTreeInstance.findMaxElementInBinaryTree(root);
        System.out.println(maxValue);
    }
}
