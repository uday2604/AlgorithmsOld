package com.paypal.multithreading;

/**
 * Created by udaypersonal on 9/24/16.
 */
public class ThreadStartUsingRunnable implements Runnable {

    public void run() {
        System.out.println("Running the thread using runnable interface");

        String threadName=Thread.currentThread().getName();
        System.out.println(threadName);
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new ThreadStartUsingRunnable());
        thread.start();

        Thread thread1 = new Thread(new ThreadStartUsingRunnable(),"This is the name of the thread");
        thread1.start();


    }


}
