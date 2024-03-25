package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._7_waitAndNotify;

public class App {
    public static void main(String[] args) {

        final Process p=new Process();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}


class Process{

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Running the producer method");
            wait();
            System.out.println("Again in the producer method");
        }
    }
    public void consume() throws InterruptedException{
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("consume method is executed");
            notify();
        }
    }
}
