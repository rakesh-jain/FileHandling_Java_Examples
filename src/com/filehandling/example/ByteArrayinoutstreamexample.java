package com.filehandling.example;

import java.io.*;

/*
buffered output stream is used to write a data. it stores the data as a byte array, it will later it will write into multiple  streams
 */
public class ByteArrayinoutstreamexample {
    private static final String path="src/com/filehandling/example/Fileoutexamle.txt";
    private static final String path1= "src/com/filehandling/example/multi.txt";
    public static void main(String[] args) throws IOException {

        //writeData();
        readData();
    }

    public static void writeData()throws IOException{
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byteArrayOutputStream.writeBytes("hello ,my  name is rakesh R".getBytes());
        BufferedOutputStream file1 =new BufferedOutputStream(new FileOutputStream(path1));
        BufferedOutputStream file2=new BufferedOutputStream(new FileOutputStream(path));
        byteArrayOutputStream.writeTo(file1);
        byteArrayOutputStream.writeTo(file2);
        System.out.println(byteArrayOutputStream.size());
        file1.close();
        file2.close();
        byteArrayOutputStream.close();
        System.out.println("done");
    }
    public static void readData() throws IOException{
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(
                new BufferedInputStream(
                        new FileInputStream(path)
                ).readAllBytes());
        int i=0;
        while((i= byteArrayInputStream.read())!=-1){
            System.out.print((char)i);
        }
        byteArrayInputStream.close();
    }
}
