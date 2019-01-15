package com.sort;

import java.util.Scanner;

/**
 * Created by Uday on 3/20/2016.
 */
public class BubbleSort {

    public int[] bubbleSort(int[] inputArray) {

        for(int i=0; i<inputArray.length-1;i++) {
            for(int j=i+1; j<inputArray.length;j++) {

                if(inputArray[i]>inputArray[j]) {

                    int temp = inputArray[i];
                    inputArray[i] =inputArray[j];
                    inputArray[j] = temp;
                }

            }

        }

        return inputArray;

    }


    public static void main(String[] args) {

        int[] searchArray ={3, 8, 1,1, 4, 7,4, 9, 6, 12};

        System.out.println("Before Sorting: ");
        for(int i=0;i<searchArray.length;i++)
            System.out.print(searchArray[i]+ " ");

        BubbleSort bubbleSort = new BubbleSort();
        int[] outputArray=bubbleSort.bubbleSort(searchArray);
        System.out.println("\nAfter Sorting: ");
        for(int i=0;i<outputArray.length;i++) {

            System.out.print(outputArray[i]+" ");
        }
    }
}
