package com.vest;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Uday on 2016-05-15.
 */
public class FirstNonRepeatedCharacter {

    public HashMap<Character, Integer> firstNonRepeatedCharacter(String string) {

        HashMap<Character, Integer> outputHashMap = new LinkedHashMap<>();
        for(int i=0;i<string.length();i++) {

            if(!outputHashMap.containsKey(string.charAt(i)))
                outputHashMap.put(string.charAt(i), 1);

            else
                outputHashMap.put(string.charAt(i),outputHashMap.get(string.charAt(i))+1);
        }
        return outputHashMap;
    }


    public static void main(String[] args) {

        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        HashMap<Character, Integer> outputHashMap=firstNonRepeatedCharacter.firstNonRepeatedCharacter("uudaydeep");

        for(Map.Entry<Character, Integer> entry:outputHashMap.entrySet()) {

            if(entry.getValue()==1) {
                System.out.println("The first non repeated character is " + entry.getKey());
                break;
            }
        }

    }
}