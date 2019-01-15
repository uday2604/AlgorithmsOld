package com.paypal;

import java.util.Arrays;

/**
 * Created by udaypersonal on 9/18/16.
 */
public class MoveZeroesToEnd {

    // First put all non zero elements in place (move to first) and then make all zeroes for remaining elements
    public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;

        while(j<nums.length){
            if(nums[j]==0){
                j++;
            }else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }

        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }

    public static void main(String[] args) {

        int[] inputArray=new int[] {3, 0, 1, 0, 0, 5, 12};
        MoveZeroesToEnd.moveZeroes(inputArray);
        System.out.println(Arrays.toString(inputArray));

    }

}
