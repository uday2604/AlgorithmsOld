package com.intuit;

/**
 * Created by Uday on 2016-05-22.
 */
public class StarPatterns {

    public void starPattern(int number) {

        for(int i=0;i<number;i++) {

            for(int j=0;j<=i;j++) {
                System.out.print("*");

            }
            System.out.println();
        }

    }

    public void starPatternInitialSpaces(int number) {

        for(int i=0;i<number;i++) {

           for(int j=0;j<number-i;j++)
               System.out.print(" ");

            for(int k=0;k<=i;k++)
                System.out.print("* ");

            System.out.println();
        }

    }

    public static void main(String[] args) {

        StarPatterns starPatterns = new StarPatterns();
       // starPatterns.starPattern(5);

        starPatterns.starPatternInitialSpaces(5);
    }
}
