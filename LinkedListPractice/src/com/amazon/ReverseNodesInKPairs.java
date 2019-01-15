package com.amazon;

/**
 * Created by udaypersonal on 9/4/16.
 */
public class ReverseNodesInKPairs {

    public Node reverseNodesInKPairs(Node head, int k) {

        if(head==null || head.next==null)
            return head;


             Node fakeHead = new Node(0);
             fakeHead.next=head;

            Node pre = fakeHead;
            Node current = head;
            int i=0;

            while (current!=null) {

                i++;

                if(i%k==0) {

                    pre=reverseTheNodes(pre, current.next);
                    current=pre.next;

                }

                else {
                    current=current.next;
                }


            }




        return fakeHead.next;


    }

    public Node reverseTheNodes(Node pre, Node last) {

        Node first= pre.next;
        Node second= pre.next.next;

        while(first!=last) {

            Node temp2= first.next;


        }

        return pre;
    }

    public static void main(String[] args) {

        ReverseNodesInKPairs reverseNodesInKPairs = new ReverseNodesInKPairs();

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
        node6.next=node7;

        Node newHead = reverseNodesInKPairs.reverseNodesInKPairs(head, 2);
        ReorderLinkedLists.printList(newHead);



    }

}
