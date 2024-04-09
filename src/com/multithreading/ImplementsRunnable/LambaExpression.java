package com.multithreading.ImplementsRunnable;

public class LambaExpression {
    public static void main(String[] args) {
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
    }
}
