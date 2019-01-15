package amazon;

/**
 * Created by uthota on 8/14/16.
 */
public class LinkedListPalindrome {

    public Node head;

    static class Node {

        Node next;
        int data;

        Node(int data) {

            this.next=null;
            this.data=data;
        }

    }

    public boolean isLinkedListPalindrome(Node head) {

        if(head==null) {
            System.out.println("No elements in the linked list");
            return false;
        }

        if(head.next==null)
            return true;


        Node slowPointer=head;
        Node fastPointer=head.next;

        while(fastPointer.next!=null) {

            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;

            if(fastPointer.next!=null)
                fastPointer=fastPointer.next;

        }

        Node newHead=slowPointer.next;
        slowPointer.next=null;

        Node headAfterReversing = reverseLinkedList(newHead);

        System.out.println("\nPrinting after reversing: ");
        printNodes(headAfterReversing);

        while(head!=null && headAfterReversing!=null) {

            if(head.data!=headAfterReversing.data)
                return false;

            else {

                head=head.next;
                headAfterReversing=headAfterReversing.next;
            }

        }

        return true;


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


    public void addNode(Node newNode) {

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;


        }
    }


        public void printNodes(Node head) {

            if(head==null)
                System.out.println("No nodes in the linked list");

            else {

                Node temp = head;
                while (temp!=null) {
                    System.out.print(temp.data + " ");
                    temp=temp.next;

                }

            }

    }

    public static void main(String[] args) {

        LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();

        Node headNode = new Node(2);
        linkedListPalindrome.addNode(headNode);

        Node node1 = new Node(2);
        linkedListPalindrome.addNode(node1);

        Node node2 = new Node(4);
        linkedListPalindrome.addNode(node2);

        Node node3 = new Node(4);
        linkedListPalindrome.addNode(node3);

        Node node4 = new Node(3);
        linkedListPalindrome.addNode(node4);

        Node node5 = new Node(2);
        linkedListPalindrome.addNode(node5);

        linkedListPalindrome.printNodes(headNode);

        System.out.println(linkedListPalindrome.isLinkedListPalindrome(headNode));






    }


}
