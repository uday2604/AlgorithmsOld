package com.amazon;

import java.util.*;

/**
 * Created by udaypersonal on 9/6/16.
 */
public class SimpleArraysPractice {

    public static void ArrayManipulation (Integer[] integerArray, int[] primitiveArray) {


        // Method 1
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < integerArray.length; i++)
            list.add(Integer.valueOf(integerArray[i]));

        System.out.println(list);


        // Method 2
        ArrayList<Integer> testList = new ArrayList<Integer>(Arrays.asList(integerArray));
        System.out.println(testList);

        testList.add(6);
        System.out.println("After adding the test list is: "+testList);


        // Always try looping the list through iterator (Mainly when modifying the values)
        System.out.println("Printing the list through iterator: ");
        Iterator<Integer> listIterator = testList.iterator();
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next()+" ");

        }


        // Deleting a value is list (using Iterator)
        Iterator<Integer> listIterator2 = testList.iterator();
        while(listIterator2.hasNext()) {

            Integer deleteValue = listIterator2.next();

            if(deleteValue.equals(6))
                listIterator2.remove();

        }

        System.out.println("\nAfter deleting value from list using iterator: " +testList);


       // Converting list to array and then printing
        Integer[] listToArray= testList.toArray(new Integer[testList.size()]);
        System.out.println(Arrays.toString(listToArray));


        // Primitive Arrays
        System.out.println(Arrays.toString(primitiveArray));



    }


    public static void main(String[] args) {


        Integer[] testArray ={1, 2, 3, 4, 5};

        String[] testArray2;
        testArray2 = new String[] {"This", "is", "cool"};

        int[] testArray3 = {6, 7, 8, 9};

        SimpleArraysPractice.ArrayManipulation(testArray, testArray3);

        Integer[][] testArray4 ={{2, 3}, {4, 5}, {9,8,3}};
        List<Integer> testList = new ArrayList<Integer>();

        for(int i=0; i<testArray4.length; i++) {

            for(int j=0; j<testArray4[i].length;j++)
                testList.add(Integer.valueOf(testArray4[i][j]));
        }


        Collections.sort(testList);
        System.out.println(testList);

    }


}
