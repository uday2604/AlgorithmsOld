package com.xad;

import java.util.*;

/**
 * Created by Uday on 2016-07-01.
 */
public class OrderedPairsSum {

    public HashMap<Integer, Integer> findOrderedPairsSum(ArrayList<Integer> inputArrayList, int sum) {

        HashMap<Integer, Integer> outputHashMap = new HashMap<>();
        HashSet<Integer> integerHashSet = new HashSet<>();

        for(int i=0; i<inputArrayList.size(); i++) {

            int requiredSum = sum-inputArrayList.get(i);
            if(sum==requiredSum*2)
                outputHashMap.put(requiredSum, requiredSum);

            if(!integerHashSet.contains(requiredSum))
                integerHashSet.add(inputArrayList.get(i));

            else
                outputHashMap.put(inputArrayList.get(i), requiredSum);



        }

        return outputHashMap;


    }

    public static void main (String[] args) {

        OrderedPairsSum orderedPairsSum = new OrderedPairsSum();
        ArrayList<Integer> inputArrayList = new ArrayList<>();

        inputArrayList.add(3);
        inputArrayList.add(4);
        inputArrayList.add(8);
        inputArrayList.add(7);
        inputArrayList.add(5);
        inputArrayList.add(6);

        HashMap<Integer, Integer> outputHashMap=orderedPairsSum.findOrderedPairsSum(inputArrayList, 11);

        for(Map.Entry<Integer, Integer> entry: outputHashMap.entrySet()) {

            System.out.println(entry.getKey() + ", "+entry.getValue());

        }


    }
}
