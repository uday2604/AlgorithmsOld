package com.practice;

import java.util.LinkedHashSet;

/**
 * Created by Uday on 4/7/2016.
 */
public class LoopExistsInLinkedList {

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

    public void addFromLastAtGivenLink(Node sourceNode, Node destinationNode ) {

        if(head==null)
            head=sourceNode;

        else {
            Node current=head;
            while(current.next!=null) {

                current=current.next;
            }

            current.next=destinationNode;

        }

    }

    // Take a hash set and keep on storing the node addresses in it. If the set encounters the same address again, then it means it has a loop
    // Time Complexity: o(n), Space Complexity: o(n)
    public boolean loopExistsInLinkedList(Node head) {

        if(head==null || head.next==null)
            return false;
        Node currentNode= head;

        LinkedHashSet<Node> nodeStoreSet = new LinkedHashSet<>();

        while(currentNode.next!=null) {

            if(nodeStoreSet.contains(currentNode))
                return true;
            else
                nodeStoreSet.add(currentNode);

            currentNode=currentNode.next;

        }
        return false;

    }

    // Floyd Algorithm: Once both the slow and fast pointers enters the loop, while traversing in the loop, they should meet at some or other point
    // Time Complexity: o(n), Space Complexity: o(1)
    public boolean isLoopExistsFloydAlgorithm(Node head) {

        if(head==null || head.next==null)
            return false;

        Node slowPointer=head;
        Node fastPointer=head;

        while(fastPointer!=null && fastPointer.next!=null) {

            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;

            if(slowPointer==fastPointer)
                return true;
        }

        return false;
    }



    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse linked list using this function
    public static Node reverseLinkedList(Node currentNode)
    {
        // For first node, previousNode will be null
        Node previousNode=null;
        Node nextNode;
        while(currentNode!=null)
        {
            nextNode=currentNode.next;
            // reversing the link
            currentNode.next=previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        LoopExistsInLinkedList loopExistsInLinkedListInstance = new LoopExistsInLinkedList();
        // Creating a linked list
        Node head=new Node(5);
        loopExistsInLinkedListInstance.addToTheLast(head);

        Node sixthNode = new Node(6);
        loopExistsInLinkedListInstance.addToTheLast(sixthNode);

        loopExistsInLinkedListInstance.addToTheLast(new Node(7));
        loopExistsInLinkedListInstance.addToTheLast(new Node(1));
        loopExistsInLinkedListInstance.addToTheLast(new Node(2));

        Node ninthNode = new Node(9);
        loopExistsInLinkedListInstance.addToTheLast(ninthNode);
        loopExistsInLinkedListInstance.addFromLastAtGivenLink(ninthNode,sixthNode);

        boolean isLoopExists=loopExistsInLinkedListInstance.loopExistsInLinkedList(head);
        System.out.println("The loop exists or not:"+isLoopExists);

        boolean isLoopExistsFloydAlgo= loopExistsInLinkedListInstance.isLoopExistsFloydAlgorithm(head);
        System.out.println("The loop exists or not with floyd algo:"+isLoopExistsFloydAlgo);

       /*list.printList(head);
        //Reversing LinkedList
        Node reverseHead=reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);*/

    }


}
