package org.example._2_MultithreadingAndConcurrencySimplified.Parallelization;

import org.example._2_MultithreadingAndConcurrencySimplified.Parallelization.util.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws Exception {

//        new Thread(new Copy()).start();
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        executorService.execute(new Copy());
        executorService.shutdown();
    }
}


class Copy implements Runnable{

    @Override
    public void run() {

        String src="C:\\Users\\ElumalaiY\\IdeaProjects\\Java_Multithreading_Concurrency\\src\\main\\java\\org\\example\\_2_MultithreadingAndConcurrencySimplified\\Parallelization\\source.txt";
        String des="C:\\Users\\ElumalaiY\\IdeaProjects\\Java_Multithreading_Concurrency\\src\\main\\java\\org\\example\\_2_MultithreadingAndConcurrencySimplified\\Parallelization\\destination.txt";

        Util.copyFile(src,des);
    }
}
