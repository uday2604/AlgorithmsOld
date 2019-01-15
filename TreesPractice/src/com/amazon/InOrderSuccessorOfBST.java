package com.amazon;

import java.util.Stack;

/**
 * Created by udaypersonal on 9/8/16.
 */
public class InOrderSuccessorOfBST {

    static class BinaryTreeNode  {

        int data;
        BinaryTreeNode llink;
        BinaryTreeNode rlink;

        BinaryTreeNode(int data) {

            this.data=data;
            this.llink=null;
            this.rlink=null;
        }


    }

    public static BinaryTreeNode findNodeInBST (BinaryTreeNode root, int data) {

        if(root==null)
            return null;

        if(root.data==data)
            return root;

        if(root.data>data)
            return findNodeInBST(root.llink, data);

        if(root.data<data)
            return findNodeInBST(root.rlink, data);

        return null;

    }


    public static BinaryTreeNode findSuccessor(BinaryTreeNode root, int data) {

        if(root==null)
            return null;

        BinaryTreeNode deleteNode = findNodeInBST(root, data);

       // Case 1 : If delete node has the right sub tree, just find the min node in right sub tree and return it
        if(deleteNode.rlink!=null) {
            return findMinimumNode(deleteNode.rlink);
        }

        // Case 2: Else, traverse down from root to delete node and adjust the pointers
        else {

            BinaryTreeNode ancestor = root;
            BinaryTreeNode successor = null;

            while (ancestor!=deleteNode) {

                if(ancestor.data > deleteNode.data) {
                    successor=ancestor;
                    ancestor=ancestor.llink;

                }
                else {
                    ancestor=ancestor.rlink;

                }


            }
            return successor;

        }


    }

    public static BinaryTreeNode findMinimumNode(BinaryTreeNode node) {

        while(node.llink!=null) {
            node=node.llink;
        }
        return node;
    }


    // Just do pre order traversal and while processing the node, if it is find node :
    // case 1: if node has right link, go to the left most of the right link and return the data
    // case 2: else pop the stack and return it (which means the next highest value of the node)
    // Time complexity : O(n)
    public static BinaryTreeNode findInOrderSuccessor(BinaryTreeNode root, BinaryTreeNode findNode) {


        if(root==null || findNode==null)
            return null;

        
        Stack<BinaryTreeNode> nodeStoreStack = new Stack<>();
        BinaryTreeNode current = root;

        while (!nodeStoreStack.isEmpty() || current!=null) {

            if(current!=null) {
                nodeStoreStack.add(current);
                current=current.llink;
            }

            else {

                BinaryTreeNode temp = nodeStoreStack.pop();
                current=temp.rlink;

                if(temp==findNode) {

                    if(temp.rlink!=null) {
                        BinaryTreeNode successor = temp.rlink;
                        while(successor.llink!=null) {

                            successor=successor.llink;
                        }
                        return successor;

                    }
                    else if(!nodeStoreStack.isEmpty()) {
                        return nodeStoreStack.pop();
                    }

                }


            }


        }

        return null;

    }





    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(7);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(9);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(10);
        BinaryTreeNode node7 = new BinaryTreeNode(5);

        root.llink = node1;
        root.rlink = node2;

        node1.llink = node3;
        node1.rlink = node4;

        node2.llink = node5;
        node2.rlink=node6;

        node4.llink=node7;


        BinaryTreeNode successorNode =InOrderSuccessorOfBST.findInOrderSuccessor(root, node4);
        System.out.println(successorNode.data);

        /*BinaryTreeNode successorNode =InOrderSuccessorOfBST.inorderSuccessor(root, node1);
        System.out.println(successorNode.data);*/

        /*boolean ifNodePresent =InOrderSuccessorOfBST.findNodeInBST(root, 15);
        System.out.println(ifNodePresent);*/

        /*BinaryTreeNode testNode = InOrderSuccessorOfBST.findNodeInBST(root, 5);
        System.out.println(testNode.data);*/


       /* BinaryTreeNode testNode2 = InOrderSuccessorOfBST.findSuccessor(root, 6);
        System.out.println(testNode2.data);
*/


    }


}
