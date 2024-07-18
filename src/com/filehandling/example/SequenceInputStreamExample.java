package com.filehandling.example;

import com.sun.net.httpserver.Authenticator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/*
SequenceInputStream is used to read the data from the multiple stream
 */
public class SequenceInputStreamExample {
    private static final String path="src/com/filehandling/example/Fileoutexamle.txt";
    private static final String path1= "src/com/filehandling/example/multi.txt";
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream1=new BufferedInputStream(new FileInputStream(path));
        BufferedInputStream bufferedInputStream2=new BufferedInputStream(new FileInputStream(path1));
        SequenceInputStream stream=new SequenceInputStream(bufferedInputStream1,bufferedInputStream2);
        int i=0;
        String s="";
        while ((i=stream.read())!=-1){
            s+=(char)i;
        }
        System.out.println(s);
        stream.close();
        bufferedInputStream1.close();
        bufferedInputStream2.close();
        {
            System.out.println("success");
        }
    }
}

