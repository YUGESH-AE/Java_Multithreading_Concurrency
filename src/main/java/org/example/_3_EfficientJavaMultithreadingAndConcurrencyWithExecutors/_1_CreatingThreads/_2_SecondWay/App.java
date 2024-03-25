package org.example._3_EfficientJavaMultithreadingAndConcurrencyWithExecutors._1_CreatingThreads._2_SecondWay;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
            new SecondThread().start();
    }
}


class SecondThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            System.out.println("First Thread::"+i);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

