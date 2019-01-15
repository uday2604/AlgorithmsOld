package com.ea;

import java.util.HashSet;

/**
 * Created by uthota on 7/30/16.
 */
public class HappyNumber {

    public boolean isHappyNumber(int number) {

        HashSet<Integer> integerStore = new HashSet<>();
        while (!integerStore.contains(number)) {

            integerStore.add(number);
            number = getSumOfSquares(number);

            if (number == 1)
                return true;

        }

        return false;
    }


    public int getSumOfSquares(int inputNumber) {

        int result=0;
        int[] splitDigitResult = splitIntegerToDigits(inputNumber);

        for(int num :splitDigitResult) {

            result+=num*num;
        }

        return result;
    }

    public int[] splitIntegerToDigits(int number) {

        String numberString = String.valueOf(number);
        int result[] = new int[numberString.length()];
        int i=0;

       while(number>0) {

           result[i]=number%10;
           number=number/10;
           i++;

       }

        return result;
    }


    public static void main(String[] args) {

        HappyNumber happyNumber= new HappyNumber();
        boolean isHappy = happyNumber.isHappyNumber(43);
        System.out.println("The given number is "+isHappy);

    }

}
