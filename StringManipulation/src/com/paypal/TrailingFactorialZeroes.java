package com.paypal;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class TrailingFactorialZeroes {


   // The number of zeroes is the number of 5's in n! (Number of zeroes are the count of 2*5 factors in the number's factorial: say number factorization is 2^4 and 5^2, number of zeroes is 2)
   // http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/ - For more explanation
    public static int trailingZeroes(int number) {

        if(number<=4)
            return 0;

        int count=0;
        for (int i=5; number/i>=1; i=i*5) {
            count+=number/i;

        }
        return count;

    }

    public static void main(String[] args) {

        System.out.println(TrailingFactorialZeroes.trailingZeroes(27));

    }
}
