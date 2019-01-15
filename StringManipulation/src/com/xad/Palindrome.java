package com.xad;

/**
 * Created by Uday on 2016-05-10.
 */
public class Palindrome {

    public boolean isPalindrome(String inputString) {

        return inputString.equals(new StringBuffer(inputString).reverse().toString());
    }

    public boolean isStringPalindrome(String inputString) {

        if(inputString==null)
            return false;

        for(int i=0;i<=inputString.length()/2;i++)
            if(inputString.charAt(i)!=inputString.charAt(inputString.length()-i-1))
                return false;
        return true;

    }

    public boolean isStringPalRecursion(String string) {

        if(string.length()==0 || string.length()==1)
            return true;

        if(string.charAt(0)==string.charAt(string.length()-1))
            return isStringPalindrome(string.substring(1, string.length()-1));

        return false;

    }

    public static void main (String[] args) {

        Palindrome palindrome= new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome("madam");
        System.out.println(isPalindrome);

        boolean isStringPalindrome=palindrome.isStringPalindrome("why yhw");
        System.out.println("String is palindrome:"+isStringPalindrome);
    }

}
