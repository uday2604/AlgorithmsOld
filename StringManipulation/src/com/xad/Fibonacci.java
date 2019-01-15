package com.xad;

/**
 * Created by Uday on 2016-05-10.
 */
public class Fibonacci {

    public int findFibonacci(int number) {

        if(number==1)
            return 0;
        if(number==2)
            return 1;

        int fibo1=0, fibo2=1, fibonacci=0;

        for(int i=0;i<number-2;i++) {

            fibonacci=fibo1+fibo2;
            fibo1=fibo2;
            fibo2=fibonacci;
        }

        return fibonacci;
    }


    public void findFibonacciSeries(int number) {

        int fibo1=0, fibo2=1, fibonacci=0;

        System.out.print("0 1 ");
        for(int i=0;i<number-2;i++) {


            fibonacci=fibo1+fibo2;
            System.out.print(fibonacci+ " ");

            fibo1=fibo2;
            fibo2=fibonacci;


        }


    }


    public static void main(String[] args) {

        Fibonacci fibonacci= new Fibonacci();
        System.out.println(fibonacci.findFibonacci(10));

        fibonacci.findFibonacciSeries(10);
    }
}
