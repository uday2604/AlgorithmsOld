package com.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by udaypersonal on 9/12/16.
 */
public class ReturnListsOfPathSum {
    
        public static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {

            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null) return result;

            Queue<BinaryTreeNode> nodes = new LinkedList<>();
            Queue<Integer> sumdataues = new LinkedList<>();

            nodes.add(root);
            sumdataues.add(root.data);

            LinkedList<List<Integer>> l = new LinkedList<List<Integer>>();
            List<Integer> a = new ArrayList<>();

            a.add(root.data);
            l.add(a);


            while(!nodes.isEmpty()){

                Integer sumdataue = sumdataues.poll();
                BinaryTreeNode t = nodes.poll();
                a = l.poll();


                if(t.llink == null && t.rlink == null && sumdataue == sum){
                    result.add(a);
                }
                else{
                    if(t.rlink != null) {
                        nodes.add(t.rlink);
                        sumdataues.add(t.rlink.data + sumdataue);
                        List<Integer> r = new ArrayList<>();
                        r.addAll(a);
                        r.add(t.rlink.data);
                        l.add(r);
                    }
                    if(t.llink != null) {
                        nodes.add(t.llink);
                        sumdataues.add(t.llink.data + sumdataue);
                        List<Integer> le = new ArrayList<>();
                        le.addAll(a);
                        le.add(t.llink.data);
                        l.add(le);
                    }
                }
            }
            return result;
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

            List<List<Integer>> result = ReturnListsOfPathSum.pathSum(root, 14);

            System.out.println(result);
        }
    }

