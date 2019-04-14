package com.company;

/**
 * Created by udaypersonal on 9/10/16.
 * Find a duplicate element in the given integer array
 */
public class FindOneDuplicateElement {

    private static int findDuplicateElement(int[] integerArray) {
        int dup = 0;
        for (int i = 0; i < integerArray.length; i++) {
            dup = dup ^ integerArray[i] ^ i;
        }
        return dup;
    }

    public static void main(String[] args) {
        int[] inputArray = {5, 1, 2, 3, 4, 7, 6, 4};
        int duplicateElement = FindOneDuplicateElement.findDuplicateElement(inputArray);
        System.out.println("The duplicate element is " + duplicateElement);
    }
}
