package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._4_ThreadPriority;

public class App {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runner1());
        Thread t2=new Thread(new Runner2());
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();

    }
}


class Runner1 implements Runnable{

    @Override
    public void run() {
        System.out.println("0"+Thread.currentThread().getName());
    }
}

class Runner2 implements Runnable{

    @Override
    public void run() {
        System.out.println("1"+Thread.currentThread().getName());
    }
}
