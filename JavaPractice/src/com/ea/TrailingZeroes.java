package com.ea;

/**
 * Created by uthota on 7/30/16.
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        if (n < 0)
            return -1;

        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }

    public static void main(String[] args) {

        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(20));
    }
}
