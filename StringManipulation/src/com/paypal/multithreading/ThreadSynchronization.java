package com.paypal.multithreading;

/**
 * Created by udaypersonal on 9/24/16.
 */

class PrintMethod {
    public void printCount() {

        for (int i=0; i<500; i++)
            System.out.println(i);
    }

}

class ThreadDemo extends Thread {

    PrintMethod pm;

    ThreadDemo(PrintMethod printMethod) {
        pm=printMethod;
    }

    public void run() {

        synchronized (pm) {
            pm.printCount();
        }
    }

}

class ThreadSynchronization {


    public static void main(String[] args) {

        PrintMethod printMethod = new PrintMethod();

        ThreadDemo threadDemo = new ThreadDemo(printMethod);
        ThreadDemo threadDemo1 = new ThreadDemo(printMethod);

        threadDemo.start();
        threadDemo1.start();

    }


}
