package com.amazon;

import java.util.HashMap;

/**
 * Created by udaypersonal on 9/4/16.
 */
public class LRUCache {

   static class Node {

       Node pre;
       Node next;
       int key;
       int value;

       public Node(int key, int value) {
           this.key=key;
           this.value=value;
       }


   }

    int capacity;
    Node head=null;
    Node end=null;
    HashMap<Integer, Node> nodeStoreMap = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity=capacity;

    }

    public void setHead (Node temp) {

        if(head==null) {
            head = temp;
            end=temp;
        }

        else {

            temp.next=head;
            temp.pre=null;

            head.pre=temp;
            head=temp;

        }
    }



    public void remove (Node removeNode) {

        if(removeNode.pre!=null) {

            removeNode.pre.next=removeNode.next;
        }
        else {
            head=removeNode.next;
        }

        if(removeNode.next!=null) {
            removeNode.next.pre=removeNode.pre;
        }
        else {
            end=removeNode.pre;
            removeNode.pre.next=null;
        }

    }

    public int get (int key) {

        if(nodeStoreMap.containsKey(key)) {

            Node temp = nodeStoreMap.get(key);
            remove(temp);
            setHead(temp);
            return  temp.value;

        }
        return -1;

    }

    public void set (int key, int value) {

        if(nodeStoreMap.containsKey(key)) {

            Node getNodeValue = nodeStoreMap.get(key);
            if(getNodeValue.value!=value)
                getNodeValue.value=value;

            remove(getNodeValue);
            setHead(getNodeValue);
        }

        else {

            Node newNode = new Node(key, value);
            if(nodeStoreMap.size()>=capacity) {
                nodeStoreMap.remove(end.key);
                remove(end);
                setHead(newNode);
            }

            else {
                setHead(newNode);
            }

            nodeStoreMap.put(key, newNode);

        }


    }

    public void printNodes (Node head) {

        if(head==null)
            System.out.println("No nodes in the list");

        else {

            Node current = head;
            while(current!=null) {

                System.out.print(current.value+" ");
                current=current.next;

            }
        }

    }



    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 5);
        lruCache.set(2, 6);
        lruCache.set(3, 7);

        lruCache.set(4, 8);
        int nodeValue =lruCache.get(2);
        System.out.println("The node value for corresponding key is "+nodeValue);

        int nodeValue2 = lruCache.get(3);
        System.out.println("The node value for corresponding key is "+nodeValue2);

        lruCache.set(5, 9);
        int nodeValue3=lruCache.get(4);
        System.out.println("The node value for corresponding key is "+nodeValue3);





}



}
