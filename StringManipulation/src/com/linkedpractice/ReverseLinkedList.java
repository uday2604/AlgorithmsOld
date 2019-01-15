package com.linkedpractice;

/**
 * Created by Uday on 2016-05-22.
 */
public class ReverseLinkedList {

    private Node head;

    private static class Node {

        Node next;
        int data;

        Node(int data) {
            this.data=data;
        }
    }


    public void addToLast(Node node) {

        if(head==null)
            head=node;

        else {

            Node temp=head;
            while(temp.next!=null) {

                temp=temp.next;
            }

            temp.next=node;
        }


    }

    public void printList(Node head) {

        if(head==null)
            System.out.println("No elements in the linked list");

        else{
            Node temp=head;
            while(temp!=null) {

                System.out.print(temp.data + " ");
                temp=temp.next;
            }
        }
    }

    public void reverseLinkedListRecursion(Node head) {

        if(head==null)
            return;

        else {
            reverseLinkedListRecursion(head.next);
            System.out.print(head.data+ " ");
        }



    }

    public Node reverseLinkedList(Node head) {

        if(head==null)
        return null;

        if(head.next==null)
            return head;

        else {

            Node current=head;
            Node prevNode=null;
            Node nextNode;

            while(current.next!=null) {

                nextNode=current.next;
                current.next=prevNode;

                prevNode=current;
                current=nextNode;

            }
            current.next=prevNode;
            return current;
        }

    }

    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node head=new Node(3);
        reverseLinkedList.addToLast(head);
        reverseLinkedList.addToLast(new Node(4));
        reverseLinkedList.addToLast(new Node(5));
        reverseLinkedList.addToLast(new Node(6));
        reverseLinkedList.addToLast(new Node(7));

        reverseLinkedList.printList(head);

        System.out.println();
       // reverseLinkedList.reverseLinkedListRecursion(head);

        System.out.println("The linked list after reverse is: ");
        Node reverseNode = reverseLinkedList.reverseLinkedList(head);
        reverseLinkedList.printList(reverseNode);

    }

}
