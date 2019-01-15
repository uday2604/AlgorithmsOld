package com.amazon;

/**
 * Created by uthota on 8/28/16.
 */
public class LoopExistsInCycle {

    public boolean ifLoopExistsInList(Node head) {

        if(head==null)
            return false;

        Node current = head;
        Node slowPointer = current;
        Node fastPointer = current;

        while (fastPointer.next!=null) {

            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;

            if(fastPointer.next!=null)
                fastPointer=fastPointer.next;

            if(slowPointer==fastPointer)
                return true;

        }

        return false;



    }

    public static void main(String[] args) {

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
        node6.next=node5;
        //node5.next=node4;
        //node7.next=node3;

        LoopExistsInCycle loopExistsInCycle = new LoopExistsInCycle();

        boolean loopExists = loopExistsInCycle.ifLoopExistsInList(head);
        System.out.println("Loops exists in the given list: "+loopExists);


    }


}
