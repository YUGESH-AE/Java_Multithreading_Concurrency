package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._12_Livelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {

    private Lock lock1=new ReentrantLock(true);
    private Lock locl2=new ReentrantLock(true);
    public static void main(String[] args) {
        LiveLockExample liveLockExample=new LiveLockExample();
        new Thread(liveLockExample::worker1,"worker1").start();
        new Thread(liveLockExample::worker2,"worker2").start();
    }

    private void worker1(){
        while (true){
            try{
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker 1 acquires the 1 lock");
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("worker1 tries to get lock2");
            if(locl2.tryLock()){
                System.out.println("W");
            }
        }
    }

    private void worker2(){

    }
}
