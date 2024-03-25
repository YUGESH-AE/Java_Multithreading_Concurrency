package org.example._3_EfficientJavaMultithreadingAndConcurrencyWithExecutors._3_NamingThread._1_FirstMethod;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        new Thread(new Loop()).start();
        
    }
}

class Loop implements Runnable{

    private static int count =0;
    private int id;


    @Override
    public void run() {

        String currentThreadName=Thread.currentThread().getName();

        System.out.println("#######["+currentThreadName+"]<<<<<<<<<<<<<< Task"+id+" Started >>>>>>>>>>>>>>>>>>>>");

        for(int i=0;i<10;i++){
            System.out.println("< "+id+" >"+"Tick----"+i);

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("#######["+currentThreadName+"]"+"<<<<<<<<<<<<<< Task"+id+" Ended >>>>>>>>>>>>>>>>>>>>");

    }

    public Loop(){
        this.id=count++;
    }
}