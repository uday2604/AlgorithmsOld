package com.paypal;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class IntegerPalindrome {

    public static boolean isPalindrome (int num) {

        if(num<0 || num==0)
            return false;

        if(num ==reverseNumber(num))
            return true;

        return false;

    }

    public static int reverseNumber(int number) {

        boolean flag=false;
        int result=0;

        if(number<0)
            flag=true;

        while (number!=0) {

            int mod = number%10;
            number=number/10;

            result=result*10+mod;

        }

        if(flag==true)
        result=-result;

        return result;

    }


    public static void main(String[] args) {

        boolean isTrue = isPalindrome(343);
        System.out.println("Is number palindrome: "+isTrue);


    }

}
