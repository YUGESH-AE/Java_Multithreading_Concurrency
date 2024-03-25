package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.ExecutorFramework._4_CallableAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {

        List<Future<String>> futureList=new ArrayList<>();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for(int i=0;i<10;i++){
            Future<String>future=executorService.submit(new Processor(i+1));
            futureList.add(future);
        }
        futureList.forEach(e->
        {
            try {
                System.out.println(e.get());
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        });

        executorService.shutdown();
    }

}

class Processor implements Callable<String> {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "ID:"+id;
    }
}
