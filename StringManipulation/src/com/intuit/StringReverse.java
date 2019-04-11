package com.intuit;

/**
 * Created by Uday on 2016-05-22.
 * String reverse: iterative and recursive
 */
public class StringReverse {

    private String stringReverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private String stringReverseMethod2(String string) {
        String output = "";
        for (int i = string.length() - 1; i >= 0; i--)
            output += string.charAt(i);
        return output;
    }

    private String stringReverseRecursion(String string) {
        if (string.length() == 0)
            return string;
        return stringReverseRecursion(string.substring(1)) + string.charAt(0);
    }


    public static void main(String[] args) {

        StringReverse stringReverse = new StringReverse();
        String output = stringReverse.stringReverse("Uday");
        System.out.println(output);

        String output2 = stringReverse.stringReverseMethod2("testing");
        System.out.println(output2);

        String output3 = stringReverse.stringReverseRecursion("newword");
        System.out.println(output3);
    }
}
