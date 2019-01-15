package com.practice;

/**
 * Created by Uday on 2016-05-07.
 */
public class FindMiddleNode {

    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

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

    // Use two pointers, move slow pointer by one node and fast pointer by two nodes.
    // Once fast node reaches last node, slow pointer will point at the middle node
    // TC: O(n), SC: O(1)
    public Node findMiddleNodeInLinkedList(Node head) {

        if(head==null)
            return null;
        if(head.next==null)
            return head;

       Node slowPointer=head;
       Node fastPointer=head;

        while(fastPointer.next!=null) {

            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;

            if(fastPointer.next!=null)
                fastPointer=fastPointer.next;

        }

        return slowPointer;
    }

   // Traverse through the list and find the length. Traverse through list for 2nd time till length/2 and print the last node
   // TC: O(n) SC: O(1)
    public int findMiddleNodeInLinkedList2ndMethod(Node head) {

        if(head==null)
            return 0;
        if(head.next==null)
            return head.value;

        Node currentNode=head;
        int count=1;
        while(currentNode.next!=null) {
            currentNode=currentNode.next;
            count++;
        }

        Node temp=head;
        for(int i=0;i<count/2;i++) {

            temp=temp.next;
        }

        return temp.value;
    }


    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        FindMiddleNode findMiddleNodeInstance= new FindMiddleNode();

        Node head = new Node(1);
        findMiddleNodeInstance.addToTheLast(head);
        findMiddleNodeInstance.addToTheLast(new Node(2));
        findMiddleNodeInstance.addToTheLast(new Node(3));
        findMiddleNodeInstance.addToTheLast(new Node(4));
        findMiddleNodeInstance.addToTheLast(new Node(5));
        findMiddleNodeInstance.addToTheLast(new Node(6));

        findMiddleNodeInstance.printList(head);

        Node middleNode=findMiddleNodeInstance.findMiddleNodeInLinkedList(head);


        int middleNodeData= findMiddleNodeInstance.findMiddleNodeInLinkedList2ndMethod(head);
        System.out.println("The middle node element in the list is "+ middleNode.value);
        System.out.println("The middle node data with 2nd method is "+ middleNodeData);
    }

}
