package com.practice.queues;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-08.
 */
public class QueueUsingTwoStacks {

    Stack<Integer> stack1= new Stack<>();
    Stack<Integer> stack2= new Stack<>();

    public void enQueue(int data) {

        stack1.push(data);
    }

    public int deQueue() {

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        }
        return stack2.pop();
    }

    public String toString(){

        String result="";
        while(!stack2.isEmpty()) {
            result+=stack2.pop()+ " ";
        }
        return result;
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks queueUsingTwoStacksInstance = new QueueUsingTwoStacks();
        queueUsingTwoStacksInstance.enQueue(3);
        queueUsingTwoStacksInstance.enQueue(4);
        queueUsingTwoStacksInstance.enQueue(5);
        queueUsingTwoStacksInstance.enQueue(6);
        queueUsingTwoStacksInstance.enQueue(7);

        System.out.println(queueUsingTwoStacksInstance.toString());

        int deQueue1=queueUsingTwoStacksInstance.deQueue();
        System.out.println("The first de queued data is "+deQueue1);

    }

}
