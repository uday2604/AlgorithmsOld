package com.amazon;

import java.util.HashSet;

/**
 * Created by udaypersonal on 8/30/16.
 */
public class IntersectionNodeInLinkedList {


    public Node intersectionNodeInList(Node head1, Node head2) {

        if (head1 == null || head2 == null)
            return null;

        HashSet<Node> nodeStoreSet = new HashSet<>();
        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null) {

            nodeStoreSet.add(current1);
            current1 = current1.next;
        }

        while (current2 != null) {

            if (nodeStoreSet.contains(current2))
                return current2;
            current2 = current2.next;
        }

        return null;
    }

    // Program Creek Method
    public Node getIntersectionNode(Node headA, Node headB) {
        int len1 = 0;
        int len2 = 0;
        Node p1 = headA, p2 = headB;
        if (p1 == null || p2 == null)
            return null;

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1 = headA;
        p2 = headB;

        if (len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.data == p2.data) {
                return p1;
            } else {

            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        // First Linked List
        Node head1 = new Node(1);
        Node nodex = new Node(2);
        Node nodex1 = new Node(3);
        Node nodex2 = new Node(4);
        Node nodex3 = new Node(5);

        head1.next = nodex;
        nodex.next = nodex1;
        nodex1.next = nodex2;
        nodex2.next = nodex3;

        // Second Linked List
        Node head2 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(8);

        head2.next = node5;
        node5.next = node6;
        node6.next = nodex1;
        // node6.next=nodex2;

        IntersectionNodeInLinkedList intersectionNodeInLinkedList = new IntersectionNodeInLinkedList();
        Node intersectionNode = intersectionNodeInLinkedList.intersectionNodeInList(head1, head2);
        System.out.println("The intersection node data is " + intersectionNode.data);

        Node intersectionNode2 = intersectionNodeInLinkedList.getIntersectionNode(head1, head2);
        System.out.println(intersectionNode2.data);
    }
}
