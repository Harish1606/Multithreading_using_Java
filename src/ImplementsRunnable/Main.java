package ImplementsRunnable;

//Disadvantage of extends thread to implement multithreading is, when we want to extend other classes also, but we can't since Java doesn't support multiple inheritance. That is the reason we are going for runnable interface to implement multithreading.
class Hi implements Runnable {
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

class Hello implements Runnable {
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

        //We can also put above 2 lines like this
        //Runnable hi = new Hi();
        //Runnable hello = new Hello();

        Thread t1 = new Thread(hi);
        Thread t2 = new Thread(hello);

        t1.start();

        try {
            Thread.sleep(10);
        } catch (Exception ex) {}

        t2.start();
    }
}
