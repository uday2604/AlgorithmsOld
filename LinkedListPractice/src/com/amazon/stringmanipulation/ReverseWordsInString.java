package com.amazon.stringmanipulation;

/**
 * Created by udaypersonal on 9/4/16.
 */
public class ReverseWordsInString {

    public String reverseWordsInString (String inputString) {

        if(inputString==null)
            return null;

        String outputString="";
        String[] tempArray = inputString.split(" ");
        for(int i=tempArray.length-1; i>=0; i--)
            outputString+=tempArray[i]+" ";

        return outputString;


    }

    public void reverseWordsInStringMethod2(char[] inputArray) {

        if(inputArray==null)
            return;

        int j=0;
        for(int i=0;i<inputArray.length;i++) {

            if(inputArray[i]==' ') {

                reverseWordHelper(inputArray, j, i-1);
                j=i+1;

            }

        }

        reverseWordHelper(inputArray, j, inputArray.length-1);
        reverseWordHelper(inputArray, 0, inputArray.length-1);


    }

    public void reverseWordHelper(char[] input, int start, int end) {

        while(start<end) {

            char temp = input[end];
            input[end]=input[start];
            input[start]=temp;
            start++;
            end--;

        }

    }


    public static void main(String[] args) {

        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String output = reverseWordsInString.reverseWordsInString("This is cool");
        System.out.println("After reversing the string is "+output);


        char[] charArray={'t', 'h','i','s',' ', 'i','s', ' ','c', 'o', 'o', 'l'};
        // System.out.print(charArray);

        reverseWordsInString.reverseWordsInStringMethod2(charArray);
        System.out.print(charArray);

    }

}
