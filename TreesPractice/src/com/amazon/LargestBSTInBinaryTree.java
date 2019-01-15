package com.amazon;

/**
 * Created by udaypersonal on 9/7/16.
 */
public class LargestBSTInBinaryTree {

    static class BinaryTreeNode {

        BinaryTreeNode llink;
        BinaryTreeNode rlink;
        int data;

        BinaryTreeNode(int data) {

            this.data=data;
            this.llink=null;
            this.rlink=null;
        }

    }

    static class Wrapper {

        boolean isBST;
        int size;
        int min, max;

        public Wrapper () {

            isBST=false;
            min=Integer.MAX_VALUE;
            max= Integer.MIN_VALUE;
            size=0;

        }

    }


    public static int sizeOfLargestBST(BinaryTreeNode root) {

            return helperForBST(root).size;

    }


    public static Wrapper helperForBST(BinaryTreeNode root) {

        Wrapper current = new Wrapper();

        if(root==null) {

            current.isBST=true;
            return current;
        }

        Wrapper left=helperForBST(root.llink);
        Wrapper right = helperForBST(root.rlink);

        current.min=Math.min(root.data, left.min);
        current.max = Math.max(root.data, right.max);

        if(left.isBST && right.isBST && root.data>=left.max && root.data <=right.min) {

            current.isBST=true;
            current.size=left.size+right.size+1;

        }
        else {

            current.isBST=false;
            current.size= Math.max(left.size, right.size);
        }


        return current;

    }

    public static void main(String[] args) {


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

        node2.llink = node5;
        node2.rlink=node6;


        int maxSizeOfBST = LargestBSTInBinaryTree.sizeOfLargestBST(root);
        System.out.println("The max size is: "+maxSizeOfBST);

    }




}
