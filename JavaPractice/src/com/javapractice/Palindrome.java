package com.javapractice;

import java.util.Scanner;

/**
 * Created by Uday on 3/17/2016.
 */
public class Palindrome {

    public boolean palindromeMethod1(String str) {

        int end=str.length();

        for(int i=0; i<end/2;i++) {
            if(str.charAt(i)!=str.charAt(end-i-1))
            return false;
        }
        return true;



    }

    public boolean palindromeMethod2(String str) {

        return str.equals(new StringBuffer(str).reverse().toString());
    }

    public static void main(String[] args) {

        System.out.println("Enter a string to check Palindrome");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        Palindrome palInstance = new Palindrome();
        boolean isPalindrome=palInstance.palindromeMethod1(inputString);
        System.out.println(isPalindrome);

        Palindrome palInstance2= new Palindrome();
        boolean isPalindromeVerify= palInstance2.palindromeMethod2(inputString);
        System.out.println(isPalindromeVerify);





    }
}

