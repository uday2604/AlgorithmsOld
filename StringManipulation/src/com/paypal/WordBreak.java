package com.paypal;

import java.util.*;

/**
 * Created by udaypersonal on 9/22/16.
 */
public class WordBreak {


    public static boolean wordBreaker (String inputString, Set<String> dict) {

        return wordBreakHelper(inputString, dict, 0);

    }

    public static boolean wordBreakHelper(String string, Set<String> dict, int start) {

        if(start==string.length())
            return true;

        for(String word: dict) {
            int len = word.length();
            int end = start+len;

            if(end>string.length())
                continue;

            if(string.substring(start, start+len).equals(word))
                if(wordBreakHelper(string, dict, start+len))
                    return true;

        }

        return false;


    }

    public static void main (String[] args) {

        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        Set<String> inputSet = new LinkedHashSet<>(dict);

        boolean isWordBreak = WordBreak.wordBreaker("leetcode", inputSet);
        System.out.println(isWordBreak);

    }
}
