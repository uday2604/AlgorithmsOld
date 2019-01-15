package com.javapractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Uday on 3/17/2016.
 */
public class DuplicatesInString {

    public HashMap calculateDuplicates(String str) {

        HashMap<Character, Integer> duplicateCountHashMap = new LinkedHashMap<>();
        for(int i=0; i<=str.length()-1;i++) {

            if(duplicateCountHashMap.get(str.charAt(i))==null)
                duplicateCountHashMap.put(str.charAt(i), 1);

            else
                duplicateCountHashMap.put(str.charAt(i), duplicateCountHashMap.get(str.charAt(i))+1);

        }

        return  duplicateCountHashMap;

    }



    public static void main(String[] args) {

        System.out.println("Enter a string to know the duplicate characters");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        DuplicatesInString dus = new DuplicatesInString();
        HashMap<Character, Integer> outputHashMap=dus.calculateDuplicates(inputString);
//        System.out.println(outputHashMap);

        for(Map.Entry<Character, Integer> entry : outputHashMap.entrySet()) {

            System.out.println("The character " + entry.getKey() + " is repeated "+ entry.getValue()+" number of times");

        }
    }

}
