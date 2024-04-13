package com.multithreading.ImplementsRunnable;

class Counter {
    int count;

    //Synchronized keyword will make only one thread able to access this method at the same time.
    public synchronized void increment() {
        count++;
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count " + counter.count);
    }
}
