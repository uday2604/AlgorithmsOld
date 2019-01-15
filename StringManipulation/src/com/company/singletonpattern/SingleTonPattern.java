package com.company.singletonpattern;

/**
 * Created by Uday on 2016-05-12.
 */
public class SingleTonPattern {

    // The only object of this class
    private static SingleTonPattern singleTonPattern = new SingleTonPattern();

    // Make constructor private so that it class cannot be instantiated (or visible) from outside the class
    private SingleTonPattern() {

    }

    // Gets the object of this class
    public static SingleTonPattern getInstance() {

        return singleTonPattern;
    }

    public void showMessage() {
        System.out.println("Hello World");
    }


}
