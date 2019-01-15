package com.sort;

/**
 * Created by Uday on 2016-05-16.
 */
public class InsertionSort {

    public int[] insertionSort(int[] inputArray) {

        for(int i=1;i<inputArray.length;i++) {

            for(int j=i;j>0;j--) {

                if(inputArray[j]<inputArray[j-1]) {
                    int temp=inputArray[j];
                    inputArray[j]=inputArray[j-1];
                    inputArray[j-1]=temp;
                }

            }
        }
        return inputArray;

    }


    public static void main(String[] args) {

        InsertionSort insertionSort = new InsertionSort();
        int[] inputArray={9, 1, 4, 3, 6, 11, 10};

        int[] outputArray=insertionSort.insertionSort(inputArray);

        for(int i=0;i<outputArray.length;i++)
            System.out.print(outputArray[i]+" ");

    }
}
