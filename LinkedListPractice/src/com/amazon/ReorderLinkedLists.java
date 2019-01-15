package com.amazon;

/**
 * Created by uthota on 8/28/16.
 */
public class ReorderLinkedLists {


    public static void printList(Node head) {

        if(head==null)
            System.out.println("No elements in the linked list to print");

        else {

            Node current = head;

            while (current!=null) {

                System.out.print(current.data+" ");
                current=current.next;

            }

        }

    }

   // I/P: 1 2 3 4 5 6 7     O/P: 1 7 2 6 3 5 4
   // Break the list to middle (using slow and fast pointers). Reverse the second list and merge 1st and 2nd sub lists

    public Node reorderLinkedList(Node head) {

        if(head==null)
            return null;

        if(head.next==null || head.next.next==null)
            return head;

        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer.next!=null) {

            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;

            if(fastPointer.next!=null)
                fastPointer=fastPointer.next;

        }

        Node reversedHeadIn2ndList = reverseUsingGeeksMethod(slowPointer.next);
        slowPointer.next=null;

        Node current= head;

        while (reversedHeadIn2ndList!=null) {

            Node temp1= current.next;
            Node temp2= reversedHeadIn2ndList.next;

            current.next=reversedHeadIn2ndList;
            reversedHeadIn2ndList.next=temp1;

            current=temp1;
            reversedHeadIn2ndList=temp2;


        }

        return head;

    }



    public void reverseList (Node head) {

        if(head==null)
            return;

        else {
            reverseList(head.next);
            System.out.print(head.data+" ");
        }


    }

    /* Function to reverse the linked list */
    Node reverseUsingGeeksMethod(Node HeadNode) {
        Node prev = null;
        Node current = HeadNode;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        HeadNode = prev;
        return HeadNode;
    }


    public static void main(String[] args) {

        ReorderLinkedLists reorderLinkedLists = new ReorderLinkedLists();
        Node head= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);
        Node node5= new Node(5);
        Node node6= new Node(6);
        Node node7= new Node(7);

        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;

        ReorderLinkedLists.printList(head);
        System.out.println();

       /* reorderLinkedLists.reverseList(head);
        Node reversedHead = reorderLinkedLists.reverseUsingGeeksMethod(head);
        ReorderLinkedLists.printList(reversedHead);*/

        Node headAfterReordering = reorderLinkedLists.reorderLinkedList(head);
        ReorderLinkedLists.printList(headAfterReordering);


    }



}
