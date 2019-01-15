package com.practice;

import javax.xml.bind.SchemaOutputResolver;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-04-26.
 */
public class LevelOrderTraversal {

    public void levelOrderTraversal(BinaryTreeNode root) {

        if(root!=null) {

            Queue<BinaryTreeNode> nodeStorageQueue = new LinkedList<BinaryTreeNode>();
            nodeStorageQueue.add(root);

            while(!nodeStorageQueue.isEmpty()) {

                BinaryTreeNode tempNode = nodeStorageQueue.poll();
                System.out.print(tempNode.data+ " ");

                if(tempNode.llink!=null) {
                    nodeStorageQueue.add(tempNode.llink);
                }

                if(tempNode.rlink!=null) {
                    nodeStorageQueue.add(tempNode.rlink);
                }

            }


        }


    }

    public static void main(String[] args) {

        LevelOrderTraversal levelOrderTraversalInstance = new LevelOrderTraversal();
        BinaryTreeNode root =InOrderTraversal.createBinaryTree();

        System.out.println("Printing the binary tree elements in level order traversal: ");
        levelOrderTraversalInstance.levelOrderTraversal(root);

    }


}
