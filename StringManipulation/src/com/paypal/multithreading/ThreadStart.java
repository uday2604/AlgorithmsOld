package com.paypal.multithreading;

/**
 * Created by udaypersonal on 9/24/16.
 */
public class ThreadStart extends Thread {

    public void run() {
        System.out.println("Running the thread using thread start method");
    }

    public static void main(String[] args) {

        ThreadStart threadStart = new ThreadStart();
        threadStart.start();


        // Starting the thread by running anonymous class concept
        Thread thread = new Thread() {

            public void run() {
                System.out.println("Running the thread using anonymous class");
            }
        };

        thread.start();

    }

}
