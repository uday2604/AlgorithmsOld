package com.paypal;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by udaypersonal on 9/20/16.
 */
public class GroupAnagrams {

    // The main logic is that, for all anagram pairs, the sorted arrays would be same. So maintain that char array as a key in map.
    // First time it is encountered, add to the map, if encountered again (the same array for other string),
    // get the value of the key and append the string to that
    public static ArrayList<ArrayList> validGroupAnagrams (String[] inputStrings) {

        if(inputStrings==null || inputStrings.length==0)
            return null;

        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        HashMap<String, ArrayList<String>> stringStoreMap = new HashMap<>();
        for (String string: inputStrings) {

            char[] charArray = new char[26];
            for (int i=0; i<string.length();i++)
                charArray[string.charAt(i)-'a']++;

            String temp = new String(charArray);

            if(stringStoreMap.containsKey(temp)) {
                stringStoreMap.get(temp).add(string);

            }

            else {
                ArrayList<String> al = new ArrayList<>();
                al.add(string);
                stringStoreMap.put(temp, al);
            }

        }
        result.addAll(stringStoreMap.values());
        return result;

    }


    public static void main(String[] args) {

        ArrayList<ArrayList> result = GroupAnagrams.validGroupAnagrams(new String[] {"abc", "def", "cba", "ghi", "edf", "ghj"});
        for (ArrayList list : result)
            System.out.println(list);
    }

}
