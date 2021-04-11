package dev.threading;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        


        List<CallableTask> tasks = new LinkedList<>();

        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> e.printStackTrace());


        tasks.add(new CallableTask("Moni"));
        tasks.add(new CallableTask("Aravind"));
        tasks.add(new CallableTask("Mani"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        List<Future<String>> results = executorService.invokeAll(tasks);
        String result = executorService.invokeAny(tasks);
        System.out.println(" callable is executed");
        System.out.println(result);

//        for (Future<String> future : results) {
//            String helloMessage = future.get();
//            System.out.println(helloMessage);
//        }
        System.out.println("Main Completed");

        executorService.shutdown();
    }
}

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "Hello " + name;
    }
}
