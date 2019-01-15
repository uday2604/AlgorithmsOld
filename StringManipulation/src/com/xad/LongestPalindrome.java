package com.xad;

/**
 * Created by Uday on 2016-05-10.
 */
public class LongestPalindrome {

    public String longestPalindrome(String inputString) {

        if(inputString.length()==0)
            return null;

        if(inputString.length()==1)
            return inputString;

        String longestPal=inputString.substring(0,1);

        for(int i=0;i<inputString.length();i++) {

            String temp=palindromeWithGivenCenter(inputString, i, i);
            if(temp.length()>longestPal.length())
                longestPal=temp;

            temp=palindromeWithGivenCenter(inputString, i, i+1);
            if(temp.length()>longestPal.length())
                longestPal=temp;

        }

        return longestPal;

    }

    public String palindromeWithGivenCenter(String string, int begin, int end) {

        while(begin>=0 && end<=string.length()-1 && string.charAt(begin)==string.charAt(end)) {

            begin--;
            end++;
        }

        return string.substring(begin+1, end);
    }


    public static void main(String[] args) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String longestPal=longestPalindrome.longestPalindrome("this madam this");
        System.out.println(longestPal);

    }

}
