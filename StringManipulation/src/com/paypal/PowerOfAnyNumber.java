package com.paypal;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class PowerOfAnyNumber {


    // Not efficient
    public static double powerOfAnyNumber(int number, int power) {

        if(power==0)
            return 1;

        return number*powerOfAnyNumber(number, --power);

    }

    public static double powerOfNumberRecursive(int base, int exponent) {

        if(exponent==0)
            return 1;

        if(exponent==1)
            return base;

        if(exponent%2==0) {
            double half = powerOfNumberRecursive(base, exponent/2);
            return half*half;
        }
        else {
            double half = powerOfNumberRecursive(base, (exponent-1)/2);
            return base*half*half;
        }


    }


    public static void main(String[] args) {

        double result = PowerOfAnyNumber.powerOfAnyNumber(3,10);
        System.out.println(result);

        double result1 = PowerOfAnyNumber.powerOfNumberRecursive(3,10);
        System.out.println(result1);

    }
}
