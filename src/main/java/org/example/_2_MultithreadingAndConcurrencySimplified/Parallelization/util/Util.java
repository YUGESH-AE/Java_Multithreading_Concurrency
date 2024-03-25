package org.example._2_MultithreadingAndConcurrencySimplified.Parallelization.util;

import java.io.*;

public class Util {

    public static void copy(InputStream src, OutputStream des) throws IOException {
        int value;

        while ((value= src.read())!=-1){
            des.write(value);
        }
    }

    public static void copyFile(String src,String des){

        try(FileInputStream in=new FileInputStream(src);
            FileOutputStream out=new FileOutputStream(des);){

            copy(in,out);
            System.out.println("Done copying!!");

        }catch (Exception e){
            e.getMessage();
        }
    }
}
