package com.multithreading;

/**
 * Created by Uday on 2016-05-12.
 */
public class Synchronization {

    private int count=0;

    public synchronized void doIncrement(){
        count++;
    }
        public void doSomeWork() throws InterruptedException {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++) {
                        doIncrement();
                    }
                }
            });

            Thread thread1= new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++) {
                        doIncrement();
                    }
                }
            });

            thread.start();
            thread1.start();

            thread.join();
            thread1.join();

            System.out.println("The count is "+count);


        }

    public static void main(String[] args) throws InterruptedException{

        Synchronization synchronization = new Synchronization();
        synchronization.doSomeWork();

    }
}
