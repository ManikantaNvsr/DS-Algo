package dev.javaconepts.threading;

import java.util.concurrent.*;

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        // Print every 5 seconds
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

//        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Hi"), 0, 5, TimeUnit.SECONDS);

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

        ExecutorService executorService1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.DAYS, new LinkedBlockingDeque<>());
    }
}
