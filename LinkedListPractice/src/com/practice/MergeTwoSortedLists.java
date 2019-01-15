package com.practice;

/**
 * Created by Uday on 2016-05-07.
 */
public class MergeTwoSortedLists {

    private Node head;

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;

        }
    }

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public Node mergeTwoLinkedLists(Node headNode1, Node headNode2) {

        if(headNode1==null)
            return headNode2;
        if(headNode2==null)
            return headNode1;

        Node current, headNode;
       // Node headNode=null;

        if(headNode1.data<headNode2.data) {
            current = headNode1;
            headNode1=headNode1.next;
        }

        else {
            current = headNode2;
            headNode2=headNode2.next;
        }

        headNode=current;

        while(headNode1!=null && headNode2!=null) {

            if(headNode1.data<=headNode2.data) {
                current.next=headNode1;
                headNode1=headNode1.next;
            }

            else {
                current.next=headNode2;
                headNode2=headNode2.next;
            }

            current = current.next;

        }

        if(headNode1!=null)
            current.next=headNode1;
        else if(headNode2!=null)
            current.next=headNode2;

        return headNode;

    }

    public static void main(String[] args) {

        MergeTwoSortedLists mergeTwoSortedListsInstance = new MergeTwoSortedLists();
        Node headNode1=new Node(5);
        mergeTwoSortedListsInstance.addToTheLast(headNode1);
        mergeTwoSortedListsInstance.addToTheLast(new Node(7));
        mergeTwoSortedListsInstance.addToTheLast(new Node(9));
        mergeTwoSortedListsInstance.addToTheLast(new Node(13));
        mergeTwoSortedListsInstance.addToTheLast(new Node(15));
        System.out.println("The first list is ");
        mergeTwoSortedListsInstance.printList(headNode1);

        Node headNode2= new Node(3);
        mergeTwoSortedListsInstance.addToTheLast(headNode2);
        mergeTwoSortedListsInstance.addToTheLast(new Node(6));
        mergeTwoSortedListsInstance.addToTheLast(new Node(8));
        mergeTwoSortedListsInstance.addToTheLast(new Node(14));
        mergeTwoSortedListsInstance.addToTheLast(new Node(18));
        System.out.println("The second list is ");
        mergeTwoSortedListsInstance.printList(headNode2);


        Node mergedNodeHead=mergeTwoSortedListsInstance.mergeTwoLinkedLists(headNode1, headNode2);
        System.out.println("The merged list is ");
        mergeTwoSortedListsInstance.printList(mergedNodeHead);



    }

}
