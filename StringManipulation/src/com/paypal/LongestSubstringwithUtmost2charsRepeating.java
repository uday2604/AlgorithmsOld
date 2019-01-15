package com.paypal;

import java.util.HashMap;

/**
 * Created by udaypersonal on 9/18/16.
 */
public class LongestSubstringwithUtmost2charsRepeating {

    public static String lengthOfLongestSubstringTwoDistinct(String s) {
        int max=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start=0;
        String output= "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }

            if(map.size()>2){


                if(i-start>max) {
                    max=Math.max(max, i-start);
                    output = s.substring(start, i);

                }


                while(map.size()>2){
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        if((s.length()-start) >max) {

            return s.substring(start, s.length());
        }

       return output;

    }

    public static void main(String[] args) {

        System.out.println(LongestSubstringwithUtmost2charsRepeating.lengthOfLongestSubstringTwoDistinct("aabdddddddddddcccbb"));

    }
}
