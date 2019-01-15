package com.amazon;

/**
 * Created by udaypersonal on 9/5/16.
 */
public class InvertBinaryTree {


    public BinaryTreeNode invertBinaryTree(BinaryTreeNode root) {

        if(root!=null)
            invertTreeHelper(root);

        return root;


    }

    public void invertTreeHelper(BinaryTreeNode root) {

        BinaryTreeNode temp = root.rlink;
        root.rlink=root.llink;
        root.llink=temp;

        if(root.llink!=null) {
            invertTreeHelper(root.llink);
        }

        if(root.rlink!=null)
            invertTreeHelper(root.rlink);

    }


    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        // BinaryTreeNode node7 = new BinaryTreeNode(10);

        root.llink = node1;
        root.rlink = node2;

        node1.llink = node3;
        node1.rlink = node4;

        node2.llink = node5;
        node2.rlink=node6;

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        BinaryTreeNode headAfterInverting = invertBinaryTree.invertBinaryTree(root);
        LevelOrderTraversal.printLevelOrderTraversal(headAfterInverting);




    }
}
