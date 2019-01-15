package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by udaypersonal on 9/9/16.
 */
public class ConstructBSTFromSortedArray {

    static class BSTNode {

        BSTNode llink;
        BSTNode rlink;
        int count;
        int data;

        BSTNode(int data) {

            this.data=data;
            this.llink=null;
            this.rlink=null;
            this.count=0;
        }

    }

   public static BinaryTreeNode constructBSTFromArray(Integer[] sortedArray) {

       return constructTreeHelper(sortedArray, 0, sortedArray.length-1);

   }

    public static BinaryTreeNode constructTreeHelper(Integer[] inputSortedArray, int start, int end) {

        if(inputSortedArray==null)
            return null;

        if(start>end)
            return null;

        int mid = (start+end)/2;
        BinaryTreeNode root = new BinaryTreeNode(inputSortedArray[mid]);

        root.llink=constructTreeHelper(inputSortedArray, start, mid-1);
        root.rlink = constructTreeHelper(inputSortedArray, mid+1, end);

        return root;


    }


    public static BSTNode constructBST(BSTNode root, int insertData) {


        if (root == null)
            return new BSTNode(insertData);

        if(root.data==insertData) {
            root.count=root.count+1;
            return root;

        }

        if(root.data>insertData)
            root.llink=constructBST(root.llink, insertData);

        if(root.data<insertData)
            root.rlink=constructBST(root.rlink, insertData);

        return root;


    }

    public static void printLevelOrderTraversal(BSTNode root) {

        if(root==null)
            return;

        else {

            Queue<BSTNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);

            while(!nodeStoreQueue.isEmpty()) {

                BSTNode temp = nodeStoreQueue.poll();
                System.out.print("\nData:"+temp.data+",count:"+temp.count+" ");

                if(temp.llink!=null)
                    nodeStoreQueue.offer(temp.llink);

                if(temp.rlink!=null)
                    nodeStoreQueue.offer(temp.rlink);

            }

        }


    }


    public static void main(String[] args) {

        Integer[] inputArray = {2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTreeNode rootAfterConstructing = ConstructBSTFromSortedArray.constructBSTFromArray(inputArray);

        LevelOrderTraversal.printLevelOrderTraversal(rootAfterConstructing);


        BSTNode root = null;
        root=ConstructBSTFromSortedArray.constructBST(root, 2);
        root=ConstructBSTFromSortedArray.constructBST(root, 3);
        root=ConstructBSTFromSortedArray.constructBST(root, 4);
        root=ConstructBSTFromSortedArray.constructBST(root, 5);
        root=ConstructBSTFromSortedArray.constructBST(root, 6);
        root=ConstructBSTFromSortedArray.constructBST(root, 7);
        root=ConstructBSTFromSortedArray.constructBST(root, 8);
        root=ConstructBSTFromSortedArray.constructBST(root, 2);


        ConstructBSTFromSortedArray.printLevelOrderTraversal(root);

    }


}
