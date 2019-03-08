package com.paypal;

/**
 * Created by udaypersonal on 9/22/16.
 */
public class LongestPalindrome {


    public static String longestPalindrome(String inputString) {

        if (inputString == null || inputString.length() == 0 || inputString.equals(""))
            return null;

        if (inputString.length() == 1)
            return inputString;

        String longest = inputString.substring(0, 1);
        for (int i = 0; i < inputString.length(); i++) {

            String temp = palindromeHelper(inputString, i, i);
            if (temp.length() > longest.length())
                longest = temp;

            temp = palindromeHelper(inputString, i, i + 1);
            if (temp.length() > longest.length())
                longest = temp;

        }

        return longest;

    }

    public static String palindromeHelper(String string, int begin, int end) {

        while (begin >= 0 && end < string.length() && string.charAt(begin) == string.charAt(end)) {
            begin--;
            end++;
        }

        return string.substring(begin + 1, end);

    }

    public static void main(String[] args) {

        String longestPal = LongestPalindrome.longestPalindrome("madam");
        System.out.println(longestPal);

    }
}
