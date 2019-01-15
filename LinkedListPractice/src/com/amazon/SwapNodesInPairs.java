package com.amazon;

/**
 * Created by udaypersonal on 8/30/16.
 */
public class SwapNodesInPairs {


    /*public Node swapNodesInPairs(Node head) {

        if(head==null || head.next==null)
            return head;

        Node current= head;
        Node nextNode = head.next;

        while(current!=null) {

            Node temp = nextNode.next;
            nextNode.next=current;


        }





    }

*/


    public static void main(String[] args) {

        // First Linked List
        Node head1= new Node(1);
        Node nodex= new Node(2);
        Node nodex1= new Node(3);
        Node nodex2= new Node(4);
        Node nodex3= new Node(5);
        Node nodex4= new Node(6);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
      //  Node headAfterSwapping = swapNodesInPairs.swapNodesInPairs(head1);
       // ReorderLinkedLists.printList(headAfterSwapping);

    }

}
