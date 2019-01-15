package com.practice;

/**
 * Created by Uday on 4/7/2016.
 */
public class TestLinkedList {

    public static void main(String[] args){

        LinkedListImplementation linkedInstance= new LinkedListImplementation();

       // LinkedListImplementation.Node head = new LinkedListImplementation.Node(9);

       // linkedInstance.add(head);
        /*linkedInstance.add(5);
        linkedInstance.add(6);
        linkedInstance.add(1);
        linkedInstance.add(7);
        linkedInstance.add(8);
        linkedInstance.add(2);
*/
        LinkedListImplementation.Node head = new LinkedListImplementation.Node(1);
        LinkedListImplementation.Node node2 = new LinkedListImplementation.Node(2);
        LinkedListImplementation.Node node3 = new LinkedListImplementation.Node(3);
        LinkedListImplementation.Node node4 = new LinkedListImplementation.Node(4);

        linkedInstance.add(head);
        linkedInstance.add(node2);
        linkedInstance.add(node3);
        linkedInstance.add(node4);

        linkedInstance.linkedListReverse(head);

        System.out.println(linkedInstance);



        /*System.out.println(linkedInstance.get(2));

        linkedInstance.addAtIndexLocation(10, 0);
        System.out.println(linkedInstance);

        linkedInstance.addAtIndexLocation(9, 3);
        System.out.println(linkedInstance);

        linkedInstance.remove(4);
        System.out.println(linkedInstance);*/
    }
}

