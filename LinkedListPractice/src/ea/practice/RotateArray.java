package ea.practice;

import java.util.Arrays;

/**
 * Created by udaypersonal on 9/4/16.
 */


public class RotateArray {

    public int[] rotateArray(int[] inputArray, int rotateOrder) {

        if(inputArray==null || rotateOrder<0)
            return null;

        if(rotateOrder>inputArray.length)
            rotateOrder= rotateOrder%inputArray.length;


        int firstListLength= inputArray.length-rotateOrder;

        // First reverse the first sub list, then second sub list and then the whole list
        reverse(inputArray, 0, firstListLength-1);
        reverse(inputArray, firstListLength, inputArray.length-1);
        reverse(inputArray, 0, inputArray.length-1);


        return inputArray;

    }

    public static void reverse(int[] input, int start, int end) {

        while(start<end) {

            int temp;
            temp=input[end];
            input[end]=input[start];
            input[start]=temp;

            start++;
            end--;


        }

    }


    public static void main(String[] args) {


        RotateArray rotateArray = new RotateArray();
        int[] inputArray = new int[] {1, 2, 3, 4, 5, 6 ,7};

        int[] outputArray=rotateArray.rotateArray(inputArray, 3);

        // Don't forget the way to print an array =D
        System.out.println("The array after rotating is: "+ Arrays.toString(outputArray));


    }


}
