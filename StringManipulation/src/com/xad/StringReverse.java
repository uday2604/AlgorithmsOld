package com.xad;

/**
 * Created by Uday on 2016-05-20.
 */
public class StringReverse {

    public String stringReverse(String str) {

        if(str==null || str.length()<0)
            return str;

        else
        return stringReverse(str.substring(1))+str.charAt(0);

    }

    public static void main(String[] args) {

        StringReverse stringReverse = new StringReverse();
        String output=stringReverse.stringReverse("Uday");
        System.out.println(output);
    }

}
