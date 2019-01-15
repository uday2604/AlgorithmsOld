package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-04-29.
 */
public class MaximumLevelSum
{
    public int maximumSumLevel(BinaryTreeNode root) {

        int currentSum=0, maximumSum=0;
        if(root==null)
            return 0;

        else {
            Queue<BinaryTreeNode> nodeStoreQueue= new LinkedList<>();
            nodeStoreQueue.offer(root);
            nodeStoreQueue.offer(null);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();

                if(temp!=null) {
                    if(temp.llink!=null) {
                        nodeStoreQueue.offer(temp.llink);
                    }

                    if(temp.rlink!=null) {
                        nodeStoreQueue.offer(temp.rlink);
                    }

                    currentSum+=temp.data;
                    }

                else {

                    if (currentSum > maximumSum)
                        maximumSum = currentSum;

                    currentSum=0;

                    if(!nodeStoreQueue.isEmpty()) {
                        nodeStoreQueue.offer(null);
                    }

                }

            }

        }
        return maximumSum;
    }


    public static void main(String[] args) {

        BinaryTreeNode root=InOrderTraversal.createBinaryTree();
        new InOrderTraversal().inOrderTraversal(root);

        MaximumLevelSum maximumLevelSumInstance = new MaximumLevelSum();
        int maximumSum=maximumLevelSumInstance.maximumSumLevel(root);
        System.out.println("The maximum level sum in the binary tree is "+maximumSum);


    }

}
