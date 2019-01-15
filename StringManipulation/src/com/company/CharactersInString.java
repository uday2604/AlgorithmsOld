package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Uday on 3/31/2016.
 */
public class CharactersInString {

    public HashMap countOfCharacters(String str) {

        HashMap<Character, Integer> countOfCharactersHashMap = new LinkedHashMap<>();

        char[] charArrayWithoutSpaces = str.replace(" ", "").toCharArray();

        for(char ch: charArrayWithoutSpaces) {

            if (!countOfCharactersHashMap.containsKey(ch)) {
                countOfCharactersHashMap.put(ch, 1);
            }

            else {
                countOfCharactersHashMap.put(ch, countOfCharactersHashMap.get(ch)+1);
            }

        }

        return countOfCharactersHashMap;
    }

    public static void main (String args[]) {

        System.out.println("Enter the string to give the count of each character");
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();

        System.out.println("Enter the specific character for its count ");
        Character character = scan.next().charAt(0);

        CharactersInString charactersInStringInstance = new CharactersInString();
        HashMap<Character, Integer> outputHashMap=charactersInStringInstance.countOfCharacters(inputString);

        System.out.println(outputHashMap);

        for (Map.Entry<Character, Integer> entry : outputHashMap.entrySet()) {
            System.out.println("Key: "+ entry.getKey() + " Value is "+ entry.getValue());
        }

        for (Map.Entry<Character, Integer> newEntry: outputHashMap.entrySet()) {
            if(newEntry.getKey().equals(character))
                System.out.println("The given character "+ newEntry.getKey()+" count is "+newEntry.getValue());
        }




    }

}
