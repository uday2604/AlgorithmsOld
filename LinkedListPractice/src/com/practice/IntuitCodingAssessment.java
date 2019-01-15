package com.practice;
import java.util.Scanner;
/**
 * Created by Uday on 2016-05-07.
 */
public class IntuitCodingAssessment {

    public void printBigXPattern(int patternLength) {
        for (int i = 0; i < patternLength; i++) {
            for (int j = 0; j < patternLength; j++) {
                if (i == j || (j == (patternLength - i -1))) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        IntuitCodingAssessment instance = new IntuitCodingAssessment();
        System.out.println("Enter a positive odd integer: ");

        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        if (inputNumber % 2 == 0 || inputNumber<0) {
            System.out.println("Your input doesn't match constraints, try again");
        } else {
            instance.printBigXPattern(inputNumber);
        }

    }



}
