package com.intuit;

import com.xad.*;

/**
 * Created by Uday on 2016-05-22.
 */
public class Fibonacci {

    public int getFibonacci(int number) {

        if(number<0 || number==0)
            return -1;

        else if(number==1)
            return 0;

        else if(number==2)
            return 1;

        else {

            int fib1=0;
            int fib2=1;
            int fibonacci=0;

            for(int i=0;i<number-2;i++) {

                fibonacci=fib1+fib2;
                fib1=fib2;
                fib2=fibonacci;
            }
            return fibonacci;
        }

    }

    public int fibonacciRecursion(int number) {

        if(number<=0)
            return -1;

        if(number==1)
            return 0;

        if(number==2)
            return 1;

        return fibonacciRecursion(number-1)+fibonacciRecursion(number-2);
    }

    public static void generateFibonacci(int number) {

        if(number<0 || number==0)
            System.out.println("Enter a number greater than 0");

        else if(number==1)
            System.out.println(0);

        else if(number==2)
            System.out.println(1);

        else {

            int fib1=0;
            int fib2=1;
            int fibonacci=0;

            System.out.print("0 1");

            for(int i=0;i<number-2;i++) {

                fibonacci=fib1+fib2;
                System.out.print(" "+fibonacci);
                fib1=fib2;
                fib2=fibonacci;
            }

        }


    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        int output=fibonacci.getFibonacci(10);
        System.out.println(output);

        Fibonacci.generateFibonacci(10);

        System.out.println("\n"+fibonacci.fibonacciRecursion(10));
    }
}
