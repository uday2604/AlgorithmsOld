package com.intuit;

/**
 * Created by Uday on 2016-05-22.
 * String Palindrome: Iterative and Recursive
 */
public class StringPalindrome {

    private boolean isStringPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    private boolean isStringPalindromeMethod2(String string) {
        for (int i = 0; i <= string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStringPalRecursion(String string) {

        if (string.length() == 0 || string.length() == 1)
            return true;

        if (string.charAt(0) == string.charAt(string.length() - 1))
            return isStringPalindrome(string.substring(1, string.length() - 1));

        return false;
    }


    public static void main(String[] args) {

        StringPalindrome stringPalindrome = new StringPalindrome();
        System.out.println(stringPalindrome.isStringPalindrome("madam"));

        System.out.println(stringPalindrome.isStringPalindromeMethod2("madam"));
        System.out.println(stringPalindrome.isStringPalRecursion("madam"));
    }
}
