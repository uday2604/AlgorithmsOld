    package com.practice;

    /**
     * Created by Uday on 2016-05-05.
     */
    public class InsertInSortedLinkedList {

        private Node head;
        private static int counter;

        public InsertInSortedLinkedList() {

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

        public String toString() {

            String output="";

            Node current= head;
            while(current!=null){
                output+="["+current.getData().toString()+"]";
                current=current.getNext();
            }

            return output;
        }

        public void printList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.format("%d ", temp.data);
                temp = temp.next;
            }
            System.out.println();
        }

        public Node insertInSortedList(Node head, int newNodeData) {

            if(head==null)
                return null;

            Node newNode = new Node(newNodeData);


            if((int)head.getData()>newNodeData) {
                newNode.next = head;
                head = newNode;
                return head;
            }


            Node prev = head;
            Node current=head.next;

            while(current!=null && newNodeData>(int)current.getData()) {
                prev=current;
                current=current.getNext();
            }

            if(current!=null) {

                prev.next=newNode;
                newNode.next=current;

                return head;
            }

            prev.next=newNode;
            return head;


        }


        public static void main(String[] args) {

            InsertInSortedLinkedList insertInSortedLinkedListInstance = new InsertInSortedLinkedList();
            Node head=new Node(3);

            insertInSortedLinkedListInstance.addToTheLast(head);
            insertInSortedLinkedListInstance.addToTheLast(new Node(5));
            insertInSortedLinkedListInstance.addToTheLast(new Node(7));
            insertInSortedLinkedListInstance.addToTheLast(new Node(9));
            insertInSortedLinkedListInstance.addToTheLast(new Node(11));

            System.out.println("Printing the list before inserting: ");
            insertInSortedLinkedListInstance.printList(head);

            System.out.println("Printing the list after inserting: ");
            Node headNodeAfterInserting=insertInSortedLinkedListInstance.insertInSortedList(head, 2);
            insertInSortedLinkedListInstance.printList(headNodeAfterInserting);




        }
    }
