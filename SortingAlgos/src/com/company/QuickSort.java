package com.company;

import java.util.Arrays;

/**
 * Created by Uday on 3/20/2016.
 */

public class QuickSort {


    public int[] quickSortAndPartition(int[] inputArray, int lowIndex, int highIndex) {

        int leftPointer=lowIndex;
        int rightPointer= highIndex;

        //int middle = leftPointer+(rightPointer-leftPointer) /2;
        //int pivot = inputArray[middle];

        int pivot = inputArray[(leftPointer+rightPointer)/2];

        while(leftPointer<=rightPointer) {

            while(inputArray[leftPointer]<pivot)
                leftPointer++;

            while(inputArray[rightPointer]>pivot)
                rightPointer--;

            if(leftPointer<=rightPointer) {

                int temp = inputArray[leftPointer];
                inputArray[leftPointer]=inputArray[rightPointer];
                inputArray[rightPointer]=temp;

                leftPointer++;
                rightPointer--;
            }
        }

        if(lowIndex<rightPointer) {
            quickSortAndPartition(inputArray, lowIndex, rightPointer);
        }

        if(leftPointer<highIndex) {
            quickSortAndPartition(inputArray, leftPointer, highIndex);
        }

        return inputArray;
    }

    public static void main(String[] args) {

        int[] inputArray={7,9,4,3,8,6,5};

        System.out.println("Before Sort ");
        for(int num: inputArray)
            System.out.print(num + " ");

        QuickSort quickInstance= new QuickSort();

        System.out.println("\nAfter Sort: ");
        int[] outputArray= quickInstance.quickSortAndPartition(inputArray, 0, inputArray.length-1);

        System.out.println(Arrays.toString(outputArray));


    }

}
