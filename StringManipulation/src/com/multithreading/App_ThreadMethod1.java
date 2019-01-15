package com.multithreading;

/**
 * Created by Uday on 2016-05-12.
 */
public class App_ThreadMethod1 {

    public static class Runner extends Thread {

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

        Thread thread= new Runner();
        thread.start();

        Runner runner = new Runner();
        runner.start();

    }
}
