package com.practice.xad;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-05-18.
 */
public class MaximumSumLevel {

    public int maxLevelSum(BinaryTreeNode root) {

        if(root==null)
            return -1;

        else {

            int levelSum=0;
            int maxLevelSum=Integer.MIN_VALUE;

            Queue<BinaryTreeNode> nodeStoreQueue= new LinkedList<>();
            nodeStoreQueue.offer(root);
            nodeStoreQueue.offer(null);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp=nodeStoreQueue.poll();
                if(temp!=null) {

                    if(temp.llink!=null)
                        nodeStoreQueue.offer(temp.llink);

                    if(temp.rlink!=null)
                        nodeStoreQueue.offer(temp.rlink);

                    levelSum+=temp.data;

                }

                else {

                    if(levelSum>maxLevelSum)
                        maxLevelSum=levelSum;

                    levelSum=0;

                    if(!nodeStoreQueue.isEmpty())
                    nodeStoreQueue.offer(null);

                }

            }

            return maxLevelSum;
        }
    }


    public static void main(String[] args) {

        MaximumSumLevel maximumSumLevelInstance = new MaximumSumLevel();
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

        int maxLevelSum = maximumSumLevelInstance.maxLevelSum(root);
        System.out.println("The maximum level sum in tree "+maxLevelSum);

    }
}
