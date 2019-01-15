package com.paypal;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class PowerOfANumber {

    public static double pow(double number, int power) {
        double result = 1;

        while (power > 0) {
            if (power % 2 != 0) {
                result = result * number;
            }

            number = number * number;
            power = power / 2;
        }

        return result;
    }

    public static double powOfNumber(double number, int power) {
        double result = 1;

        for(int i=0; i<power; i++) {

            result = result *number;
        }

        return result;
    }

    public static void main(String[] args) {

        double result = PowerOfANumber.pow(33,3);
        System.out.println(result);

        double result1 = PowerOfANumber.powOfNumber(33,3);
        System.out.println(result1);

    }
}
