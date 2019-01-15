package com.amazon.stringmanipulation;

import java.util.Arrays;

/**
 * Created by udaypersonal on 9/11/16.
 */
public class MergeTwoSortedArrays {


   // Compact version, see the below method if trouble in understanding
    public static int[] mergeTwoSortedArraysCompact (int[] inputArray1, int[] inputArray2) {

        if(inputArray1==null && inputArray2==null)
            return null;

        int[] resultArray = new int[inputArray1.length+inputArray2.length];
        int i=0, j=0, k=0;

        while (i<inputArray1.length && j<inputArray2.length) {

            if (inputArray1[i] < inputArray2[j])
                resultArray[k++] = inputArray1[i++];

            else
                resultArray[k++] = inputArray2[j++];
        }

        while (i<inputArray1.length)
            resultArray[k++]=inputArray1[i++];


        while (i<inputArray1.length)
            resultArray[k++]=inputArray1[j++];


        return resultArray;

    }


   // Same logic as above, but not compact
    public static int[] mergeTwoSortedArrays (int[] inputArray1, int[] inputArray2) {

       if(inputArray1==null && inputArray2==null)
           return null;

        int[] resultArray = new int[inputArray1.length+inputArray2.length];
        int i=0, j=0, k=0;

       while (i<inputArray1.length && j<inputArray2.length) {

           if(inputArray1[i] <inputArray2[j]) {
               resultArray[k]=inputArray1[i];
               i++;
           }

           else {
               resultArray[k]=inputArray2[j];
               j++;
           }
           k++;

       }

       while (i<inputArray1.length) {
           resultArray[k++]=inputArray1[i++];
       }
        while (i<inputArray1.length) {
            resultArray[k++]=inputArray1[j++];
        }

       return resultArray;

   }


    // In Place Merge Sort : Assuming first array has extra space
    public static void merge(int A[], int m, int B[], int n) {

        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }

        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }


    public static void main(String[] args) {


        int[] inputArray1 ={1, 5, 10, 15, 20, 30};
        int[] inputArray2={2, 4, 11, 17};


        int[] resultArray=MergeTwoSortedArrays.mergeTwoSortedArrays(inputArray1, inputArray2);
        System.out.println(Arrays.toString(resultArray));


       // In Place Method Test
        int[] input1= new int[10];
        for(int i=0 ;i<inputArray1.length; i++)
            input1[i]=inputArray1[i];

        int[] input2={2, 4, 11, 17};

        MergeTwoSortedArrays.merge(input1,6, input2, 4);
        System.out.println(Arrays.toString(input1));


    }



}
