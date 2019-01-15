package com.practice;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;

/**
 * Created by Uday on 2016-05-08.
 */
public class RemoveDuplicates {

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

    // Take a hash table, iterate through the elements, first time put in to table, if seen for next time change the prev and curr pointers
    // Extra Memory required, TC: O(n), SC: O(n)
    public Node removeDuplicates(Node head) {
        if(head==null)
            return null;

        if(head.next==null)
            return head;

        Hashtable nodeStoreTable= new Hashtable<>();

        Node currentNode=head;
        Node previousNode=null;

        while(currentNode!=null) {

            if(!nodeStoreTable.containsKey(currentNode.data)) {
                nodeStoreTable.put(currentNode.data, true);
                previousNode=currentNode;
                currentNode=currentNode.next;
            }

            else {
                previousNode.next=currentNode.next;
                currentNode.next=null;
                currentNode=previousNode.next;

            }
        }
        return head;

    }

    // Remove Duplicates without extra storage method, Take first element and compare with all other elements, if same element seen adjust the pointers
    // Extra Time required TC: O(n2), SC: O(1)
    public Node removeDuplicatesWithoutExtraStorage(Node head) {

        if (head == null)
            return null;

        if (head.next == null)
            return head;

        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {

                if (current.data == runner.next.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }

            current=current.next;

        }
        return head;
    }

    public static void main(String[] args) {

        RemoveDuplicates removeDuplicatesInstance = new RemoveDuplicates();
        Node head= new Node(3);
        removeDuplicatesInstance.addToTheLast(head);
        removeDuplicatesInstance.addToTheLast(new Node(5));
        removeDuplicatesInstance.addToTheLast(new Node(5));
        removeDuplicatesInstance.addToTheLast(new Node(6));
        removeDuplicatesInstance.addToTheLast(new Node(6));
        removeDuplicatesInstance.addToTheLast(new Node(7));
        removeDuplicatesInstance.addToTheLast(new Node(8));
        removeDuplicatesInstance.addToTheLast(new Node(8));
        removeDuplicatesInstance.addToTheLast(new Node(8));

        removeDuplicatesInstance.printList(head);

        /*Node newHead=removeDuplicatesInstance.removeDuplicates(head);
        removeDuplicatesInstance.printList(newHead);*/

        Node newHeadWithoutStorageMethod=removeDuplicatesInstance.removeDuplicatesWithoutExtraStorage(head);
        removeDuplicatesInstance.printList(newHeadWithoutStorageMethod);

    }
}
