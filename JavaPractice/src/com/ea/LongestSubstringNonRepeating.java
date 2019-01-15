package com.ea;

/**
 * Created by uthota on 7/31/16.
 */
public class LongestSubstringNonRepeating {

    public int longestSubstringWithoutNonRepeatingChars(String inputString) {

        if(inputString==null || inputString.length()==0)
            return 0;

        else if(inputString.length()==1)
            return inputString.length();

        else {

           // This is important, to track the flag (true or false) of characters encountered while going through the string
            boolean characterFlag[] = new boolean[256];
            int result =0;
            int start=0;

            for(int i=0;i<inputString.length();i++) {

                char currentChar = inputString.charAt(i);
                if(characterFlag[currentChar]) {

                    int currentMaxLength=i-start;
                    result=Math.max(currentMaxLength, result);

                    for(int k=start;k<i;k++) {
                        if (inputString.charAt(k) == currentChar) {
                            start = k + 1;
                            break;
                        }

                        characterFlag[k]=false;

                    }

                }

                else
                    characterFlag[currentChar]=true;

            }

            result=Math.max(inputString.length()-start, result);
            return result;

        }


    }

    public static void main(String[] args) {

        LongestSubstringNonRepeating longestSubstringNonRepeating = new LongestSubstringNonRepeating();
        int longNonRepeatingCharCount = longestSubstringNonRepeating.longestSubstringWithoutNonRepeatingChars("bbbbb");
        System.out.println("The max count of non repeating chars is "+longNonRepeatingCharCount);

    }
}
