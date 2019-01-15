package com.ea;

/**
 * Created by uthota on 7/28/16.
 */
public class StringToInteger {


    public int stringToInteger(String str) {

        int outputValue=0;
        if(str==null || str.length()==0)
            return Integer.MIN_VALUE;

        else {

            String formattedString= str.replaceAll(" ","");

            for(int i=0;i<formattedString.length();i++) {

                int integerValueForCharacter=formattedString.charAt(formattedString.length()-i-1)-'0';
                outputValue+=Math.pow(10,i)*integerValueForCharacter;

            }

        }

        return outputValue;
    }

    public static void main(String[] args) {

        StringToInteger stringToInteger = new StringToInteger();
        int intValue = stringToInteger.stringToInteger("1567");

        System.out.println("The int value is "+intValue);
    }

}
