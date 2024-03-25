package org.example._3_EfficientJavaMultithreadingAndConcurrencyWithExecutors._3_NamingThread._2_ExecutorNaming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool(new NamedThread());

        for(int i=0;i<5;i++){
            executorService.execute(new Loop());
        }
        executorService.shutdown();
    }
}

class Loop implements Runnable{

    private static int count =0;
    private int instanceNumber;
    private String taskId;


    @Override
    public void run() {



        System.out.println("#######["+Thread.currentThread().getName()+"]<<<<<<<<<<<<<< Task"+taskId+" Started >>>>>>>>>>>>>>>>>>>>");

        for(int i=0;i<10;i++){
            System.out.println("["+Thread.currentThread().getName()+"]< "+taskId+" >"+"Tick----"+i);

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("#######["+Thread.currentThread().getName()+"]"+"<<<<<<<<<<<<<< Task"+taskId+" Ended >>>>>>>>>>>>>>>>>>>>");

    }

    public Loop(){
        this.instanceNumber=++count;
        this.taskId="Loop"+instanceNumber;
    }
}


class NamedThread  implements ThreadFactory{

    private static int count=0;
    private  static String NAME="Pool-Worker";

    @Override
    public Thread newThread(Runnable r) {
            Thread t=new Thread(r, NAME+ ++count);
            return t;
    }
}
