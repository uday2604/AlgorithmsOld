package com.xad;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Uday on 2016-05-10.
 */
public class MaxCountString {

    static int maxCount=0;
    int charCount=0;

    public HashMap highestCharacterCount(String inputString) {


        inputString=inputString.replace(" ", "");

        HashMap<Character, Integer> outputHashMap = new HashMap<>();

        for(int i=0;i<inputString.length();i++) {

            if(!outputHashMap.containsKey(inputString.charAt(i)))
                outputHashMap.put(inputString.charAt(i), 1);

            else {
                outputHashMap.put(inputString.charAt(i), outputHashMap.get(inputString.charAt(i))+1);
            }

            charCount=outputHashMap.get(inputString.charAt(i));
            if(charCount>maxCount)
                maxCount=charCount;

        }
        return outputHashMap;

    }

    public static void main(String[] args) {

        MaxCountString maxCountString= new MaxCountString();
        HashMap<Character, Integer>outputMap = maxCountString.highestCharacterCount("This is crazy this");

        for(Map.Entry<Character, Integer> entry : outputMap.entrySet()) {

           if(maxCount==entry.getValue())
               System.out.println(entry.getKey()+ " ");

        }


    }
}
