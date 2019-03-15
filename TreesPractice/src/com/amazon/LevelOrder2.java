package com.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udaypersonal on 9/5/16.
 */
public class LevelOrder2 {

    // Returns each level of elements (from last level) in an array list
    // Returns [[8, 9], [6,7], [4,5], [3]]
    private static List<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {
        List<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return resultSet;
        LinkedList<BinaryTreeNode> current = new LinkedList<>();
        LinkedList<BinaryTreeNode> next = new LinkedList<>();
        ArrayList<Integer> numberList = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            BinaryTreeNode temp = current.poll();
            numberList.add(temp.data);
            if (temp.llink != null)
                next.offer(temp.llink);
            if (temp.rlink != null)
                next.offer(temp.rlink);
            if (current.isEmpty()) {
                resultSet.add(numberList);
                current = next;
                next = new LinkedList<>();
                numberList = new ArrayList<>();
            }
        }
        return resultSet;
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
        node2.rlink = node6;
        List<ArrayList<Integer>> outputList = LevelOrder2.levelOrderTraversal(root);
        // Print the output list in Reverse Order
        for (int i = outputList.size() - 1; i >= 0; i--) {
            System.out.print(outputList.get(i) + " ");
        }
    }
}
