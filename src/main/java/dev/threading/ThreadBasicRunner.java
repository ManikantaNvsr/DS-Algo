package dev.threading;

public class ThreadBasicRunner {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        task1.start();

        Thread task2 = new Thread(new Task2());
        task2.start();

    }
}

class Task1 extends Thread {
    @Override
    public void run() {
        System.out.println("Task1 Started");
        for (int i = 0; i < 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task1 done");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Task2 Started");
        for (int i = 100; i < 200; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task2 done");
    }
}
