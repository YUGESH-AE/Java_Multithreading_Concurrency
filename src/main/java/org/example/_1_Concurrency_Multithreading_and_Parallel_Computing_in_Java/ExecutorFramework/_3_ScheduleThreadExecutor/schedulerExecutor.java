package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.ExecutorFramework._3_ScheduleThreadExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class schedulerExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(new StockMarketUpdater(),1000,2000,TimeUnit.MILLISECONDS);

    }
}


class  StockMarketUpdater implements Runnable{

    @Override
    public void run() {
        System.out.println("Updating and downloading stock related data from the web....");
    }
}