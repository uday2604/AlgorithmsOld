package com.vest;

/**
 * Created by Uday on 2016-05-15.
 */
public class LongestPalindrome {

    public String longestPalindrome(String string) {
        if(string==null)
            return null;
        if(string.length()==1)
            return string;

        String longestPalindrome=string.substring(0,1);

        for(int i=0;i<string.length();i++) {

            String temp = palindromeHelper(string, i, i);
            if(temp.length()>longestPalindrome.length())
                longestPalindrome=temp;

            temp=palindromeHelper(string, i, i+1);
            if(temp.length()>longestPalindrome.length())
                longestPalindrome=temp;

        }
        return longestPalindrome;

    }

    public String palindromeHelper(String inputString, int begin, int end) {

        while(begin>=0 && end<=inputString.length()-1 && inputString.charAt(begin)==inputString.charAt(end)) {
            begin--;
            end++;
        }
        return inputString.substring(begin+1, end);

    }

    public static void main(String[] args) {

        LongestPalindrome longestPalindrome= new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("uday"));
    }
}
