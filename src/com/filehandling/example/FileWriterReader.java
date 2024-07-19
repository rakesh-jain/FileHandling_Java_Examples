package com.filehandling.example;

import java.io.*;

public class FileWriterReader {
    private static final String path1="src/com/filehandling/example/Fileoutexamle.txt";
    public static void main(String[] args) throws IOException {
       // writeData();
        //appendData();
        //readData();

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bf.ready());
        char s=(char)bf.read();
        System.out.println(bf.ready());
        System.out.println(s);
    }
    public static void writeData()throws IOException {
        String path="E:/sample";
        new File(path).mkdir();
        System.out.println("directory Created");
        String filename="textexample.txt";
        File file =new File(path+filename);
        System.out.println("File Created ");
        FileWriter fileWriter=new FileWriter(file);
        String data="hello my name is Rakesh R i am Working as a software engineer in at enlight technology";
        fileWriter.write(data);
        fileWriter.close();
        file.setReadable(true);
        file.setWritable(true);
        System.out.println("completed");
    }
    public static void appendData() throws IOException {
        String path="E:/";
        String filename="textexample.txt";
        Writer writer=new FileWriter(path+filename);
        writer.append("hello i am good here");
        writer.close();
        System.out.println("done append");
    }
    public static void readData() throws  IOException{
        FileReader reader=new FileReader(new File(path1));
        int i= reader.read();
        while(i!=-1){
            System.out.print((char)i);
            i= reader.read();
        }
        reader.close();
        System.out.println("\ncomplete");
    }
}
