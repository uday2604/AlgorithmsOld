package com.xad;

/**
 * Created by Uday on 2016-05-10.
 */
public class Prime {

    public boolean isPrime(int number) {

        if(number==0)
            return false;

        if(number==1||number==2)
            return true;

        if(number%2==0)
            return false;

        for(int i=3;i<number/2;i++) {

            if(number%i==0)
                return false;

        }

        return true;

    }

    public static void main(String[] args) {

        Prime prime= new Prime();
        boolean isPrime=prime.isPrime(15);
        System.out.println(isPrime);
    }


}
