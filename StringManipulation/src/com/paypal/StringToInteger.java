package com.paypal;

/**
 * Created by udaypersonal on 9/18/16.
 */
public class StringToInteger {

    public static Integer stringToInteger(String inputString) {

        if(inputString==null || inputString.length()==0)
            return -1;

        int result =0;

        for(int i=0; i<inputString.trim().length();i++) {

            char temp = inputString.charAt(i);
            int currentValue = temp-'0';

            result=currentValue+result*10;

        }

        return result;

    }


    public static void main(String[] args) {

        int convertedInteger = StringToInteger.stringToInteger("243");
        System.out.println(convertedInteger);


    }


}
