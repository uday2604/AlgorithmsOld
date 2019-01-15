package com.practice.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Uday on 2016-05-09.
 */
public class StackUsingQueues {

    Queue<Integer> queue1=new LinkedList<Integer>();
    Queue<Integer> temp= new LinkedList<Integer>();

    public void push(int data) {

        if(queue1.size()==0)
            queue1.offer(data);

        else {

            int sizeOfQueue=queue1.size();

            // Move all the elements from queue1 to temp
            for(int i=0;i<sizeOfQueue;i++)
                temp.offer(queue1.poll());

            // Add data in queue1
            queue1.offer(data);

            // Move all the elements back from temp to queue1
            for(int i=0;i<sizeOfQueue;i++)
                queue1.offer(temp.poll());

        }

    }

    public int pop() throws NoSuchMethodException {
        if(queue1.isEmpty())
            throw new NoSuchMethodException("No elements in queue");

        else
            return queue1.poll();

    }


    public static void main(String[] args) throws NoSuchMethodException {

        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(3);
        stackUsingQueues.push(4);
        stackUsingQueues.push(5);
        stackUsingQueues.push(6);
        stackUsingQueues.push(7);

        int firstPop=stackUsingQueues.pop();
        System.out.println("Popped data is "+firstPop);


    }
}
