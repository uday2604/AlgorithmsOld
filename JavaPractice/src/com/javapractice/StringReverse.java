package com.javapractice;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Uday on 3/17/2016.
 */
public class StringReverse {

    public String stringReverseMethod1(String str){

        String reverseString="";
        for(int i=str.length()-1;i>=0;i--) {
            reverseString+=str.charAt(i);
        }
        return reverseString;
    }

    public String stringReverseMethod2(String str) {

        return new StringBuilder(str).reverse().toString();
    }

    public Stack stringReverseUsingStacks(String str) {

        Stack revStack = new Stack();

        for(int i=0; i<=str.length()-1;i++){

            revStack.push(str.charAt(i));
        }
        return revStack;
    }

    public static void main(String[] args) {

        System.out.println("Enter the String to reverse ");
        Scanner in = new Scanner(System.in);

        String inputString= in.nextLine();

        StringReverse revInstance= new StringReverse();
        System.out.println(revInstance.stringReverseMethod1(inputString));

        StringReverse revInstance2= new StringReverse();
        System.out.println(revInstance2.stringReverseMethod1(inputString));

        StringReverse revInstance3= new StringReverse();
        Stack newStack=revInstance3.stringReverseUsingStacks(inputString);

        System.out.println("Printing through stack method \n ");

        while(!newStack.isEmpty()) {
            System.out.print(newStack.pop());
        }



    }
}
