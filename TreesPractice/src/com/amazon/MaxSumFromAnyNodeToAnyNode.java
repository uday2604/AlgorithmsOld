package com.amazon;

/**
 * Created by udaypersonal on 9/12/16.
 */
public class MaxSumFromAnyNodeToAnyNode {


   /* public static int maximumSumInBinaryTree(BinaryTreeNode root) {

        int max = Integer.MIN_VALUE;
        return maxSumHelper(root, max);


    }

    public static int maxSumHelper (BinaryTreeNode root, int max) {


        if(root==null)
            return 0;

       int leftMax= maxSumHelper(root.llink, max);
       int rightMax= maxSumHelper(root.rlink, max);

        int current=Math.max(root.data, Math.max(root.data+leftMax, root.data+rightMax));
        max= Math.max(max, root.data+leftMax+rightMax);

        return current;

    }*/

    public static int maxPathSum(BinaryTreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public static int calculateSum(BinaryTreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.llink, max);
        int right = calculateSum(root.rlink, max);

        int current = Math.max(root.data, Math.max(root.data + left, root.data + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.data + right));

        return current;
    }


    public static void main(String[] args) {

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
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

        node2.llink=node5;
        node2.rlink=node6;

        int maxSum=MaxSumFromAnyNodeToAnyNode.maxPathSum(root);
        System.out.println(maxSum);




    }
}
