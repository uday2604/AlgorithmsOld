package com.ea;

/**
 * Created by uthota on 7/30/16.
 */
public class LongestSubString {

    public int getLongestCommonSubstring(String a, String b){
        int m = a.length();
        int n = b.length();

        int max = 0;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }

                    if(max < dp[i][j])
                        max = dp[i][j];
                }

                else {
                    dp[i][j]=0;
                }

            }
        }

        return max;
    }


    public static void main(String[] args) {

        LongestSubString longestSubString = new LongestSubString();
        int longSubStringCount = longestSubString.getLongestCommonSubstring("cab", "deab");

        System.out.println(longSubStringCount);
    }

}
