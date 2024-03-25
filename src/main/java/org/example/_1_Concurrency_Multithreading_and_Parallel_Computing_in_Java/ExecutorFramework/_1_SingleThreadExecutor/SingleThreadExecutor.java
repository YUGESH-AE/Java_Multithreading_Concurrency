package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.ExecutorFramework._1_SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            executorService.execute(new Task(1));
        }
        executorService.shutdown();
    }
}


class Task implements Runnable{
    private int id;

    public Task(int id) {
        this.id = id;
    }


    @Override
    public void run() {

        System.out.println("Task with id"+id+" is in work-thread id"+Thread.currentThread().getName());
        long duration =(long) Math.random()*5;

        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
