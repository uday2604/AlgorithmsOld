package com.multithreading;

/**
 * Created by Uday on 2016-05-11.
 */
public class StartThread {

    // 1st way of starting a thread
    public static class Hello extends Thread {

        public void run() {

            System.out.println("Hello World");
        }
    }

    // 2nd way of starting a thread
    public static class HelloWorld implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello world from runner implementable interface");
        }
    }

    public static void main(String[] args) {

        Thread thread = new Hello();
        thread.start();

        Thread thread1 = new Thread(new HelloWorld());
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World again");
            }
        }).start();

    }

}
