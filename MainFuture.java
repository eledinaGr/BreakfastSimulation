package com.scytalys;

import com.scytalys.model.Breakfast;
import com.scytalys.service.WorkerCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFuture {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //ExecutorService allows us to execute tasks on threads asynchronously
        ExecutorService es = Executors.newFixedThreadPool(5);

        //getting future
        //the method submit() submits a value-returning task for execution and returns the Future
        List<WorkerCallable> tasks = new ArrayList<>();

        tasks.add(new WorkerCallable(1, "Vrazw to avgo"));
        tasks.add(new WorkerCallable(2, "Vazw to avgo sto piato"));
        tasks.add(new WorkerCallable(3, "Vrazw to gala"));
        tasks.add(new WorkerCallable(4, "Vazw to gala stin koupa"));
        tasks.add(new WorkerCallable(5, "Etoimazw to trapezi"));

        List<Future<Breakfast>> futures = new ArrayList<>();

        long startingTime = System.currentTimeMillis();

        for (WorkerCallable task : tasks) {
            Future<Breakfast> future = es.submit(task);
            futures.add(future);
        }

        // Check all futures for completion
        for (Future<Breakfast> future : futures) {
            while (!future.isDone()) {
                System.out.println("Task is still in process.....");
                Thread.sleep(200);
            }
            System.out.println("Task completed! Getting the result");
            Breakfast result = future.get();
            System.out.println(result);
        }
        long endingTime = System.currentTimeMillis();
        System.out.println("time: " + (endingTime - startingTime) + " millisecond");
        es.shutdown();
    }

}
