package com.vest;

/**
 * Created by Uday on 2016-05-15.
 */
public class Palindrome {

    public boolean isStringPalindrome(String string) {

        return string.equals(new StringBuffer(string).reverse().toString());
    }

    public boolean isStringPalindromeMethod2(String string) {

        if(string==null)
            return false;

        if(string.length()==1)
            return true;


        for(int i=0;i<string.length()/2;i++) {

            if(string.charAt(i)!=string.charAt(string.length()-i-1))
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
       /* boolean isPalindrome=palindrome.isStringPalindrome("madam");
        System.out.println("String palindrome "+isPalindrome);
*/
        boolean isStringPalindrome=palindrome.isStringPalindromeMethod2("madam");
        System.out.println("Is String palindrome: "+isStringPalindrome);

    }
}
