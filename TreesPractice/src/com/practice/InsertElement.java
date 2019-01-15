package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-04-26.
 */
public class InsertElement {

    public BinaryTreeNode insertElementInBinaryTree(BinaryTreeNode root, int insertionElement) {

        if(root==null)
            return null;

        Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
        nodeStoreQueue.offer(root);

        while(!nodeStoreQueue.isEmpty()) {

            BinaryTreeNode temp= nodeStoreQueue.poll();
            if(temp!=null) {
                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);
                else {
                    temp.llink=new BinaryTreeNode(insertionElement);
                    return root;
                }

                if(temp.rlink!=null) {
                    nodeStoreQueue.offer(temp.rlink);
                }
                else {
                    temp.rlink=new BinaryTreeNode(insertionElement);
                    return root;
                }

            }

        }
        return root;

    }


    public static void main(String[] args) {

        BinaryTreeNode root = InOrderTraversal.createBinaryTree();
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println("Printing before inserting element");
        levelOrderTraversal.levelOrderTraversal(root);

        InsertElement insertElement = new InsertElement();
        BinaryTreeNode newRoot=insertElement.insertElementInBinaryTree(root, 8);
        System.out.println("Printing after inserting the element");
        levelOrderTraversal.levelOrderTraversal(newRoot);

    }
}
