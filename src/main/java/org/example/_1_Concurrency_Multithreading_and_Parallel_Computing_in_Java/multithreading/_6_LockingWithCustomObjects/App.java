package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._6_LockingWithCustomObjects;

public class App {

    private static  int increment1 = 0;
    private static  int increment2 = 0;

    private static final Object lock1=new Object();
    private static final Object lock2=new Object();

    public static void setIncrement1(){
        synchronized (lock1) {
            increment1++;
        }
    }
    public static void setIncrement2(){
        synchronized (lock2) {
            increment2++;
        }
    }

    public static void process(){
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    setIncrement1();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    setIncrement2();

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
        System.out.println("Count1::"+increment1);
        System.out.println("Count2::"+increment2);
    }

    public static void main(String[] args) {
        process();
    }
}
