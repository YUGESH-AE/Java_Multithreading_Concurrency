package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._2_runnableInterface;

public class App {
    public static void main(String[] args) throws InterruptedException {

       Thread thread1=new Thread(new Runner1());
       Thread thread2=new Thread(new Runner2());

       thread1.start();
       thread2.start();

    }
}

class Runner1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner1::"+i+" ");
        }
    }
}

class Runner2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Runner2::"+i+" ");
        }
    }
}
