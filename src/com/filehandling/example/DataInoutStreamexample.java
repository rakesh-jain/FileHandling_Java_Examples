package com.filehandling.example;

import java.io.*;

/*
@author  Rakesh R
 data input and output stream is used to write and read the primitive data in stream.
 */
public class DataInoutStreamexample {
    private static final String path="src/com/filehandling/example/Fileoutexamle.txt";
    public static void main(String[] args) throws IOException {
    //writeData();
    readData();
    }
    public static void writeData()throws IOException {
        DataOutputStream stream=new DataOutputStream(new FileOutputStream(path));
        stream.write("hello i am rakesh".getBytes());
        stream.close();
    }
    public static void readData() throws IOException{
        DataInputStream dataInputStream=new DataInputStream(new FileInputStream(path));
        int i=0;
        while((i= dataInputStream.read())!=-1){
            System.out.print((char)i);
        }
        dataInputStream.close();
    }

}
