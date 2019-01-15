package com.practice;

/**
 * Created by Uday on 2016-04-08.
 */
public class SortLinkedLists {

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
            System.out.println("No elements found in the list to print");
        else {
            Node current = head;
            while(current!=null) {

                System.out.println(current.data);
                current=current.next;
            }
        }
    }

    /*public Node sortLinkedLists(Node head) {

        if(head==null || head.next==null)
            return head;

        else {

            int minValue=(int) head.data;
            Node current = head.next;
            while(current.next!=null) {

                if((int)current.data<minValue) {


                }
                else {
                    current=current.next;
                }


            }

        }
    }*/


    public static void main(String[] args) {

        SortLinkedLists sortLinkedLists = new SortLinkedLists();

        sortLinkedLists.add(new Node(1));
        sortLinkedLists.add(new Node(5));
        sortLinkedLists.add(new Node(7));
        sortLinkedLists.add(new Node(4));
        sortLinkedLists.add(new Node(8));
        sortLinkedLists.add(new Node(3));

        System.out.println(sortLinkedLists);

    }

}
