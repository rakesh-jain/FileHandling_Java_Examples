package com.filehandling.example;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
/*
 @author Rakesh R

 --Stream is the sequence of the data, it is composed of bytes.
 --OutputStream is the abstract class,it is the superclass for all classes for representing an output stream
    of bytes
   1.FileOutputStream
   2.ByteArrayOutputStream
   3.FilterOutputStream-1.DataOutputStream 2.BufferedOutputStream 3.PrintStream
   4.PipedOutputStream
   5.ObjectOutputStream

   // methods
   1. public void write(int) throws IOException
   2. public void write(byte[]) throws IOException
   3. public void flush()throws IOException
   4. public void close()throws IOException
   ......................................................
   --InputStream is the abstract class for all representing input stream of byte data.
    1.FileInputStream
   2.ByteArrayInputStream
   3.FilterInputStream-1.DataInputStream 2.BufferedInputStream 3.PushBackInputStream
   4.PipedInputStream
   5.ObjectInputStream

   ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
   --FileOutputStream is used to write the byte of data in file.
   -- it can be suitable for both byte oriented as well as character oriented but preferable to use FileWriter for character write
   --to write primitive values into a file
   //methods
   protected void finalize()- used to clean up the connection with the output stream
   1.void write(byte[] arr)
   2.void write(byte[] arr,int off,int len)
   3.FileChannel getChannel()-returns th file channel object associated with the file output stream
   4.FileDescriptor  getFD()- return the File descriptor
   5.void close()
 /////////////////////////////////////////////////////////////////////////////////////////
 --FileInputStream is used to read the byte data in the file for example reading raw data in video,image,audio etc.
 --FileInputStream is also preferred to use for character oriented but FileReader is the best Choice for reading for character oriented data
  //methods
  1. int read()
  2. int available()-return estimated number of bytes that can be read from the input stream
  3. int read(byte[])
  4, int read(byte[] arr, int off, int len)
  5. long skip(long x)-skip over and discards x bytes of data in the input stream
  6.FileChannel getChannel()
  7. FileDescriptor getFD()
  8. protected void finalize()-ensure the close method is called
  9. close()
     */

public class FileInOutPutStreamExample  {
    private static final String path="src/com/filehandling/example/Fileoutexamle.txt";
      static FileChannel fileChannel;
      static  FileOutputStream fileOutputStream;
      static FileInputStream fileInputStream;
    public static void main(String[] args)  {
        // FileOutPutStream example
        // writing
 //       writingdata();
        //using byte data
 //       String ans="hello my dear";
 //       bytedatawrite(ans.getBytes());
  //        readdata();
        offsetRead();


    }
    public static void bytedatawrite(byte[] arr){
        try {
            fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(arr);
            FileChannel channel = fileOutputStream.getChannel();
            System.out.println(channel);
            fileOutputStream.close();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        System.out.println("done byte");
    }

    public static void writingdata(){
        try{
            FileOutputStream outputStream=new FileOutputStream(path);
            outputStream.write(75);
            outputStream.close();
            System.out.println("success..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readdata(){
        try{
     fileInputStream=new FileInputStream(path);
           int read=fileInputStream.read();
          String s="";
            int i=fileInputStream.read();
            while((i=fileInputStream.read())!=-1){
                s+=(char)i;
            }
            System.out.println(s);
            fileInputStream.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
   public static void offsetRead(){
        try {
            fileInputStream = new FileInputStream(path);
            byte[] buffer=new byte[fileInputStream.available()];
            fileInputStream.read(buffer,0,6);
            int i=0;
            String s="";
            while((i=fileInputStream.read())!=-1){
                s+=(char)i;
            }
            System.out.println(s);
            fileInputStream.close();
        }catch (IOException e){
            System.out.println(e);
        }
   }
}
