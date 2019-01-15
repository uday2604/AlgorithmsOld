package com.practice;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-07.
 */
public class PrintInReverseOrder {

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

    public void printElementsInReverseOrder(Node head) {

        if(head==null)
          return;

        else {
            printElementsInReverseOrder(head.next);
            System.out.print(head.data+ " ");
        }


    }

    public Stack<Node> printElementsInReverseOrderUsingStacks(Node head) {

        if(head==null)
            return null;

        Stack<Node> nodeStoreStack = new Stack<>();

        Node current=head;
        while(current!=null) {

            nodeStoreStack.push(current);
            current=current.next;
        }

        return nodeStoreStack;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        PrintInReverseOrder printInReverseOrderInstance= new PrintInReverseOrder();
        Node head= new Node(3);
        printInReverseOrderInstance.addToTheLast(head);
        printInReverseOrderInstance.addToTheLast(new Node(4));
        printInReverseOrderInstance.addToTheLast(new Node(5));
        printInReverseOrderInstance.addToTheLast(new Node(6));
        printInReverseOrderInstance.addToTheLast(new Node(7));

        printInReverseOrderInstance.printList(head);
        printInReverseOrderInstance.printElementsInReverseOrder(head);

        Stack<Node> outputStack = printInReverseOrderInstance.printElementsInReverseOrderUsingStacks(head);
        System.out.println();

        while(!outputStack.isEmpty()) {

            Node temp = outputStack.pop();
            System.out.print(temp.data+ " ");
        }


    }

}
