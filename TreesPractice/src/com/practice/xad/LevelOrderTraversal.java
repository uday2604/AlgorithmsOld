package com.practice.xad;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Uday on 2016-05-18.
 */
public class LevelOrderTraversal {

    public void LevelOrderTraversal(BinaryTreeNode head) {

        if(head==null)
            System.out.println("No elements in the binary tree");

        else {

            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(head);

            while(!nodeStoreQueue.isEmpty()) {

                BinaryTreeNode temp = nodeStoreQueue.poll();
                System.out.print(temp.data+ " ");

                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);

                if(temp.rlink!=null)
                    nodeStoreQueue.offer(temp.rlink);
            }


        }

    }


    public static void main(String[] args) {

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        BinaryTreeNode root = new BinaryTreeNode(1);

        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.llink=node2;
        root.rlink=node3;
        node2.llink=node4;
        node2.rlink=node5;

        node3.llink=node6;
        node3.rlink=node7;

        levelOrderTraversal.LevelOrderTraversal(root);

    }


}
