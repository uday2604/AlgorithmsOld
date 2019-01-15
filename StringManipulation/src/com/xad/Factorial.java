package com.xad;

/**
 * Created by Uday on 2016-05-10.
 */
public class Factorial {

    public int factorial(int number) {

        if(number==0)
            return 1;

        else return number*factorial(number-1);
    }

    public int getFactorial(int number) {

        if(number==0)
            return 1;

        int result=1;

        while(number!=1) {

            result*=number;
            number--;
        }
        return result;

    }

    public static void main(String[] args) {

        Factorial factorial= new Factorial();
        System.out.println(factorial.factorial(5));

        System.out.println(factorial.getFactorial(5));
    }
}
