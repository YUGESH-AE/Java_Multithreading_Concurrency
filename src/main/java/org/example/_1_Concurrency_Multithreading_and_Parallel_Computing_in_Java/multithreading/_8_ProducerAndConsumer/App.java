package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._8_ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final Processor p=new Processor();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}


class Processor{

    private List<Integer> list=new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock=new Object();
    private int value=0;

    public void producer()throws InterruptedException{
        synchronized (lock){
            while (true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("Waiting for removing items");
                    lock.wait();
                }else {
                    System.out.println("Adding values::"+value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
    public void consumer() throws InterruptedException{
        synchronized (lock){
            while (true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("Waiting for adding items");
                    value=0;
                    lock.wait();
                }else {
                    System.out.println("Removing values::"+list.remove(list.size()-1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
