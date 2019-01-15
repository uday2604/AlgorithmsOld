package com.practice;


import java.util.Stack;

/**
 * Created by Uday on 4/7/2016.
 */
public class LinkedListReverse{

    private Node head;
    int counter=0;

    public static class Node {


        Node next;
        Object data;

        public Node(Object dataValue) {

            next = null;
            data= dataValue;

        }

        public Node(Object dataValue, Node nextValue) {

            next = nextValue;
            data=dataValue;

        }

    }

    public void add(Object data) {

        Node temp = new Node(data);
        Node current = head;

        if(current==null) {
            head=temp;
        }

        else {

            while(current.next!=null) {
                current=current.next;
            }

            current.next=temp;
        }

    }

    public void add(Node node) {

        Node current = head;

        if(current==null) {
            head =node;
        }

        else {

            while(current.next!=null) {
                current=current.next;
            }
            current.next=node;
        }
        counter++;
    }



    public void linkedListReverse(Node head) {

        if(head == null)
            return;
        else {
            linkedListReverse(head.next);
            System.out.println(head.data);

        }
    }

    public Stack linkedListReverseWithStacks(Node head) {

        Stack<Object> outputStack = new Stack<>();
        Node current = head;

        if(current==null) {
            System.out.println("No elements in the stack");
        }
        else {
            while(current.next!=null) {
                outputStack.push(current.data);
                current= current.next;
            }
            outputStack.push(current.data);
        }
        return outputStack;

    }

    public Node linkedListReverseWithIteration(Node head) {

        Node previousNode, currentNode, tempNode;

        if(head==null || head.next==null) {
            return head;
        }

        else{

            previousNode = head;
            currentNode = head.next;

            while(currentNode.next!=null) {

                previousNode.next=null;
                tempNode = currentNode;
                currentNode=currentNode.next;
                tempNode.next=previousNode;
                previousNode=tempNode;
            }

           previousNode.next=null;
            currentNode.next=previousNode;

        }
        return currentNode;

    }

    // Looks like simple and elegant, though check this once for corner cases
    public Node reverseLinkedListIteration(Node head) {

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


    public String toString() {

        String output="";

        Node current= head;
        while(current!=null){
            output+="["+current.data.toString()+"]";
            current=current.next;
        }

        return output;
    }

    public void printList(Node head) {

        if(head==null)
            System.out.println("No elements in the list to print");
        else {
            Node current = head;
            while(current!=null) {

                System.out.println(current.data);
                current=current.next;
            }
        }
    }

    //This method Working Fine
    public Node reverseLinkedList(Node currentNode)
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

    /*    LinkedListReverse linkedListReverseInstance = new LinkedListReverse();

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        linkedListReverseInstance.add(head);
        linkedListReverseInstance.add(node2);
        linkedListReverseInstance.add(node3);
        linkedListReverseInstance.add(node4);
        linkedListReverseInstance.add(node5);
        linkedListReverseInstance.add(node6);

        System.out.println("The entered linked list elements are "+ linkedListReverseInstance);

        // Using Stacks
        Stack outputStack = linkedListReverseInstance.linkedListReverseWithStacks(head);
        System.out.println("Linked list reverse using stacks is ");
        while(outputStack.size()!=0) {

            System.out.println(outputStack.pop());
        }*/


        LinkedListReverse linkedListReverseInstance2 = new LinkedListReverse();
        Node head2 = new Node(9);
        Node node10 = new Node(10);
        Node node11= new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);


        linkedListReverseInstance2.add(head2);
        linkedListReverseInstance2.add(node10);
        linkedListReverseInstance2.add(node11);
        linkedListReverseInstance2.add(node12);
        linkedListReverseInstance2.add(node13);
        linkedListReverseInstance2.add(node14);

        System.out.println("Before iterative reverse function calling "+ linkedListReverseInstance2);

        // Iterative function calling
        Node reverseHeadNode = linkedListReverseInstance2.linkedListReverseWithIteration(head2);

        System.out.println("The head of reversed linked list is "+reverseHeadNode.data);
        System.out.println("Linked list reverse using iterative function is ");


       LinkedListReverse linkedListReverse = new LinkedListReverse();
        Node headGeek = new Node(15);
        linkedListReverse.add(headGeek);
        linkedListReverse.add(new Node(16));
        linkedListReverse.add(new Node(17));
        linkedListReverse.add(new Node(18));
        linkedListReverse.add(new Node(19));
        linkedListReverse.add(new Node(20));


        Node reverseHeadUsingGeeks = linkedListReverse.reverseUsingGeeksMethod(headGeek);
        System.out.println("List after reversing using geeks method is ");
        linkedListReverseInstance2.printList(reverseHeadUsingGeeks);

    }
}
