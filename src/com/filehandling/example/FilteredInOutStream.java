package com.filehandling.example;

import java.io.*;
import java.util.Arrays;

/*


@Author Rakesh R
 it provides functionality of both combined buffered output or input stream and  data output or input stream.
 it is less used individually.
 */
public class FilteredInOutStream {
    private static final String path="src/com/filehandling/example/Fileoutexamle.txt";

    public static void main(String[] args) throws IOException {
        readData();
    }
    public static void writeData() throws IOException {
        FilterOutputStream filterOutputStream=new FilterOutputStream(
                new FileOutputStream(path));
        filterOutputStream.write(
                "sdhjfhj".getBytes()
        );
        filterOutputStream.close();
        System.out.println("success");
    }
    public static void readData() throws IOException{
        FileInputStream fileInputStream=new FileInputStream(path);
        FilterInputStream filterInputStream=new BufferedInputStream(fileInputStream);
        int i=0;
        while((i= filterInputStream.read())!=-1){
            System.out.print((char)i);
        }
        filterInputStream.close();
        fileInputStream.close();
    }
}
