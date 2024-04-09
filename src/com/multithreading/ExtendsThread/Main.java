package com.multithreading.ExtendsThread;


//By extending the thread, we need to implement the run method. so that when we start the thread of the particular class, the run method will get invoked automatically.
class Hi extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
            }
        }
    }
}

class Hello extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Hi hi = new Hi();
        Hello hello = new Hello();

        hi.start();

        //This try catch block is added because when we start different threads at same time, the threads will go to scheduler and at some time, one thread may execute before another thread and vice versa so to remove the collision, added the block to execute the first thread before the second thread.
        try {
            Thread.sleep(10);
        } catch (Exception ex) {}

        hello.start();

    }
}

