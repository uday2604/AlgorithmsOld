package com.search;

import java.util.Scanner;

/**
 * Created by Uday on 3/20/2016.
 */
public class LinearSearch
{

    public boolean linearSearch(int[] elementArray, int searchElement) {


        for(int i=0;i<elementArray.length;i++)

            if(elementArray[i]==searchElement)
                return true;
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

        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.linearSearch(elementArray, searchNumber));

    }

}
