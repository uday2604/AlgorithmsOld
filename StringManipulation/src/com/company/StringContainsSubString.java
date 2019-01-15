package com.company;

/**
 * Created by Uday on 4/6/2016.
 */
public class StringContainsSubString {

    public int checkStringContainsSubString(String inputString, String subString) {

        int index=-1;
        int subStringPointer=0;
        for(int i=0; i<inputString.length();i++) {

            if(inputString.charAt(i)==subString.charAt(subStringPointer)) {
                index = inputString.charAt(i);
                subStringPointer++;
            }
            else {
                System.out.println("Invalid");
            }

        }
        return 0;

    }
}
