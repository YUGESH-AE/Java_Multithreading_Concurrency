package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._5_synchronization;

public class App {

    public static int counter =0;

    public static synchronized void increment(){
        counter++;
    }
    public static void process(){

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;++i){
                    increment();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    increment();
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
        System.out.println("Counter::"+counter);
    }

    public static void main(String[] args) {
        process();
    }
}
