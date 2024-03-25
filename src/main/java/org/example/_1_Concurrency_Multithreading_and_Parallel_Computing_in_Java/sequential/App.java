package org.example._1_Concurrency_Multithreading_and_Parallel_Computing_in_Java.sequential;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Runner1 runner1=new Runner1();
        Runner2 runner2=new Runner2();

        runner1.execute();
        runner2.execute();
    }
}


class Runner1{

    public void execute(){
        for(int i=0;i<10;i++){
            System.out.println("Runner1::"+i+" "+ Runner1.class.getName());
        }
    }
}

class Runner2{

    public void execute(){
        for(int i=0;i<10;i++){
            System.out.println("Runner2::"+i+" "+Runner2.class.getName());
        }
    }
}