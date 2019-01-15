package com.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by uthota on 8/24/16.
 */
public class PreOrderTraversal {

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



    // Efficient and simple solution. As left side of tree should be processed before right tree, right link should be stored first in the stack
    // so that when popping from it, left node would be processed first
    public List<BinaryTreeNode> preOrderTraversalIterative(BinaryTreeNode root) {

        if(root==null)
            return null;

        else {

            Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
            List<BinaryTreeNode> outputList = new ArrayList<>();

            BinaryTreeNode current =root;
            nodeStoreStack.push(current);

            while(!nodeStoreStack.isEmpty()) {

                BinaryTreeNode temp = nodeStoreStack.pop();
                outputList.add(temp);

                if(temp.rlink!=null)
                    nodeStoreStack.push(temp.rlink);

                if(temp.llink!=null)
                    nodeStoreStack.push(temp.llink);

            }

        return outputList;

        }


    }


    public void preOrderTraversal(BinaryTreeNode root) {

        if(root!=null){
            System.out.print(root.data + " ");
            preOrderTraversal(root.llink);
            preOrderTraversal(root.rlink);
        }
    }


    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(9);

        root.llink=node1;
        root.rlink=node2;

        node1.llink=node3;
        node1.rlink=node4;

        node2.llink=node5;
        node2.rlink=node6;

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preOrderTraversal(root);


        System.out.println("\nThe pre order traversal through iterative method is:");
        List<BinaryTreeNode> outputList = preOrderTraversal.preOrderTraversalIterative(root);

        for(BinaryTreeNode temp: outputList)
            System.out.print(temp.data+" ");

    }
}
