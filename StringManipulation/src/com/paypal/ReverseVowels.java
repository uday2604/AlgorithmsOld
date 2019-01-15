package com.paypal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by udaypersonal on 9/19/16.
 */
public class ReverseVowels {

    public static String reverseVowels (String inputString) {

        char[] charArray = inputString.toCharArray();

        if(inputString==null || inputString.length()==0)
            return inputString;

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int i=0, j=charArray.length-1;

        while (i<j) {

            if(!vowels.contains(charArray[i])) {
                i++;
                continue;
            }

            if(!vowels.contains(charArray[j])) {
                j--;
                continue;
            }

            char temp = charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;

            i++;
            j--;


        }

        return new String(charArray);

    }



    // Just same as above but without using Array List
    public static String reverseVowels2 (String inputString) {

        if(inputString==null || inputString.length()==0)
            return inputString;

        char[] charArray = inputString.toCharArray();
        String vowels = "aeiouAEIOU";

        int i=0, j=inputString.length()-1;

        while (i<j) {

            if(!vowels.contains(String.valueOf(inputString.charAt(i)))) {
                i++;
                continue;
            }

            if(!vowels.contains(String.valueOf(inputString.charAt(j)))) {
                j--;
                continue;
            }

            char temp = charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;

            i++;
            j--;


        }

        return new String(charArray);

    }


    public static void main(String[] args) {

        String reversedString = ReverseVowels.reverseVowels("Testing");
        System.out.println("After vowel reverse is "+reversedString);


    }

}
