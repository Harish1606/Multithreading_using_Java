package com.multithreading.ImplementsRunnable;

public class LambaExpression {
    public static void main(String[] args) throws Exception {
        Runnable obj1 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hi");
                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                    }
                }
            };

        Runnable obj2 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                    }
                }
            };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();

        try {
            Thread.sleep(10);
        } catch (Exception ex) {}

        t2.start();

        //isAlive method to find whether the thread is currently running or not.
        System.out.println(t1.isAlive());

        //Join method make main thread to wait until the thread t1 and t2 complete and the thread t1 and t2 will be joined with the main thread.
        t1.join();
        t2.join();

        System.out.println(t1.isAlive());

        System.out.println("Bye");
    }
}
