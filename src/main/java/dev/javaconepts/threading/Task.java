package dev.javaconepts.threading;

public class Task extends Thread {
    private int number;

    public Task() {

    }

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Task " + number + " Started");
        for (int i = 100 * number; i < 100 * number + 99; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task " + number + " done");
    }
}
