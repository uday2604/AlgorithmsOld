package com.practice.stacks;

import java.util.Stack;

/**
 * Created by Uday on 2016-05-08.
 */
public class BalancedEquation {

   // For the opening braces, push to stack and for closing braces, pop the stack and see if the brace is opposite to the popped brace. If not return false. After completing the string, return true if stack is empty

    public boolean isStringBalanced(String str) {

        if(str==null || str.length()==0)
            return false;

        Stack<Character> charStoreStack= new Stack();
        for(int i=0;i<str.length();i++) {
            char ch= str.charAt(i);

            if(ch=='}') {
                char checkTopCharInStack = charStoreStack.peek();
                if(!charStoreStack.isEmpty() && checkTopCharInStack!='{')
                    return false;
                charStoreStack.pop();
            }

            else if(ch==']') {
                char checkTopCharInStack = charStoreStack.peek();
                if(!charStoreStack.isEmpty() && checkTopCharInStack!='[')
                    return false;
                charStoreStack.pop();
            }



            else if(ch==')') {
                char checkTopCharInStack = charStoreStack.peek();
                if(!charStoreStack.isEmpty() && checkTopCharInStack!='(')
                    return false;
                charStoreStack.pop();
            }

            else {
                charStoreStack.push(ch);
            }

        }

        if(charStoreStack.isEmpty())
            return true;
        else
            return false;

    }


    public static void main(String[] args) {
        BalancedEquation balancedEquationInstance = new BalancedEquation();
        boolean isStringBalanced=balancedEquationInstance.isStringBalanced("[({})]");

        if(isStringBalanced)
            System.out.println("The given equation is balanced");

        else
            System.out.println("The given equation is NOT balanced");

    }
}
