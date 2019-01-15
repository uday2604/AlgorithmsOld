package com.javapractice;

import java.util.*;

/**
 * Created by Uday on 3/18/2016.
 */
public class SumPairsInArray {

   // Big O(n) - Allowing duplicate pairs
    public HashMap sumPairsInAnArray(int[] arrayList, int sum) {

        ArrayList<Integer> inputArrayList = new ArrayList();

        for(int i=0; i<arrayList.length; i++)
            inputArrayList.add(arrayList[i]);

        HashMap<Integer, Integer> outputHashMap = new HashMap<>();

        for(int i=0; i<inputArrayList.size();i++) {
            int requiredIntegerToCheck=sum-inputArrayList.get(i);

            if(inputArrayList.contains(requiredIntegerToCheck))
                outputHashMap.put(inputArrayList.get(i), requiredIntegerToCheck);

        }

        return outputHashMap;
    }

   //Big O(n^2)
    private HashMap sumPairs(int[] inputArray, int sum) {

        Set<Integer> inputSet = new HashSet(inputArray.length);
        HashMap outputHashMap = new HashMap();

        for( int value: inputArray) {

            int target = sum - value;

            if(!inputSet.contains(target))
                inputSet.add(value);
            else
                outputHashMap.put(value, target);
        }

        return outputHashMap;
    }

    public static void main (String[] args) {

        System.out.println("Enter the sum you want to find the pairs for ");
        Scanner in = new Scanner(System.in);

        int sumNumber= in.nextInt();
        int[] inputArray ={2,3,5,7,8,4,6};
        SumPairsInArray instance = new SumPairsInArray();

        HashMap printMap=instance.sumPairsInAnArray(inputArray, sumNumber);
        System.out.println(printMap);


        HashMap printMap2 = instance.sumPairs(inputArray, sumNumber);
        System.out.println(printMap2);
    }
}
