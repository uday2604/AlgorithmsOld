package com.ea;

/**
 * Created by uthota on 7/17/16.
 */
public class StringReverse {

    public String stringReverse(String inputString) {

        String outputString="";
        if(inputString==null)
            return null;

        for(int i=0;i<inputString.length();i++) {
            outputString+=inputString.charAt(inputString.length()-i-1);

        }

        return outputString;

    }

    public String stringReverseUsingInBuilt(String inputString) {

        return new StringBuilder(inputString).reverse().toString();


    }

    // Try avoiding creating new string, rather use string builder which is more efficient (doesn't create many string objects and saves memory)
    public String wordReverse(String inputString) {

        String[] splitArray = inputString.split(" ");
        //String outputString="";

        StringBuilder outputString = new StringBuilder();

        for(int i=0;i<splitArray.length;i++) {

            outputString.append(splitArray[splitArray.length-i-1]+" ");

        }
        return outputString.toString();

    }

    public String wordReverseInPlace(String inputString) {

       // String outputString = "";
        StringBuilder outputString = new StringBuilder();

        if(inputString==null || inputString.length()==0)
            return null;

        else {

            String[] splitArray = inputString.split(" ");

            for(int i=0; i<splitArray.length;i++) {

                for(int j=splitArray[i].length()-1;j>=0;j--)
                    outputString.append(splitArray[i].charAt(j));

                outputString.append(" ");


            }

        }
        return outputString.toString();

    }


    public static void main(String[] args) {

        StringReverse stringReverse= new StringReverse();
        String outputString = stringReverse.stringReverse("Starting Again");

        System.out.println(outputString);

        System.out.println("After reversing, the string is "+stringReverse.stringReverseUsingInBuilt("Udaydeep"));

        String outputString2=stringReverse.wordReverse("Reverse this sentence");
        System.out.println(outputString2);


        String outputString3 = stringReverse.wordReverseInPlace("This is to test word reverse in place");
        System.out.println("After word reverse in place, the string is: \n"+outputString3);


    }
}
