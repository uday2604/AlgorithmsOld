package com.vest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Uday on 2016-05-15.
 */
public class StringAnagrams {

    public boolean stringAnagrams(String inputString1, String inputString2) {

        if(inputString1.equals(null) || inputString2.equals(null) || inputString1.length()!=inputString1.length())
            return false;

        char[] charArray1=inputString1.toCharArray();
        char[] charArray2= inputString2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public boolean stringAnagramsWithoutSorting(String inputString1, String inputString2) {

        if(inputString1.equals(null) || inputString2.equals(null) || inputString1.length()!=inputString1.length())
            return false;

        char[] outputCharArray= new char[26];

        for(int i=0;i<inputString1.length();i++) {

            outputCharArray[inputString1.charAt(i)-97]++;
            outputCharArray[inputString2.charAt(i)-97]--;
        }

        for(int i=0;i<26;i++)
            if(outputCharArray[i]!=0)
                return false;
            return true;

    }


    public static void main(String[] args) {

        StringAnagrams stringAnagrams = new StringAnagrams();
        System.out.println(stringAnagrams.stringAnagrams("uday", "yaua"));

        System.out.println(stringAnagrams.stringAnagramsWithoutSorting("uday", "yaua"));

    }
}
