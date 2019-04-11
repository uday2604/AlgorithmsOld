package com.intuit;

/**
 * Created by Uday on 2016-05-26.
 * Push the zeroes to end of the array
 */
class PushZero {

    // Function which pushes all zeros to end of an array.
    private static void pushZerosToEnd(int arr[]) {
        int count = 0;  // Count of non-zero elements
        int n = arr.length;

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count' with this element
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // here count is incremented
            }
        }

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        pushZerosToEnd(arr);

        System.out.println("Array after pushing zeros to the back: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
