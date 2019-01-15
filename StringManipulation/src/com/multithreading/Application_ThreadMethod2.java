package com.multithreading;

/**
 * Created by Uday on 2016-05-12.
 */
public class Application_ThreadMethod2 {

    static class Runner implements Runnable {

        public void run() {
            for(int i=0;i<4;i++) {
                System.out.println("Hello "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Runner());
        thread.start();

        Thread thread1= new Thread(new Runner());
        thread1.start();

    }
}
