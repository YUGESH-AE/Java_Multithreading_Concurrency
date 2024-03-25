package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.multithreading._3_daemonThreadAndUserThreads;

/*
    Once after the normal thread stops execution then the jvm will terminate the daemon thread
    un till the normal thread is working the daemon thread will the alive
 */
public class App {
    public static void main(String[] args) {

        Thread t1=new Thread(new DaemonThread());
        Thread t2=new Thread(new NormalWorkerThread());
        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println(t1.isDaemon());
    }
}


class DaemonThread implements Runnable{

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon thread is Running........");
        }


    }
}

class NormalWorkerThread implements Runnable{

    @Override
    public void run() {


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Normal Worker thread is Running........");



    }
}
