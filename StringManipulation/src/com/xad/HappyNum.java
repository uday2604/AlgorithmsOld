package com.xad;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Uday on 2016-07-01.
 */
public class HappyNum {

    public static boolean isHappyNumber(long number){
        long m = 0;
        int digit = 0;
        HashSet<Long> cycle = new HashSet<Long>();
        while(number != 1 && cycle.add(number)){
            m = 0;
            while(number > 0){
                digit = (int)(number % 10);
                m += digit*digit;
                number /= 10;
            }
            number = m;
        }
        return number == 1;
    }



    public static void main(String[] args) {

        HappyNum happyNum = new HappyNum();
        int[] inputArray={4,5,6,7,8};

        for(int number:inputArray) {

            if(happyNum.isHappyNumber(number))
                System.out.println(number + " is a happy number");

            else
                System.out.println(number+ " is not a happy number");
        }
    }
}
