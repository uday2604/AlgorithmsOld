package com.amazon;

/**
 * Created by uthota on 8/27/16.
 */
public class LowestCommonAncestorOfBST {


    // LCA of 2 nodes in a BST is (Given node1 <node2):
    // If the root lies between node 1 and nodes 2, then root is the LCA
    // If both node1 and node2 lies less than root, LCA lies on left side of the root
    // If both node1 and node2 lies greater than root, LCA lies on right side of the root

    public int lowestCommonAncestorOfBST(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {

            if(root==null)
              return -1;

            else {

                if(root.data>node1.data && root.data <node2.data)
                    return root.data;

                else if(node1.data>root.data && node2.data>root.data)
                    return lowestCommonAncestorOfBST(root.rlink, node1, node2);

                else if(node1.data<root.data && node2.data<root.data)
                    return lowestCommonAncestorOfBST(root.llink, node1, node2);

                return root.data;

            }


    }


    public  static  void main(String[] args) {

        LowestCommonAncestorOfBST lowestCommonAncestorOfBST = new LowestCommonAncestorOfBST();
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

        int lca = lowestCommonAncestorOfBST.lowestCommonAncestorOfBST(root, node4, node1);
        System.out.println("The LCA of given 2 nodes is "+lca);


    }



}
