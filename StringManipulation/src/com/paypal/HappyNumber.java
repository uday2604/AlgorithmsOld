package com.paypal;

import com.xad.HappyNum;

import java.util.HashSet;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class HappyNumber {

    public static boolean isHappyNumber(int number) {

        if(number<=0)
            return false;

        HashSet<Integer> numStore = new HashSet<>();

        while (!numStore.contains(number)) {
            numStore.add(number);
            int getDigitSum = getSumOfDigits(number);

            if(number==1)
                return true;

        }
        return false;

    }

    public static int getSumOfDigits(int number) {

        int sumOfDigits=0;

        while (number!=0) {

            int mod = number%10;
            sumOfDigits+=mod*mod;
            number=number/10;

        }

        return sumOfDigits;
    }


    public static void main(String[] args) {

       boolean isHappy= HappyNum.isHappyNumber(19);
        System.out.println(isHappy);

    }
}
