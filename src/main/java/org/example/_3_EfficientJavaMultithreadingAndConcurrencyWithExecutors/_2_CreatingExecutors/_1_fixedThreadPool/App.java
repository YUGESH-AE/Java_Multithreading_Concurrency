package org.example._3_EfficientJavaMultithreadingAndConcurrencyWithExecutors._2_CreatingExecutors._1_fixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        for(int i=0;i<6;i++){
            executorService.execute(new Loop());
        }

        executorService.shutdown();
    }
}


class Loop implements Runnable{

    private static int count =0;
    private int id;


    @Override
    public void run() {

        System.out.println("<<<<<<<<<<<<<< Task"+id+" Started >>>>>>>>>>>>>>>>>>>>");

        for(int i=0;i<10;i++){
            System.out.println("< "+id+" >"+"Tick----"+i);

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("<<<<<<<<<<<<<< Task"+id+" Ended >>>>>>>>>>>>>>>>>>>>");

    }

    public Loop(){
        this.id=count++;
    }
}
