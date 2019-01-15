package com.amazon;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by udaypersonal on 9/11/16.
 */
public class FindKthLargest {

    public int findKthLargest (int[] integerArray, int k) {

        PriorityQueue<Integer> highestElements = new PriorityQueue<>(k);

        for (Integer num : integerArray) {
            highestElements.offer(num);

            if (highestElements.size() > k)
                highestElements.poll();

        }
        return highestElements.peek();

    }

    public static void main(String[] args) {

        FindKthLargest findKthLargest = new FindKthLargest();
        int kthHighest=findKthLargest.findKthLargest(new int[] {3, 5, 1, 11, 7, 8, 4}, 3);
        System.out.println(kthHighest);

    }
}
