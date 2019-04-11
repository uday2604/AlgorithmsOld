package com.intuit;

/**
 * Created by Uday on 2016-05-22.
 * Fibonacci series - iterative and recursive
 */
public class Factorial {

    private int factorial(int number) {
        int result = 1;
        if (number == 0 || number == 1)
            return result;

        while (number != 1) {
            result *= number;
            number--;
        }
        return result;
    }

    private int findFactorial(int number) {
        if (number == 0 || number == 1)
            return 1;
        else {
            return number * factorial(number - 1);
        }
    }

    public static void main(String[] args) {

        Factorial factorialInstance = new Factorial();
        int factorial1 = factorialInstance.factorial(5);
        System.out.println("The factorial result is " + factorial1);

        int factorial2 = factorialInstance.findFactorial(5);
        System.out.println("The factorial result using 2nd method is " + factorial2);
    }
}
