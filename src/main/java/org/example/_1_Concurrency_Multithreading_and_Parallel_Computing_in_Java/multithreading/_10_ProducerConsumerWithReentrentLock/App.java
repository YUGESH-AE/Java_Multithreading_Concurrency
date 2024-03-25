package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._10_ProducerConsumerWithReentrentLock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{

    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void produce()throws InterruptedException{
        lock.lock();
        System.out.println("Producer Method....");
        condition.await();
        System.out.println("Again the producer Method");
        lock.unlock();
    }
    public void consume()throws InterruptedException{
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer Method....");
        Thread.sleep(3000);
        condition.signal();
        lock.unlock();
    }
}
public class App {

    public static void main(String[] args) {

        final Worker worker=new Worker();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
    }
}
