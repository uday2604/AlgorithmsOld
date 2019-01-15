package com.amazon.stringmanipulation;
import java.util.*;

/**
 * Created by udaypersonal on 9/11/16.
 */
public class ReturnIndexesOfSum {

    public static int[] returnSumIndices(int[] inputArray, int sum) {

        if(inputArray==null || inputArray.length==0)
            return inputArray;

        HashMap<Integer, Integer> outputMap = new HashMap<>();
        int[] outputArray = new int[2];

        for(int i=0; i<inputArray.length; i++) {

            if(!outputMap.containsKey(inputArray[i]))
                outputMap.put(sum-inputArray[i], i);

            else {

                int index = outputMap.get(inputArray[i]);
                outputArray[0]=index;
                outputArray[1]=i;

            }


        }

            return outputArray;
    }

    public static HashMap sumPairsInArray (Integer[] inputArray, int target) {

        HashMap <Integer, Integer> outputMap = new HashMap<>();

        if(inputArray==null || inputArray.length==0)
                    return outputMap;

        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(inputArray));

        for(int i=0; i<inputList.size(); i++) {

            int requiredValue = target-inputArray[i];

            if(inputList.contains(requiredValue))
                outputMap.put(inputArray[i], requiredValue);

        }

        return outputMap;

    }


    public static HashMap sumPairsInArray2 (Integer[] inputArray, int target) {

        HashMap <Integer, Integer> outputMap = new HashMap<>();

        if(inputArray==null || inputArray.length==0)
            return outputMap;

        HashSet<Integer> tempSet =new HashSet<>(inputArray.length);

        for(int i=0; i<inputArray.length; i++) {

            if(!tempSet.contains(inputArray[i]))
                tempSet.add(target-inputArray[i]);

            else
                outputMap.put(inputArray[i], target-inputArray[i]);

        }

        return outputMap;

    }


    // return indices of two numbers with corresponding sum when array is SORTED
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                i++;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i , j  };
            }
        }

        return null;
    }



    public static void main(String[] args) {

        int[] result =ReturnIndexesOfSum.returnSumIndices(new int[] {3, 1, 10, 6, 4, 5, 9, 2}, 7);
        System.out.println(Arrays.toString(result));


        HashMap outputMap = ReturnIndexesOfSum.sumPairsInArray(new Integer[] {3, 1, 10, 6, 4, 5, 9, 2}, 7);

        Iterator<Map.Entry> it = outputMap.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry entryObject = it.next();
            System.out.println(entryObject.getKey()+","+entryObject.getValue());
        }


        System.out.println("Without duplicates: ");

        HashMap<Integer, Integer> outputMap2 = ReturnIndexesOfSum.sumPairsInArray2(new Integer[] {3, 1, 10, 6, 4, 5, 9, 2}, 7);
        for(Map.Entry<Integer, Integer> entry : outputMap2.entrySet()) {

            System.out.print(entry.getKey()+","+entry.getValue()+"  ");

        }


        int[] outputArray = ReturnIndexesOfSum.twoSum(new int[] {3, 5, 7, 8, 9, 10, 11, 15, 19 }, 19);
        System.out.println(Arrays.toString(outputArray));


    }
}
