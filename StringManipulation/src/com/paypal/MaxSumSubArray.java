package com.paypal;

/**
 * Created by udaypersonal on 9/22/16.
 */
public class MaxSumSubArray {

    public static int maxSubArray(int[] inputArray) {

        if(inputArray==null || inputArray.length==0)
            return -1;

        int max = inputArray[0];
        int[] sum = new int[inputArray.length];
        sum[0]=inputArray[0];

        for (int i=1; i<inputArray.length;i++) {
            sum[i] = Math.max(inputArray[i], sum[i-1]+inputArray[i]);
            max=Math.max(sum[i], max);

        }
        return max;

    }


    public static void main(String[] args) {

        int maxSum = MaxSumSubArray.maxSubArray(new int[] {-1, -2, 5, 6, 4, -3, -4});
        System.out.println("The maximum sum is "+maxSum);

    }
}
