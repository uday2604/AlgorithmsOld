package com.practice;

import java.util.EmptyStackException;

/**
 * Created by Uday on 2016-05-08.
 */
public class StackImplementationUsingLinkedLists {

    private Node head;
    Node stackTop=null;
    int length=0;

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;

        }
    }


    public void push(int data) {

        Node newNode = new Node(data);
        newNode.next=stackTop;
        stackTop=newNode;
        length++;
    }

    public int pop() {

        if(stackTop==null) {
            throw  new EmptyStackException();
        }
        else {

            int data = stackTop.data;
            stackTop=stackTop.next;
            length--;
            return data;
        }


    }

    public int peek() {

        if(stackTop==null) {
            throw  new EmptyStackException();
        }
        else {
            int data = stackTop.data;
            return data;
        }

    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {

        if(length==0)
            return true;
        return false;
    }

    public String toString() {

        String result="";
        Node temp=stackTop;

        while(temp!=null) {
            result+=temp.data + " ";
            temp=temp.next;
        }

        return result;
    }


    public static void main(String[] args) {

        StackImplementationUsingLinkedLists stackImplementationUsingLinkedLists= new StackImplementationUsingLinkedLists();
        stackImplementationUsingLinkedLists.push(3);
        stackImplementationUsingLinkedLists.push(4);
        stackImplementationUsingLinkedLists.push(5);
        stackImplementationUsingLinkedLists.push(6);
        stackImplementationUsingLinkedLists.push(7);

        System.out.println(stackImplementationUsingLinkedLists.toString());

        stackImplementationUsingLinkedLists.pop();
        System.out.println(stackImplementationUsingLinkedLists.toString());

    }
}
