package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._9_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    private static int counter = 0;
    private static Lock lock=new ReentrantLock();

    public static void increment(){
        lock.lock();
        for(int i=0;i<10000;i++)
            counter++;
        lock.unlock();
    }
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter::"+counter);
    }
}
