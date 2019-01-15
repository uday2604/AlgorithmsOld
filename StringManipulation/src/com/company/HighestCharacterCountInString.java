package com.company;

import java.util.*;

/**
 * Created by Uday on 4/5/2016.
 */
public class HighestCharacterCountInString {

    public List<Character> countOfHighestCharacters(String inputString) {

        HashMap<Character, Integer> countHashMap = new LinkedHashMap<>();
        List<Character> highestCharacterCountArrayList = new ArrayList<>();
        Character highestRepeatedCharacter=' ';

        int highestCharacterOccurrenceCount = 0;

        // To avoid space count
        for (char ch : inputString.replaceAll(" ", "").toCharArray()) {

            if(!countHashMap.containsKey(ch)) {
                countHashMap.put(ch, 1);
            }

            else {
                countHashMap.put(ch, countHashMap.get(ch) + 1);
            }

            if(countHashMap.get(ch)>highestCharacterOccurrenceCount) {
                highestCharacterOccurrenceCount = countHashMap.get(ch);
            }
        }

        for (Map.Entry<Character, Integer> entry : countHashMap.entrySet()) {

            if(entry.getValue() == highestCharacterOccurrenceCount)
            highestCharacterCountArrayList.add(entry.getKey());
        }

        return highestCharacterCountArrayList;
    }

    // WRONG method don't use
    public Character getMaxCount(String inputString) {

        char[] charCountArray = new char[Character.MAX_VALUE+1];
        int maxCountChar =0;
        char maxOccurredChar =' ';

        for(char ch : inputString.toCharArray()) {
            if(charCountArray[ch] >=maxCountChar) {
                maxCountChar = charCountArray[ch];
                maxOccurredChar=ch;
            }

        }

        return maxOccurredChar;
    }

    public static void main(String args[]) {

        System.out.println("Enter the string to get the highest character count");
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        HighestCharacterCountInString highestCharacterCountInStringInstance = new HighestCharacterCountInString();

        List<Character> highestCharacterCountArrayList = highestCharacterCountInStringInstance.countOfHighestCharacters(inputString);

        System.out.println("The highest repeated character is "+ highestCharacterCountArrayList);

        char maxOccurredChar= highestCharacterCountInStringInstance.getMaxCount(inputString);

        System.out.println("The character which occurred most times is "+ maxOccurredChar);

    }
}
