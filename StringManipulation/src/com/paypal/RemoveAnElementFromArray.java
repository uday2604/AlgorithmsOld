package com.paypal;

/**
 * Created by udaypersonal on 9/18/16.
 */
public class RemoveAnElementFromArray {


   // Returns the length of input array after removing the given element
    public static int removeElementFromArray (int[] inputArray, int removeElement) {

        if(inputArray==null || inputArray.length==0)
            return -1;

        int i=0, j=0;
        while(j!=inputArray.length) {

            if(inputArray[j]!=removeElement) {
                inputArray[i]=inputArray[j];
                i++;

            }

            j++;

        }

        return i;
    }


    // Same as above, but used for loop, nothing else
    public static int removeElementFromGivenArray(int[] inputArray, int removeElement) {


        if(inputArray==null || inputArray.length==0)
            return -1;

        int i=0;

        for(int j=0; j<inputArray.length; j++) {

            if(inputArray[j]!=removeElement) {

                inputArray[i]=inputArray[j];
                i++;

            }

        }
        return i;

    }


    public static void main(String[] args) {

        int[] inputArray = {3, 4, 3, 5, 6, 7, 3};
        int outputArrayLength = RemoveAnElementFromArray.removeElementFromArray(inputArray, 3);
        System.out.println("The length of array after removing given element is "+outputArrayLength);


        int[] inputArray1 = {3, 4, 3, 5, 6, 7, 3};
        System.out.println(RemoveAnElementFromArray.removeElementFromGivenArray(inputArray1, 3));


    }
}
