package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Uday on 4/5/2016.
 * String Anagrams: Brute force and a smart method
 */
public class StringAnagrams {

    private boolean checkStringAnagram(String inputString1, String inputString2) {

        if (inputString1.equals("") || inputString2.equals("") || inputString1.length() != inputString2.length()) {
            return false;
        } else {
            char[] charArray1 = inputString1.toCharArray();
            char[] charArray2 = inputString2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            return Arrays.equals(charArray1, charArray2);
        }
    }

    // This uses ASCII values logic. Works only for alphabet characters, to work for all characters, increase the char array size to 255
    private boolean anagramCheck(String inputString1, String inputString2) {

        char[] charArray1 = inputString1.toCharArray();
        char[] charArray2 = inputString2.toCharArray();
        char[] alphabetCharArray = new char[26];

        if (inputString1.equals("") || inputString2.equals("") || inputString1.length() != inputString2.length()) {
            return false;
        } else {
            for (int i = 0; i < charArray1.length; i++) {
                alphabetCharArray[(int) (charArray1[i]) - 97]++; // Type Casting is optional
                alphabetCharArray[(int) charArray2[i] - 97]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alphabetCharArray[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Enter two strings ");
        Scanner scanner = new Scanner(System.in);

        String inputString1 = scanner.nextLine();
        String inputString2 = scanner.nextLine();

        StringAnagrams stringAnagramsInstance = new StringAnagrams();
        boolean isEqual = stringAnagramsInstance.checkStringAnagram(inputString1, inputString2);
        System.out.println(isEqual);

        System.out.println(stringAnagramsInstance.anagramCheck(inputString1, inputString2));
    }
}
