package com.search;

import java.util.Scanner;

public class BinarySearch {

    // Array Elements to be in sorted order only
    public boolean binarySearch(int[] elementArray, int searchElement) {

        int first =0;
        int last = elementArray.length-1;



        while(first<=last) {

            int middle = (first+last)/2;

            if(elementArray[middle]==searchElement) {
                System.out.println("Element found at "+ (middle+1) + " position");
                return true;
            }

            else if(elementArray[middle]>searchElement)
                last=middle-1;

            else
                first = middle+1;

        }

        if(first>last) {
            System.out.println("Element not found in given array");
        }

        return false;
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter the number of elements in an array");
        int numberOfElements = scanner.nextInt();
        int[] elementArray = new int[numberOfElements];

        for(int i=0;i<numberOfElements;i++) {
            System.out.println("Enter the "+ (i+1) + " the element");
            elementArray[i]=scanner.nextInt();
        }

        System.out.println("Enter the search element to be found in an array");
        int searchNumber = scanner.nextInt();

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearch(elementArray, searchNumber);

    }
}
