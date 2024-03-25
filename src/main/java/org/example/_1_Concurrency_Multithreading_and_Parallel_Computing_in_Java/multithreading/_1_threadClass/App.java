package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._1_threadClass;

public class App {
    public static void main(String[] args) {
        Runner1 runner1=new Runner1();
        Runner2 runner2=new Runner2();

        runner1.start();
        runner2.start();

        try {
            runner1.join();
            runner2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished with threads..........");
    }
}

class Runner1 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner1::"+i+" ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Runner2 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner2::"+i+" ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

