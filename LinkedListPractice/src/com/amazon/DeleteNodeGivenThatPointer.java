package com.amazon;

/**
 * Created by udaypersonal on 9/2/16.
 */
public class DeleteNodeGivenThatPointer {

    private static class Node {

        Node next;
        Object data;

        Node(Object data) {
            this.data=data;
            next=null;
        }

    }

    public void deleteNodeFromLinkedList(Node deleteNode) {

        if(deleteNode==null)
            System.out.println("No nodes to be deleted");

        else {

            if(deleteNode.next!=null) {
                deleteNode.data = deleteNode.next.data;
                deleteNode.next = deleteNode.next.next;

            }
            else {
               // Node temp = new Node(9);
                //deleteNode.next=temp;
                deleteNode=null;
              //  deleteNode.next=deleteNode.next.next;

            }

        }


    }

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


    public static void main(String[] args) {


        Node head = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);

        head.next=node2;
        node2.next=node3;
        node3.next=node4;

        DeleteNodeGivenThatPointer deleteNodeGivenThatPointer = new DeleteNodeGivenThatPointer();
        deleteNodeGivenThatPointer.deleteNodeFromLinkedList(node4);
        System.out.println("The list after deleting is ");
        printList(head);



    }
}
