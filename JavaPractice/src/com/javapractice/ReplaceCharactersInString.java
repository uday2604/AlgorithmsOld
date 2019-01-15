package com.javapractice;

/**
 * Created by Uday on 3/17/2016.
 */

// Replace T with I and A with E
public class ReplaceCharactersInString {
    public static void main(String[] args) {
        String str ="The characters will be replaced";
        str=str.toUpperCase();
        String finalString="";

        for(int i=0; i<str.length();i++) {

            if(str.charAt(i)=='T')
                finalString+='I';

            else if(str.charAt(i)=='A')
                finalString+='E';

            else
                finalString+=str.charAt(i);
        }

        System.out.println(finalString);

    }

}
