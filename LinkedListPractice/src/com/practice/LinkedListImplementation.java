package com.practice;

/**
 * Created by Uday on 4/7/2016.
 */
 class LinkedListImplementation {

    private static int counter;
    private Node head;

    public LinkedListImplementation() {


    }

    public void add(Object data) {

        Node temp = new Node(data);
        Node current = head;

        if(current==null) {
            head=temp;
        }

        else {

            while(current.getNext()!=null) {
                current=current.getNext();
            }

            current.setNext(temp);
        }

        counter++;
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



    public void addAtIndexLocation(Object data, int index) {

        if(index<0) {

            System.out.println("Invalid Index, cannot add the node at the given location ");
        }

        else {

            Node temp = new Node(data);
            Node current = head;

            if(index==0) {
                temp.setNext(head);
                head=temp;
            }

            else {

                for(int i=0;i<index-1 && current.getNext()!=null ;i++) {

                    current=current.getNext();
                }
                temp.setNext(current.getNext());
                current.setNext(temp);
            }
            counter++;
        }
    }

    public Object get(int index) {

        Node current =null;
        if(index<0) {
            System.out.println("Improper index value: Cannot fetch the element");
        }
        else {
            current = head;
            if(current!=null) {
                for(int i=0; i<index;i++) {

                    if(current.getNext()==null)
                        return null;

                    current=current.getNext();
                }

                return current.getData();
            }

        }
        return current;
    }

    public boolean remove (int index) {

        if(index<0) {
            System.out.println("Not a valid index, cannot remove element");
            return false;
        }
        else {

            Node current = head;

            if(current!=null) {
                for (int i=0; i<index-1;i++) {
                    if(current.getNext()==null) {
                        return false;
                    }

                    current=current.getNext();
                }
                current.setNext(current.getNext().getNext());
                counter--;
                return true;

            }

            System.out.println("Element cannot be removed without any list elements");
            return false;
        }
    }

    public String toString() {

        String output="";

        Node current= head;
        while(current!=null){
            output+="["+current.getData().toString()+"]";
            current=current.getNext();
        }

        return output;
    }

    public void linkedListReverse(Node head) {

        if(head == null)
            return;
        else {
            linkedListReverse(head.next);
            System.out.println(head.data);

        }
    }


    public static class Node {


        Node next;
        Object data;

        public Node(Object dataValue) {

            this.next = null;
            this.data= dataValue;

        }

        public Node(Object dataValue, Node nextValue) {

            this.next = nextValue;
            this.data=dataValue;

        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {

            this.data= dataValue;
        }

        public Node getNext() {

            return this.next;
        }

        public void setNext(Node nextValue) {

            this.next=nextValue;
        }
    }

}
