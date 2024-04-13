package com.multithreading.ImplementsRunnable;

//This program implements on communicating between the threads.
//When the producer produces the value, consumer will consume the value.
//If the producer didn't produce the value, consumer will wait, Similarly if the consumer didn't consume the value, producer will wait.
class Helper {
    int num;
    boolean valueSet = false;

    public synchronized void put(int num){
        while (valueSet) {
            try {
                wait();
            }
            catch (Exception ex) {}
        }
        System.out.println("Put : " + num);
        this.num = num;
        valueSet = true;
        notify();
    }

    public synchronized void get(){
        while (!valueSet){
            try {
                wait();
            }
            catch (Exception ex) {}
        }
        System.out.println("Get : " + num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {
    Helper helper;
    public Producer(Helper helper){
        this.helper = helper;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            helper.put(i++);
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex) {}
        }
    }
}

class Consumer implements Runnable {
    Helper helper;

    public Consumer(Helper helper){
        this.helper = helper;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while (true) {
            helper.get();
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex) {}
        }
    }
}

public class InterThread {
    public static void main(String[] args) {
        Helper helper = new Helper();
        new Producer(helper);
        new Consumer(helper);
    }
}
