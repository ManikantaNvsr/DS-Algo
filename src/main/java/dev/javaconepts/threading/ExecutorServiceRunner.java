package dev.javaconepts.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));
        executorService.execute(new Task(5));
        executorService.execute(new Task(6));
        executorService.execute(new Task(7));

        System.out.println("Task 6 started");
        // Task3
        for (int i = 600; i < 700; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 6 done");
        executorService.shutdown();
    }
}
