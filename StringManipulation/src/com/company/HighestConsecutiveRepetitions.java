package com.company;

import java.util.Scanner;

/**
 * Created by Uday on 4/5/2016.
 * Count of highest consecutive character in the given string
 */
public class HighestConsecutiveRepetitions {

    private void highestConsecutiveRepetition(String inputString) {
        int count = 1;
        int maxCountForChar = 0;
        char maxRepeatedCharacter = ' ';
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                count++;
            } else {
                if (count > maxCountForChar) {
                    maxCountForChar = count;
                    maxRepeatedCharacter = inputString.charAt(i - 1);
                }
                count = 1;
            }
        }

        if (count > maxCountForChar) {
            maxCountForChar = count;
            maxRepeatedCharacter = inputString.charAt(inputString.length() - 1);
        }
        System.out.println("The highest repeated char is " + maxRepeatedCharacter + " and the count is " + maxCountForChar);
    }

    public static void main(String[] args) {
        System.out.println("Enter the input string to get the max repeated char and its count");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        HighestConsecutiveRepetitions highestConsecutiveRepetitionsInstance = new HighestConsecutiveRepetitions();
        highestConsecutiveRepetitionsInstance.highestConsecutiveRepetition(string);
    }
}
