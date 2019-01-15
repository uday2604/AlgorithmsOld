package ea.practice;

/**
 * Created by uthota on 7/26/16.
 */
public class ReverseLinkedList {

    private Node head;

       private static class Node {

           private Node next;
           private int data;

           Node(int data) {

               this.data=data;
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

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseLinkedList(Node head) {

        if(head!=null) {

            reverseLinkedList(head.next);
            System.out.print(head.data + " ");
        }

    }

    public Node reverseLinkedListIterative(Node head) {

        Node previous = null;
        Node current = head;
        Node nextNode;

        while(current!=null) {

            nextNode=current.next;
            current.next=previous;
            previous=current;
            current=nextNode;

        }

        return previous;



    }

    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        reverseLinkedList.addToTheLast(head);
        reverseLinkedList.addToTheLast(node2);
        reverseLinkedList.addToTheLast(node3);
        reverseLinkedList.addToTheLast(node4);
        reverseLinkedList.addToTheLast(node5);

        reverseLinkedList.printList(head);

        System.out.println("Reversing through Recursive Approach: ");
        reverseLinkedList.reverseLinkedList(head);

        System.out.println("\nReversing through Non Recursive Approach: ");
        Node reversedHead = reverseLinkedList.reverseLinkedListIterative(head);
        reverseLinkedList.printList(reversedHead);



    }


}
