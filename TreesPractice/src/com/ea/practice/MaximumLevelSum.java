package com.ea.practice;

import com.practice.xad.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;

/**
 * Created by uthota on 7/24/16.
 */
public class MaximumLevelSum {

    public int maximumLevelSum (BinaryTreeNode rootNode) {


        if(rootNode==null)
            return 0;

        else {
            int levelSum=0, maxLevelSum=Integer.MIN_VALUE;

            Queue<BinaryTreeNode> nodeStoreQueue=new LinkedList<>();
            nodeStoreQueue.offer(rootNode);
            nodeStoreQueue.offer(null);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();

                if(temp!=null) {

                    if (temp.llink != null)
                        nodeStoreQueue.offer(temp.llink);

                    if (temp.rlink != null)
                        nodeStoreQueue.offer(temp.rlink);

                    levelSum += temp.data;

                }


                else {

                    if(levelSum>maxLevelSum)
                        maxLevelSum=levelSum;

                    if(!nodeStoreQueue.isEmpty())
                        nodeStoreQueue.offer(null);

                    levelSum=0;

                }


            }
            return maxLevelSum;

        }

    }


    public int totalNodeSumInTree (BinaryTreeNode rootNode) {

        if(rootNode==null)
            return 0;

        else {
            int levelSum=0, maxLevelSum=Integer.MIN_VALUE;

            Queue<BinaryTreeNode> nodeStoreQueue=new LinkedList<>();
            nodeStoreQueue.offer(rootNode);
            nodeStoreQueue.offer(null);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();

                if(temp!=null) {

                    if (temp.llink != null)
                        nodeStoreQueue.offer(temp.llink);

                    if (temp.rlink != null)
                        nodeStoreQueue.offer(temp.rlink);

                    levelSum += temp.data;

                }


                else {

                    if(!nodeStoreQueue.isEmpty())
                        nodeStoreQueue.offer(null);

                }


            }
            return levelSum;

        }

    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);

        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        root.llink=node1;
        root.rlink=node2;
        node1.llink=node3;
        node1.rlink=node4;
        node2.llink=node5;
        node2.rlink=node6;

        MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
        int maxSum=maximumLevelSum.maximumLevelSum(root);
        System.out.println("The maximum level sum is "+maxSum);

        int totalLevelSum= maximumLevelSum.totalNodeSumInTree(root);
        System.out.println("The total node sum in the tree is "+totalLevelSum);
    }


}
