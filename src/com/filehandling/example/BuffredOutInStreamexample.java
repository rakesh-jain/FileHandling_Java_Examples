package com.filehandling.example;

import java.io.*;

/*
 @author Rakesh R
-- BufferedOutputStream adds the data directly into the  stream, it makes performance faster.
  // methods
  void write(int i)
  void write(byte[] b, int off, int len)
  void flush()
 */
public class BuffredOutInStreamexample {
    static final String path="src/com/filehandling/example/Fileoutexamle.txt";
    static FileInputStream fileInputStream;
    static FileOutputStream outputStream;
    static BufferedInputStream bufferedInputStream;
    static BufferedOutputStream bufferedOutputStream;
    public static void main(String[] args) {
    //writeData();
        readBufferedData();
    }
    public static void writeData(){
        try {
            outputStream = new FileOutputStream(path);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            String s="hello my dear student";
            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.close();
            outputStream.close();
            System.out.println("success");
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }
    public static void readBufferedData(){
        try{
            bufferedInputStream=new BufferedInputStream(new FileInputStream(path));
            int i=0;
            String s="";
            while ((i=bufferedInputStream.read())!=-1){
                s+=(char)i;
            }
            System.out.println(s);
            bufferedInputStream.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
