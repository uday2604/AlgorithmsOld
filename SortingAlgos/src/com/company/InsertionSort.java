package com.company;

import java.util.Arrays;

/**
 * Created by Uday on 3/20/2016.
 */

public class InsertionSort {

    public int[] insertionSort(int[] inputArray) {

        for (int i = 1; i < inputArray.length; i++) {

            int elementToSort = inputArray[i];
            int j = i;

            while (j > 0 && inputArray[j - 1] > elementToSort) {

                inputArray[j] = inputArray[j - 1];
                j--;
            }

            inputArray[j] = elementToSort;

        }

        return inputArray;

    }

    public static void main(String[] args) {

        int[] inputArray={3,6,2,2,8,5,9,4,8};

        System.out.println("Before Sort ");
        for(int num: inputArray)
            System.out.print(num + " ");

        InsertionSort inInstance= new InsertionSort();

        System.out.println("\nAfter Sort: ");
        int[] outputArray= inInstance.insertionSort(inputArray);

        System.out.println(Arrays.toString(outputArray));


    }
}

