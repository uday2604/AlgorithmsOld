package com.paypal;

/**
 * Created by udaypersonal on 9/18/16.
 */
public class LongestSubstringWithoutRepeating {


    // Take a char array, for first time when character is encountered, flag it false, when next time encountered, do some manipulations
    public static int longestSubString(String inputString) {

        if(inputString==null || inputString.length()==0)
            return 0;

        boolean[] flag = new boolean[256];
        int max =1;
        int start=0;
        int length=0;
        int k;

        for(int i=0; i<inputString.length(); i++) {

            char temp = inputString.charAt(i);
            if(flag[temp]) {

                length=i-start;
                max=Math.max(max, length);


               // Flag all the elements till the repetitive element as false (Basically resetting the char array) as we need to start with new sequence again
                for(k=start; k<inputString.length(); k++) {

                    if(inputString.charAt(k)==temp) {
                        start=k+1;
                        break;
                    }
                    flag[k]=false;

                }

            }
            else
                flag[temp]=true;
        }

        // This is important because last sequence can be the longest one
        max=Math.max(inputString.length()-start, max);
        return max;
    }

    public static void main(String[] args) {


        int lengthOfString = LongestSubstringWithoutRepeating.longestSubString("aabcadeaabf");
        System.out.println("The length is "+lengthOfString);

    }

}
