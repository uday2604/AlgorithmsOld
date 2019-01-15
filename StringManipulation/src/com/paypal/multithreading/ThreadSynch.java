package com.paypal.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by udaypersonal on 9/24/16.
 */
public class ThreadSynch extends Thread{

   private static int counter =0;

    public synchronized void run () {

        for (int i=0; i<49; i++) {
            counter++;
            System.out.println(counter);

        }

    }

    public static void main (String[] args) {

        ThreadSynch threadSynch = new ThreadSynch();
        ThreadSynch threadSynch1 = new ThreadSynch();


        threadSynch.start();
        threadSynch1.start();
    }

}
