package com.amazon;

/**
 * Created by uthota on 8/29/16.
 */
public class MergeTwoSortedLists {

   // Handles Duplicate values in the list as well
    public Node mergeTwoSortedLists(Node head1, Node head2) {

        if(head1==null)
            return head2;

        if(head2==null)
            return head1;

        Node newHead, current1=head1, current2=head2;

        if(head1.data <head2.data) {
            newHead = new Node(head1.data);
            current1=head1.next;

        }

        else {
            newHead = new Node(head2.data);
            current2=head2.next;
        }

        Node current = newHead;


        while (current1!=null && current2!=null) {

           if(current1.data<current2.data) {
               current.next=current1;
               current1=current1.next;

           }

            else {
               current.next=current2;
               current2=current2.next;

           }
            current=current.next;

        }

        if(current1!=null)
            current.next=current1;

        if(current2!=null)
            current.next=current2;

        return newHead;


    }


    public static void main(String[] args) {

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        Node head1= new Node(1);
        Node nodex= new Node(3);
        Node node1= new Node(5);
        Node node2 = new Node(9);
        Node node3 = new Node(11);

        Node head2= new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(10);
        Node node6= new Node(15);
        Node node7= new Node(18);
        Node node8= new Node(19);

        head1.next=nodex;
        nodex.next=node1;
        node1.next=node2;
        node2.next=node3;

        head2.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;

        Node newHead=mergeTwoSortedLists.mergeTwoSortedLists(head1, head2);
        ReorderLinkedLists.printList(newHead);


    }


}
