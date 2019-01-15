package com.company.singletonpattern;

/**
 * Created by Uday on 2016-05-12.
 */
public class SingleTonDemo {

    public static void main(String[] args) {

        // We cannot do this to get the object as the constructor of single ton class is private
     //   SingleTonPattern singleTonPatternInstance = new SingleTonPattern();

        SingleTonPattern singleTonPattern = SingleTonPattern.getInstance();
        singleTonPattern.showMessage();
    }
}
