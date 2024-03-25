package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.ExecutorFramework._2_FixedThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<=10;i++){
            executorService.execute(new Task1(i));
        }
        executorService.shutdown();
    }
}


class Task1 implements Runnable{
    private int id;

    public Task1(int id) {
        this.id = id;
    }


    @Override
    public void run() {

        System.out.println("Task with id"+id+" is in work-thread id"+Thread.currentThread().getId());
        long duration =(long) Math.random()*5;

        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

