package com.intuit;

/**
 * Created by Uday on 2016-05-26.
 */
class Solution {

    public static int[] moveZeroToRight(int[] array){

        int sizeOfArray = array.length;

        int count=0;

        for(int i=0;i<sizeOfArray;i++) {

            if(array[i]!=0)
                array[count++]=array[i];


            while(count<sizeOfArray)
                array[count++]=0;
        }


        return array;
    }
    public static void main(String[] args) {

        int[] array ={1,0,4,0,5,4,0};

        int[] outputArray=moveZeroToRight(array);
        for(int i=0;i<outputArray.length;i++){
            System.out.print(outputArray[i] +" ");
        }

    }
}

