package org.example._3_EfficientJavaMultithreadingAndConcurrencyWithExecutors._1_CreatingThreads._3_ThirdWay;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        new Thread(new ThirdThread()).start();
    }
}

class ThirdThread implements Runnable{
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


