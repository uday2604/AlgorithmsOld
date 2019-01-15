package com.practice;

/**
 * Created by Uday on 2016-05-08.
 */
public class QueueImplementationUsingLinkedList {

    Node front;
    Node rear;

    int length;

    public QueueImplementationUsingLinkedList(){
        front=null;
        rear=null;
        length=0;
    }

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;

        }
    }

    public void enQueue(int data) {

        Node newNode = new Node(data);
        newNode.next=null;

        if(front==null && rear==null) {
            front=newNode;
            rear=newNode;
        }
        else {
            rear.next=newNode;
            rear=newNode;
        }

        length++;

    }

    public int deQueue() throws Exception {

        if(front==null)
            throw new Exception();

        int data = front.data;
        front=front.next;
        length--;
        return data;

    }

    public String toString() {

        String result="";
        while(front!=null) {
            result+=front.data + " ";
            front=front.next;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        QueueImplementationUsingLinkedList queueImplementationUsingLinkedList= new QueueImplementationUsingLinkedList();
        queueImplementationUsingLinkedList.enQueue(2);
        queueImplementationUsingLinkedList.enQueue(3);
        queueImplementationUsingLinkedList.enQueue(4);
        queueImplementationUsingLinkedList.enQueue(5);
        System.out.println(queueImplementationUsingLinkedList.toString());
        System.out.println(queueImplementationUsingLinkedList.front + ","+ queueImplementationUsingLinkedList.rear.data);

       /* int deQueuedData=queueImplementationUsingLinkedList.deQueue();
        System.out.println("De-queued data is "+deQueuedData);*/


    }

}
