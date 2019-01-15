package com.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by uthota on 8/29/16.
 */
public class RemoveDuplicatesFromList {

    public Node removeDuplicatesFromList(Node head) {

        if(head==null)
            return null;

        Node previous=head;
        Node current=head.next;

        while (current!=null) {

            if(previous.data==current.data) {

                previous.next=current.next;
                current.next=null;
                current=previous.next;
            }

            else {
                previous=current;
                current=current.next;
            }

        }

        return head;

    }


    // I/P: 1 1 2 2 3 4     O/P: 3 4
    public Node remainOnlyDistinctNodesInSortedList(Node head) {

        if(head==null)
            return null;

        Node previous=head;
        Node current=head.next;

        while (current!=null) {

            if(current.data==current.next.data) {

                while (current.next!=null && current.data == current.next.data) {
                    if (current.next != null)
                        current = current.next;

                }

                previous.next=current.next;
                current=previous.next;
            }

            else {
                previous=current;
                current=current.next;
            }

        }

        return head;

    }


   // Same as above method, but just using Set to store the data, nothing fancy !!
    public Node removeDuplicatesUsingSet(Node head) {

        if(head==null)
            return null;

        Set<Integer> nodeStoreSet = new HashSet();

        Node previous=head;
        Node current=head.next;

        nodeStoreSet.add(head.data);

        while (current!=null) {

            if(nodeStoreSet.contains(current.data)) {

                previous.next=current.next;
                current.next=null;
                current=previous.next;
            }

            else {
                nodeStoreSet.add(current.data);
                previous=current;
                current=current.next;
            }

        }

        return head;




    }


    public Node removeGivenElementFromList(Node head, int deleteNodeData) {

        if (head == null)
            return null;

        if(head.data==deleteNodeData) {
            if(head.next!=null)
                head=head.next;
            else
                head=null;

        }

        Node previous=head;
        Node current = head.next;

        while(current!=null) {

            if(current.data==deleteNodeData) {

                previous.next=current.next;
                current=previous.next;
            }

            else {

                previous=current;
                current=current.next;
            }


        }

        return head;

    }



    public static void main(String[] args) {

        RemoveDuplicatesFromList removeDuplicatesFromList = new RemoveDuplicatesFromList();

        // Test removing duplicates from sorted list
        Node head1= new Node(1);
        Node nodex= new Node(3);
        Node nodex1= new Node(3);
        Node nodex2= new Node(3);

        Node node1= new Node(5);

        Node node2 = new Node(9);
        Node nodey1= new Node(9);

        Node node3 = new Node(11);
        Node node4 = new Node(11);


        head1.next=nodex;
        nodex.next=nodex1;
        nodex1.next=nodex2;
        nodex2.next=node1;

        node1.next=node2;
        node2.next=nodey1;
        nodey1.next=node3;
        node3.next=node4;



        // Test removing element from linked list
        Node head2= new Node(9);
        Node node5 = new Node(7);
        Node node6= new Node(9);
        Node node7= new Node(11);
        Node node8= new Node(9);
        Node node10= new Node(7);

        head2.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node10;



       /* Node newHead = removeDuplicatesFromList.removeDuplicatesFromList(head1);
        ReorderLinkedLists.printList(newHead);

        Node newHead1= removeDuplicatesFromList.removeDuplicatesUsingSet(head2);
        System.out.println("\nRemoving duplicates using a hash set: ");
        ReorderLinkedLists.printList(head2);*/

        Node newHead2= removeDuplicatesFromList.remainOnlyDistinctNodesInSortedList(head1);
        System.out.println("\nAfter remaining only distinct nodes in the list: ");
        ReorderLinkedLists.printList(head1);


        Node newHeadAfterDeleting = removeDuplicatesFromList.removeGivenElementFromList(head2, 9);
        System.out.println("\nThe list after deleting given element is: ");
        ReorderLinkedLists.printList(newHeadAfterDeleting);


    }
}
