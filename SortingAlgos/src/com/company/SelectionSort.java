package com.company;

/**
 * Created by Uday on 3/20/2016.
 */
public class SelectionSort {

    // In each of the iteration, one element gets sorted
    // The inner for loop is used to get the minimum index at each iteration
    // The outer loop is used to swap the element at min index with corresponding ith element (1st element in 1st iteration, 2ne element in 2nd iteration so on)

    public int[] doSelectionSort(int[] searchArray) {

        for(int i=0;i<searchArray.length;i++) {

            int minIndex=i;

            for(int j=i+1;j<searchArray.length-1;j++) {

                if(searchArray[j] <searchArray[minIndex])
                    minIndex=j;

            }

            int temp=searchArray[i];
            searchArray[i]=searchArray[minIndex];
            searchArray[minIndex]=temp;
        }

        return searchArray;

    }

    public static void main(String[] args) {

        int[] inputArray={3,6,2,2,8,5,9,4,8};

        System.out.println("Before Sort ");
        for(int num: inputArray)
            System.out.print(num + " ");

        SelectionSort selInstance= new SelectionSort();

        System.out.println("\nAfter Sort: ");
        int[] outputArray= selInstance.doSelectionSort(inputArray);

        for(int i=0;i<outputArray.length;i++)
            System.out.print(outputArray[i]+ " ");


    }


}
